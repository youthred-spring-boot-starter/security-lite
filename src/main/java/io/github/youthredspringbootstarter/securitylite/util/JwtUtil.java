package io.github.youthredspringbootstarter.securitylite.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import io.github.youthredspringbootstarter.securitylite.common.JWTConstant;
import io.github.youthredspringbootstarter.securitylite.o.User;

import java.sql.Date;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class JwtUtil {

    public static String sign(User user, Duration keepAlive) {
        JWTCreator.Builder builder = JWT.create();
        builder.withClaim("username", user.getUsername());
        builder.withExpiresAt(Date.from(LocalDateTime.now().plus(keepAlive).atZone(ZoneId.systemDefault()).toInstant()));
        return builder.sign(Algorithm.HMAC256(JWTConstant.SECRET_KEY));
    }
}
