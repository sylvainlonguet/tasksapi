package com.edu.tasksapi.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.edu.tasksapi.service.CustomUserDetailsService;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authz) -> authz
                        .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new PasswordEncoder() {

            @Override
            public String encode(CharSequence rawPassword) {
                return rawPassword.toString();
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return rawPassword.toString().equals(encodedPassword);
            }

        };
    }

    @Bean
    AuthenticationManager userTableAuthManager() {
        return new AuthenticationManager() {

            @Override
            public Authentication authenticate(Authentication authentication) throws AuthenticationException {
                // Utilisez votre service de gestion des utilisateurs pour effectuer
                // l'authentification
                // Personnalisez cette logique selon vos besoins
                // Vous pouvez également utiliser des objets AuthenticationToken personnalisés
                // si nécessaire

                // Exemple simple : chargez l'utilisateur par son nom d'utilisateur
                UserDetails userDetails = userDetailsService.loadUserByUsername(authentication.getName());

                // Vérifiez le mot de passe
                if (userDetails != null && userDetails.getPassword().equals(authentication.getCredentials())) {
                    // Créez une nouvelle instance d'Authentication avec les rôles de l'utilisateur
                    return new UsernamePasswordAuthenticationToken(
                            userDetails.getUsername(),
                            userDetails.getPassword(),
                            userDetails.getAuthorities());
                } else {
                    throw new BadCredentialsException("Invalid credentials");
                }
            }

        };

    }

}
