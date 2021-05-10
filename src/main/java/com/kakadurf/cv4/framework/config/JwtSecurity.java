package com.kakadurf.cv4.framework.config;

import com.kakadurf.cv4.framework.jwt.JwtFilter;
import com.kakadurf.cv4.framework.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(1)
public class JwtSecurity extends WebSecurityConfigurerAdapter {
    @Autowired
    JwtProvider authenticationProvider;

    JwtFilter filterBean = new JwtFilter();

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/api/token");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/api/**").authorizeRequests().anyRequest().authenticated()
                .and()
                .csrf().disable()
                .formLogin().disable()
                .logout().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(filterBean, BasicAuthenticationFilter.class)
                .authenticationProvider(authenticationProvider)
                .httpBasic()
                .authenticationEntryPoint(apiAuthenticationEntryPoint());
    }

    @Autowired
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider);
    }
    @Bean
    @Qualifier("api")
    public AuthenticationEntryPoint apiAuthenticationEntryPoint(){
        BasicAuthenticationEntryPoint entryPoint =
                new BasicAuthenticationEntryPoint();
        entryPoint.setRealmName("api realm");
        return entryPoint;
    }
}
