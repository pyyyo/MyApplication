package com.jay.application.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.jay.application.pojo.Users;

public class TokenUtils {
	/**
     * 生成token 的方法
     * @param user
     * @return
     */
    public static String getToken(Users user){
        String token = "";
        token = JWT.create().withAudience(user.getUserId().toString())
                .sign(Algorithm.HMAC256(user.getUserPassword()));
        return token;
    }
}
