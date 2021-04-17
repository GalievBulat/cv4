package com.kakadurf.cv4.framework_presentation.security;

import com.kakadurf.cv4.domain.entities.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class UserDetailsImpl implements UserDetails {
    public final UserEntity user;

    public UserDetailsImpl(UserEntity user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //TODO("authority")
        ArrayList<GrantedAuthority> list= new ArrayList<>();
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("USER");
        list.add(authority);
        return list;
    }

    @Override
    public String getPassword() {
        return user.getHashedPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
//TODO("Authentication")
    @Override
    public boolean isEnabled() {
        return true;
    }
}
