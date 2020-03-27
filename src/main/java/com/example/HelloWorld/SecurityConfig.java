package com.example.HelloWorld;

import org.springframework.security.authorization.AuthenticatedReactiveAuthorizationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    protected void Configure(HttpSecurity http) throws Exception {

        http.
                authorizeRequests()
                .mvcMatchers( "/actuator/info", "actuator/health").permitAll()
                .mvcMatchers( "/user/operator").hasRole("OPERADOR")
                .mvcMatchers("/user/dba").hasRole("DBA")
                .mvcMatchers( "/user/*").authenticated()
                .and().formLogin();

    }

    public void configure(WebSecurity web) throws Exception {
        web.ignoring().mvcMatchers("/user/freeaccess");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser("USEROP").password(encoder.encode("PASS")).roles("OPERATOR").and()
                .withUser("USERDBA").password(encoder.encode("PASS")).roles("DBA");
    }
}
