package projeto.integrador.equipe1.carrosluxo.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import projeto.integrador.equipe1.carrosluxo.Service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    AuthenticationManager authenticationManager;
    @Autowired
    private JwtRequestFilter jwtRequestFilter;
    @Autowired
    private UserService userService;

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userService);
        authenticationManager = authenticationManagerBuilder.build();
        http
                .cors()
                .configurationSource(corsConfigurationSource())
                .and()
                .csrf().disable()
                .exceptionHandling()
                .and()
                .authenticationManager(authenticationManager)
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeHttpRequests(
                        (authorize) -> authorize
                                .requestMatchers(HttpMethod.POST, "/auth").permitAll()
                                .requestMatchers(HttpMethod.POST, "/register").permitAll()
                                .requestMatchers(HttpMethod.GET, "/category").permitAll()
                                .requestMatchers(HttpMethod.GET, "/caracteristic").permitAll()
                                .requestMatchers(HttpMethod.GET, "/car").permitAll()
                                .requestMatchers(HttpMethod.GET, "/car/availability").permitAll()
                                .requestMatchers(HttpMethod.GET, "/city").permitAll()
                                .requestMatchers(HttpMethod.GET, "/image").permitAll()
                                .requestMatchers(HttpMethod.GET, "/category/**").permitAll()
                                .requestMatchers(HttpMethod.GET, "/caracteristic/**").permitAll()
                                .requestMatchers(HttpMethod.GET, "/car/**").permitAll()
                                .requestMatchers(HttpMethod.GET, "/city/**").permitAll()
                                .requestMatchers(HttpMethod.GET, "/image/**").permitAll()
                                .requestMatchers("/category/**", "caracteristic/**", "/car/**", "/city/**", "/image/**").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.GET, "/booking").hasAnyRole("ADMIN")
                                .requestMatchers(HttpMethod.POST, "/booking").hasAnyRole("USER", "ADMIN")
                                .requestMatchers(HttpMethod.GET, "/mybooking").hasAnyRole("USER", "ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/booking/**").hasAnyRole("USER", "ADMIN")
                                .requestMatchers(HttpMethod.GET, "/booking/**").hasAnyRole("USER", "ADMIN")
                                .anyRequest().permitAll()
                );
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
        http.headers().frameOptions().disable();
        return http.build();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedMethod("*");
        configuration.addAllowedOrigin("*");
        configuration.addAllowedHeader("*");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
