package com.example.springbooot.util;

import cn.hutool.core.date.DateUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;

public class TokenUtil {

    public static String genToken(String userID,String sign){
        return JWT.create().withAudience(userID)//将user id保存到token里面，作为载荷
                    .withExpiresAt(DateUtil.offsetHour(new Date(),2))//2小时后token过期
                    .sign(Algorithm.HMAC256(sign));//将password作为token密钥
    }
}
