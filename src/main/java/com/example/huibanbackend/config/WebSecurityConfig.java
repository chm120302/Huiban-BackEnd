package com.example.huibanbackend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig{

    @Autowired
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    @Autowired
    private AuthenticationEntryPoint authenticationEntryPoint;

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;



    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }


    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring()
                .requestMatchers("/webjars/**")
                .requestMatchers("/swagger-ui/**", "/doc.html/**", "/v3/api-docs/**");
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("*"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }



    // 通过注册 SecurityFilterChain Bean 来配置 HTTP Security
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http    .httpBasic(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                //基于token，所以不需要session
                .sessionManagement(httpSecuritySessionManagementConfigurer -> httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .formLogin(Customizer.withDefaults())
                .authorizeHttpRequests(
                        request -> request
                                //对于登录login 允许匿名访问
                                .requestMatchers("/auth/login").anonymous()
                                // 给api赋权限
                                .requestMatchers("/api/users/changePassword").hasAuthority("1")
                                .requestMatchers("/api/users/update").hasAuthority("2")
                                .requestMatchers("/api/users").hasAuthority("3")
                                .requestMatchers("/api/users/list").hasAuthority("4")
                                .requestMatchers("/api/users/info").hasAuthority("5")
                                .requestMatchers("/api/users/{email}").hasAuthority("6")
                                .requestMatchers("/api/conferences/{conferenceId}/follow/sub").hasAuthority("7")
                                .requestMatchers("/api/conferences/{conferenceId}/follow/add").hasAuthority("8")
                                .requestMatchers("/api/conferences/{conferenceId}/attend/sub").hasAuthority("9")
                                .requestMatchers("/api/conferences/{conferenceId}/attend/add").hasAuthority("10")
                                .requestMatchers("/api/conferences/update").hasAuthority("11")
                                .requestMatchers("/api/conferences").hasAuthority("12")
                                .requestMatchers("/api/conferences/recentList").permitAll()
                                .requestMatchers("/api/conferences/popularList").permitAll()
                                .requestMatchers("/api/conferences/list").hasAuthority("15")
                                .requestMatchers("/api/conferences/list/{conferenceId}").hasAuthority("16")
                                .requestMatchers("/api/conferences/list/{conferenceId}/detail").hasAuthority("17")
                                .requestMatchers("/api/conferences/list/title/{title}").hasAuthority("18")
                                .requestMatchers("/api/conferences/list/sub/{sub}").hasAuthority("19")
                                .requestMatchers("/api/conferences/list/rank/{ccfRank}").hasAuthority("20")
                                .requestMatchers("/api/conferences/list/detail").hasAuthority("21")
                                .requestMatchers("/api/conferences/list/").hasAuthority("22")
                                .requestMatchers("/api/conferences/{conferenceId}").hasAuthority("23")
                                .requestMatchers("/api/conferences/allList").hasAuthority("40")
                                .requestMatchers("/api/comments/comment").hasAuthority("24")
                                .requestMatchers("/api/comments/{academicId}/comment").hasAuthority("25")
                                .requestMatchers("/api/comments/comment/{id}").hasAuthority("26")
                                .requestMatchers("/api/journals/{journalId}/follow/sub").hasAuthority("27")
                                .requestMatchers("/api/journals/{journalId}/follow/add").hasAuthority("28")
                                .requestMatchers("/api/journals/update").hasAuthority("29")
                                .requestMatchers("/api/journals").hasAuthority("30")
                                .requestMatchers("/api/journals/recentList").hasAuthority("31")
                                .requestMatchers("/api/journals/list").hasAuthority("33")
                                .requestMatchers("/api/journals/list/{journalId}").hasAuthority("34")
                                .requestMatchers("/api/journals/list/{journalId}/detail").hasAuthority("35")
                                .requestMatchers("/api/journals/list/sub/{sub}").hasAuthority("36")
                                .requestMatchers("/api/journals/list/rank/{ccfRank}").hasAuthority("37")
                                .requestMatchers("/api/journals/list/detail").hasAuthority("38")
                                .requestMatchers("/api/journals/{journalId}").hasAuthority("39")


                                // 允许OPTIONS请求访问
                                .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                                // 允许登录/注册接口访问
                                .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                                .requestMatchers(HttpMethod.POST, "/auth/register").permitAll()
                                .requestMatchers(HttpMethod.GET, "/auth/index").permitAll()

                                // 允许swagger访问
                                .requestMatchers("/swagger-ui/**").permitAll()
                                .requestMatchers("/doc.html/**").permitAll()
                                .requestMatchers("/v3/api-docs/**").permitAll()
                                .requestMatchers("/webjars/**").permitAll()
                                .anyRequest().authenticated()
                )


                // 在UsernamePasswordAuthenticationFilter之前添加自定义token前置过滤器
//                .addFilter(jwtAuthenticationTokenFilter)
                .cors(cors -> corsConfigurationSource())
                .addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class)
//                .cors(AbstractHttpConfigurer::disable)
                // 自定义认证失败和权限处理失败处理器
                .exceptionHandling(exceptions -> exceptions.authenticationEntryPoint(authenticationEntryPoint).accessDeniedHandler(accessDeniedHandler));


      return http.build();
    }







}