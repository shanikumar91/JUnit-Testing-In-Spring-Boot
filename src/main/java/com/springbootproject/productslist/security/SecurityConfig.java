package com.springbootproject.productslist.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity  http)throws Exception {
        http.csrf(csrf->csrf.disable())
                .authorizeHttpRequests(request->{
                    request.requestMatchers("/user/register","/user/login").permitAll();
                    request.requestMatchers(HttpMethod.GET,"/**").permitAll();
                    request.anyRequest().authenticated();
                })
                .oauth2ResourceServer( oauth2->oauth2.jwt(
                        jwtSpec->jwtSpec.jwtAuthenticationConverter(jwtAuthenticationConverter())
                ));


        return http.build();

    }
    private Converter<Jwt, ? extends AbstractAuthenticationToken> jwtAuthenticationConverter(){
        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new KeyCloakRoleReader());
        return  jwtAuthenticationConverter;
    }

}
