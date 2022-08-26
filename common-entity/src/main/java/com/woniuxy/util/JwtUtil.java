package com.woniuxy.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;

public class JwtUtil {
    //密钥
    private static final String SECRET="woniuxy";
    //签发者
    private static final String ISSUSER="java";
    //过期时间
    private static final long EXPIRES=30*60*1000;

    //生产token
    public static String create(String uname){
        //指定加密算法
        Algorithm algorithm = Algorithm.HMAC256(SECRET);
        //当前时间
        Date now = new Date();
        //过期的时间
        Date expires = new Date(now.getTime() + EXPIRES);
        String jwt = JWT.create()
                .withIssuer(ISSUSER)        //指定签发人
                .withIssuedAt(now)          //签发时间
                .withExpiresAt(expires)     //过期时间
                .withClaim("uname", uname)  //将用户名作为自定义信息添加到载荷中
                .sign(algorithm);           //使用前面的参数和加密算法生产token

        return jwt;
    }

    //验证token是否有效
    public static boolean verify(String token){
        try {
            //加密算法
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            //生成验证器
            JWTVerifier verifier = JWT.require(algorithm).withIssuer(ISSUSER).build();
            //验证：验证失败抛异常
            verifier.verify(token);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    //获取加密参数
    public static String getUname(String token){
        try {
            //JWT反向解码，获取自定义信息
            return JWT.decode(token).getClaim("uname").asString();
        }catch (Exception ex){
            return "";
        }
    }
    //判断token是否过期
    public static boolean isExpires(String token){
        Date now = new Date();
        Date expires = JWT.decode(token).getExpiresAt();
        return now.after(expires);
//        if (now.after(expires)){
//            return true;
//        }
//        return false;
    }


    //不规范测试----速度更快
//    public static void main(String[] args) {
//        String token = JwtUtil.create("zs");
//        System.out.println("token="+token);
//        System.out.println("====验证token=====");
//        boolean verify = JwtUtil.verify(token);
//        System.out.println("验证token是否有效-结果："+verify);
//        System.out.println("验证token是否有效-结果："+verify(token));
//
//        System.out.println("======查看是否过期======");
//        boolean isExpires = JwtUtil.isExpires(token);
//        System.out.println("是否过期："+isExpires);
//    }

}
