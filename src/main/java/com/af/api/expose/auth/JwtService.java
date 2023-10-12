package com.af.api.expose.auth;

import com.af.api.expose.annotation.ApiAfAnnotation;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtService implements IJwtService {
    @Value("${af.secretKey}")
    private String SECRET_KEY;
    @Value("${af.security.jwt.expiration}")
    private long jwtExpiration;

    @ApiAfAnnotation
    public String generateToken(String afUserName) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, afUserName, jwtExpiration);
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String afUsername = extractUsername(token);
        return (afUsername.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public LocalDate extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private String createToken(Map<String, Object> claims, String afUserName, long expiration) {
        Instant now = Instant.now();
        LocalDateTime expirationDateTime = LocalDateTime.ofInstant(now.plusMillis(expiration), ZoneId.systemDefault());

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(afUserName)
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(expirationDateTime.atZone(ZoneId.systemDefault()).toInstant()))
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).isBefore(LocalDate.now());
    }

    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}