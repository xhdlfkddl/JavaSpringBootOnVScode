package com.koreait.board.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.koreait.board.filter.JwtAuthenticationFilter;

//? Spring의 Configuration으로 등록
@Configuration
//? WebSecurity와 관련된 작업
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired private JwtAuthenticationFilter jwtAuthenticationFilter;
    
    // Autowired 할 수 없는 것들을 처리할 때 사용 (= Bean)
    @Bean
    protected SecurityFilterChain configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .cors().and()
                .csrf().disable()
                .httpBasic().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                // 해당 두 작업에서는 인증 처리하지않겠다는 것
                .authorizeRequests().antMatchers("/auth/**", "/file/**").permitAll()
                // 나머지는 인증을 처리하겠다는 것
                .anyRequest().authenticated();
        
        httpSecurity.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();
    }

}
