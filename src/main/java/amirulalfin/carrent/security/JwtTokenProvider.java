package amirulalfin.carrent.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.stream.Collectors;

@Component
public class JwtTokenProvider {
    @Value("${app.jwtSecret}")
    private String jwtSecret;
    @Value("${app.jwtExpirationInMs}")
    private Long jwtExpirationInMs;
    private final Key key;

    public JwtTokenProvider(@Value("${app.jwtSecret}") String jwtSecret) {
        this.key = Keys.hmacShaKeyFor(jwtSecret.getBytes());
    }

    public String generateToken(Authentication authentication) {
       String username = authentication.getName();
       String roles = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining(","));

        Date now = new Date();
        Date expiration = new Date(now.getTime() + jwtExpirationInMs);

        return Jwts.builder().setSubject(username).claim("roles",roles).setIssuedAt(new Date()).setExpiration(expiration).signWith(key).compact();
    }


}
