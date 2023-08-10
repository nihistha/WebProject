package com.hotelbook.hotelbook.security;


import com.hotelbook.hotelbook.service.ServiceImpl.CustomUserDetailsService;
import com.hotelbook.hotelbook.utils.PasswordEncoderUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor

public class SecurityConfig {

    private final CustomUserDetailsService customUserDetailsService;

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(customUserDetailsService);
        authenticationProvider.setPasswordEncoder(PasswordEncoderUtil.getInstance());
        return authenticationProvider;
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws  Exception{
        httpSecurity.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/login","/signup/**","/create","/images/**","/js/**","/home","/css/**")
                .permitAll()
                .requestMatchers("/admin/**")
                .hasAuthority("ROLE_ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/home",true)
        ;

        return httpSecurity.build();
    }
}
