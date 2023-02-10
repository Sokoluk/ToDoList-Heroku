package ru.sokoluk.TodoList.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.Date;

@Component
public class JWTUtil {

    @Value("${jwt_secret}")
    private String secret;

    public String generateToken(String email, String password) {
        Date expirationDate = (Date) Date.from(ZonedDateTime.now().plusMinutes(60).toInstant());
        return JWT.create()
                .withSubject("Person Details")
                .withClaim("email", email)
                .withClaim("password", password)
                .withIssuedAt(new Date())
                .withIssuer("Sokoluk")
                .withExpiresAt(expirationDate)
                .sign(Algorithm.HMAC256(secret));
    }

    public String validateToken(String token) {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret))
                .withSubject("Person Details")
                .withIssuer("Sokoluk")
                .build();
        DecodedJWT jwt = verifier.verify(token);
        return jwt.getClaim("email" ).asString();
    }
}
