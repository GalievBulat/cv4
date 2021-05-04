package com.kakadurf.cv4.framework.jwt;

import com.kakadurf.cv4.framework.security.UserDetailsImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
public class JwtAuth implements Authentication {
    private UserDetailsImpl user;
    private boolean isAuthenticated = false;
    private final String token;
    public JwtAuth(String token){
        this.token = token;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getAuthorities();
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return user;
    }

    @Override
    public boolean isAuthenticated() {
        return isAuthenticated;
    }

    @Override
    public void setAuthenticated(boolean b) throws IllegalArgumentException {
        isAuthenticated = b;
    }

    @Override
    public String getName() {
        return token;
    }

    public void setUser(UserDetailsImpl user) {
        this.user = user;
    }
}
