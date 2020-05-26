package ru.af;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.af.dao.repo.UserRepository;
import ru.af.mvc.security.MyDatabaseUserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserRepository userRepository;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/resources/**","/users/adduser").permitAll() // No URL are available for all
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login") // Use spring default login page
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and()
                .httpBasic();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new MyDatabaseUserDetailsService(userRepository);
    }

    @Bean
    public PasswordEncoder myPasswordEncoderWhichReallyDoNotEncodeAnything() {
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence rawPassword) {
                return rawPassword.toString();
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return rawPassword.equals(encodedPassword);
            }
        };
    }
}
