package br.com.hominid.soothe.infra.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/soothe/person").authenticated()
                .antMatchers("/soothe/homeGroup").authenticated()
                .antMatchers("/soothe/pet").authenticated()
                .antMatchers("/soothe/event").authenticated()
                .antMatchers("/").permitAll()
                .antMatchers("/user").authenticated()
                .antMatchers("/admin").authenticated();
        http.formLogin();
        http.httpBasic();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
