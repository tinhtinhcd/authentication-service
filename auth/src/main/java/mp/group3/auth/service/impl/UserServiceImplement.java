package mp.group3.auth.service.impl;

import mp.group3.auth.entity.User;
import mp.group3.auth.repository.UserRepository;
import mp.group3.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class UserServiceImplement implements UserService {

    UserRepository userRepository;
    public PasswordEncoder passwordEncoder;

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) {
        Optional<User> user = userRepository.findUsersByUsername(userName);
        if (!user.isPresent()) {
            throw new UsernameNotFoundException(userName);
        }
        User u = user.get();
        return new org.springframework.security.core.userdetails.User(u.getUsername(), u.getPassword(),
                getAuthority(user.get()));
    }

    private Set getAuthority(User user) {
        Set authorities = new HashSet();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
            role.getPrivileges().forEach(pr->{
                authorities.add(new SimpleGrantedAuthority("PRIVILEGE_" + pr.getName()));
            });
        });
        return authorities;
    }

    public User findByUsername(String username) {
        return userRepository.findUsersByUsername(username).get();
    }

    @Override
    public User getUSerById(long id) {
        return userRepository.findById(id).get();
    }
}
