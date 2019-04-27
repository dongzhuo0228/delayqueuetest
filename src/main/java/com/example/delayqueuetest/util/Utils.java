package com.example.delayqueuetest.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class Utils {

    public static String createToken(String userId) {
        return JWT.create().withAudience(userId).sign(Algorithm.HMAC256(userId));
    }

    public static boolean parseToken(String token) {
        String userId = JWT.decode(token).getAudience().get(0);
        if (userId == null) {
            return false;
        }
        return true;
    }
}
