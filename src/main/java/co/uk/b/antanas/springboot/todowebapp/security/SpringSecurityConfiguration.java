package co.uk.b.antanas.springboot.todowebapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.function.Function;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfiguration {

    //LDAP or Database
    // In Memory

   // InMemoryUserDetailsManager inMemoryUserDetailsManager;

    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager() {
        UserDetails userDetails1 = createNewUser("Tony", "1122");
        UserDetails userDetails2 = createNewUser("Agatka", "1122");
        return new InMemoryUserDetailsManager(userDetails1, userDetails2);
    }

    private UserDetails createNewUser(String tony, String number) {
        Function<String, String> pswEncoderFunction = input -> passwordEncoder().encode(input);
        UserDetails userDetails = User.builder()
                .passwordEncoder(pswEncoderFunction)
                .username(tony)
                .password(number)
                .roles("USER", "ADMIN")
                .build();
        return userDetails;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // This redefines the security sequence....
    // All URLs are protected
    // A login form is shown for unauthorized requests
    // CSRF disable - Cross Site Request Forging -- to access H2
    // Allow Frames (Html in H2 makes use of Frames, that are not allowed by default in Spring Security
    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
        http.formLogin(withDefaults());

        http.csrf(AbstractHttpConfigurer::disable);
        http.headers(header -> header.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable));

        return http.build();
    }


}
