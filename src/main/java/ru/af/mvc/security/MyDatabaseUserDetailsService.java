package ru.af.mvc.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.af.dao.entity.User;
import ru.af.dao.repo.UserRepository;

import java.util.Collections;

public class MyDatabaseUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public MyDatabaseUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByName(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found by name=" + username);
        }

        SimpleGrantedAuthority playerAuthority = new SimpleGrantedAuthority("ROLE_PLAYER");

        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                user.getName(), user.getPassword(),
                true, true, true,
                true, Collections.singleton(playerAuthority));

        return userDetails;
    }
}
