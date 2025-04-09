package dio.abel.springboot_jwt.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityService {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(auth ->
                auth
                        /*.requestMatchers(HttpMethod.GET,"").permitAll()
                        .requestMatchers(HttpMethod.GET,"").hasRole("")
                        .requestMatchers(HttpMethod.GET,"").hasAnyRole("")*/
                        .requestMatchers(HttpMethod.POST, "/users").permitAll()

                        .requestMatchers(HttpMethod.POST,"/login").permitAll()
                        .anyRequest().authenticated()
        ).httpBasic(Customizer.withDefaults());

        return httpSecurity.build();
    }
}
