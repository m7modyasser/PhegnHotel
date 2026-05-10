package com.phegondev.phegnhotel.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.core.internal.Function;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;

@Service
public class JWTUtils {

    private static final long EXPIRATION_TIME = 1000*60*24*7;
    private  final SecretKey key;

    public JWTUtils() {
        String secreteString="94c89d1bb9823e2e951fa9e37331fc066ae477f7ecadbd8cc798b173d78bfc03";
        byte[]keyBytes= Base64.getDecoder().decode(secreteString.getBytes(StandardCharsets.UTF_8));
        this.key=new SecretKeySpec(keyBytes,"HmacSHA256");

    }
    public String generateToken(UserDetails userDetails){
        return Jwts.builder()
                .subject(userDetails.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+EXPIRATION_TIME))
                .signWith(key)
                .compact();
    }
    public String extractUsername(String token){
        return extractClaims(token, Claims::getSubject);
    }
    private <T> T extractClaims(String token, Function<Claims, T> claimsTFunction) {
        return claimsTFunction.apply(Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload());

    }
    public boolean isValidToken(String token,UserDetails userDetails){
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && ! isTokenExpired(token));
    }
    private boolean isTokenExpired(String token){
        return extractClaims(token,Claims::getExpiration).before(new Date());
    }
}
