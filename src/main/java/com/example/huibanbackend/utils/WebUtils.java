package com.example.huibanbackend.utils;

import com.alibaba.fastjson2.JSON;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.io.IOException;
import java.util.Objects;

@Slf4j
public class WebUtils {

    /**
     * 获取Attributes
     *
     * @return ServletRequestAttributes
     */
    public static ServletRequestAttributes getRequestAttributes() {
        RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
        if(Objects.isNull(attributes)){
            log.error("WebUtils 获取到的RequestAttributes为空");
            throw new RuntimeException("WebUtils 获取到的RequestAttributes为空");
        }
        return (ServletRequestAttributes) attributes;
    }


    /**
     * 获取request
     *
     * @return HttpServletRequest
     */
    public static HttpServletRequest getRequest() {
        return getRequestAttributes().getRequest();
    }


    /**
     * 获取session
     *
     * @return HttpSession
     */
    public static HttpSession getSession() {
        return getRequest().getSession();
    }


    public static String getEmailFromHeader(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (Objects.isNull(token)) {
            return null;
        }
        token = token.substring(7);
        return JwtTokenUtils.getEmailFromToken(token);
    }



    /**
     * 将字符串渲染到客户端
     *
     * @param response 渲染对象
     * @param string   待渲染的字符串
     */
    public static void renderString(HttpServletResponse response, String string) {
        try {
            response.setStatus(200);
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
