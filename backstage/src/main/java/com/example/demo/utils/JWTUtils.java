package com.example.demo.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;


import java.util.Calendar;

import java.util.Map;


/**
 * @author: Auguste Zhao
 * @description: JWTUtils
 */
public class JWTUtils {

    /**
     * 签名
     */
    public static final String SIGN = "!Q@w3e4r%T^Ys";

    /**
     * 创建获取Token
     *
     * @param map
     * @return token
     */
    public static String getToken(Map<String, String> map) {
        // 有效期 7 天
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE, 1);

        // 创建jwt builder
        JWTCreator.Builder builder = JWT.create();

        // payload
        map.forEach((k, v) -> {
            builder.withClaim(k, v);
        });

        // 指定令牌过期时间
        String token = builder.withExpiresAt(instance.getTime())
                //sign
                .sign(Algorithm.HMAC256(SIGN));

        return token;
    }

    /**
     * 验证Token
     *
     * @param token
     */
    public static void verify(String token) {
        JWT.require(Algorithm.HMAC256(SIGN)).build().verify(token);
    }

    /**
     * 获取TokenID
     */
    public static String getTokenId(String token) {
        DecodedJWT verify = JWT.require(Algorithm.HMAC256(SIGN)).build().verify(token);
        return verify.getClaim("id").asString();
    }


    /**
     * 解密Token
     *
     * @param token
     * @return
     * @throws Exception
     */
//    public static Map<String, Claim> verifyToken(String token) {
//        String[] header = token.split("Bearer");
//        token = header[1];
//        DecodedJWT jwt = null;
//        try {
//            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
//            jwt = verifier.verify(token);
//        } catch (Exception e) {
//            // token 校验失败, 抛出Token验证非法异常
//            throw new TokenCheckException();
//        }
//        return jwt.getClaims();
//    }
//    /**
//     * 根据Token获取user_id
//     *
//     * @param token
//     * @return user_id
//     */
//    public static Long getAppUID(String token) {
//        Map<String, Claim> claims = verifyToken(token);
//        Claim user_id_claim = claims.get("user_id");
//        if (null == user_id_claim || StringUtils.isEmpty(user_id_claim.asString())) {
//            // token 校验失败, 抛出Token验证非法异常
//        }
//        return Long.valueOf(user_id_claim.asString());
//    }
//}

}
