package com.kakadurf.cv4.framework.jwt;

import com.kakadurf.cv4.domain.entities.UserEntity;
import com.kakadurf.cv4.framework.security.UserDetailsImpl;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

//@Component
public class JwtProvider implements AuthenticationProvider {
    @Value("${secret_key}")
    private String key;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String token = authentication.getName();
        try {
            Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
            UserDetailsImpl details = new UserDetailsImpl(UserEntity.builder()
                    .id(Long.parseLong(claims.get("sub",String.class)))
                    .name(claims.get("name",String.class)).build());
            authentication.setAuthenticated(true);
            ((JwtAuth)authentication).setUser(details);
            return authentication;
        } catch (Exception e){
            throw new AuthenticationCredentialsNotFoundException("Bad token");
        }

    }

    @Override
    public boolean supports(Class<?> aClass) {
        return JwtAuth.class.equals(aClass);
    }
}
