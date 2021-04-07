package com.kakadurf.cv4.framework_presentation.security;

import com.kakadurf.cv4.framework_presentation.db_interface.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
@Qualifier("loginService")
@Component
public class UserDetailsImpl implements UserDetailsService {
    @Autowired
    UserManager userManager;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return new UserSecurity( userManager.findByEmail(s).orElseThrow(RuntimeException::new));
    }
}
