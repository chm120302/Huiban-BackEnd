package com.example.huibanbackend.utils;


import cn.hutool.core.date.DateUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.ReactiveRedisOperations;

import java.util.Date;

@Slf4j
public class JwtTokenUtils {

    //额外的数据，越复杂越安全
    private static final String SING_VALUE = "ecnudzpdhuiban";

    // 过期时间
    private static ReactiveRedisOperations<Object, Object> redisTemplate;


    public static String getJwtToken(String email){
        String jwtToken = JWT.create()
                .withClaim("email", email)
                .withExpiresAt(DateUtil.offsetHour(new Date(), 1))
                .sign(Algorithm.HMAC256(SING_VALUE));
        return jwtToken;
    }

    public static boolean checkToken(String token){
        try{
            JWT.require(Algorithm.HMAC256(SING_VALUE)).build().verify(token);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public static String getEmailFromToken(String token){
        DecodedJWT verify = JWT.require(Algorithm.HMAC256(SING_VALUE)).build().verify(token);
        Claim claim = verify.getClaim("email");

        return claim.asString();
    }

}
