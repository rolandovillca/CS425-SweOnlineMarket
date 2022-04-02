package edu.miu.cs.cs425.sweonlinemarketproject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, proxyTargetClass = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private UserDetailsService userDetailsService;

    public WebSecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(this.userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .headers()
                .frameOptions().sameOrigin()
                .and()
                .authorizeRequests()
                .antMatchers("/resources/static/**", "/images/**", "/css/**", "/onlinemarket/public/**").permitAll()
                .antMatchers("/", "/onlinemarket").permitAll()
                .antMatchers("/onlinemarket/secured/services/admin/**").hasRole("ADMIN")
                .antMatchers("/onlinemarket/secured/services/seller/**").hasRole("SELLER")
                .antMatchers("/onlinemarket/secured/services/buyer/**").hasRole("BUYER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/onlinemarket/public/login")
                .defaultSuccessUrl("/onlinemarket/secured/services")
                .failureUrl("/onlinemarket/public/login?error")
                .permitAll()
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/onlinemarket/public/logout"))
                .logoutSuccessUrl("/onlinemarket/public/login?logout")
                .permitAll()
                .and()
                .exceptionHandling();
    }
}
