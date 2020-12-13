package com.gm.shuai_ping.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {

    /**
     * 设置过期时间
     * 一天
     */
    private static final long EXPIRE_TIME = 24*24*60*1000;

    /**
     * token私钥
     */
    private static final String TOKEN_SECRET = "liguangming";

    /**
     * 生成签名,一天后过期
     * @param userName
     * @return
     */
    public static String sign(String role,String userName){
        //通过token秘钥和加密算法生成一个Algorithm（算法对象）
        Algorithm algorithm=Algorithm.HMAC256(TOKEN_SECRET);
        //设置过期时间
        Date date=new Date(System.currentTimeMillis()+EXPIRE_TIME);
        //设置jwt的头信息
        Map<String,Object> header=new HashMap<>();
        header.put("typ","JWT");
        header.put("alg","HS256");
        //附带userName和role生成签名
        String token= JWT.create().withHeader(header)
                            .withClaim("role",role) //用户的身份：Admin，User，Enterprise
                            .withClaim("userName",userName) //用户的名字
                            .withExpiresAt(date) //过期时间
                            .sign(algorithm);   //算法

        //还有一种方法来创建token，它在maven引入了不同的依赖
        //然后token是用JWTS.builder来创建的
        //其实大同小异，jwt的字段都是一样的：Header，Payload，Signature
        return token;
    }

    /**
     * 验证签名
     */
    public static boolean verity(String token,String role){
        try {
            //我们先拿到我的算法
            Algorithm algorithm=Algorithm.HMAC256(TOKEN_SECRET);
            //通过我们的算法拿到JWT的验证器
            JWTVerifier verifier=JWT.require(algorithm).build();
            DecodedJWT jwt=verifier.verify(token); //这个我一直有点疑问，是怎么样验证的呢
            //验证不通过就会抛出异常
            System.out.println("token初步认证通过（但是不知道角色验证那一步通不通过）");

            Claim roleFromToken=jwt.getClaim("role");
            Claim userName=jwt.getClaim("userName");
            System.out.println("从token中解析出来的role：" + roleFromToken.asString());
            System.out.println("userName：" + userName.asString());
            System.out.println("过期时间："+jwt.getExpiresAt());

            //为了实现不同的身份，是不能跳去与它身份不同的页面的
            if(!roleFromToken.asString().equals(role)){
                return false;
            }

        } catch (IllegalArgumentException e) {
            return false;
        } catch (JWTVerificationException e) {
            return false;
        }
        return true;
    }
}
