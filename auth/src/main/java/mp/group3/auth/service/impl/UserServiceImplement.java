package mp.group3.auth.service.impl;

import mp.group3.auth.config.ConfigValue;
import mp.group3.auth.entity.User;
import mp.group3.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImplement implements UserService {

    public PasswordEncoder passwordEncoder;
    private ConfigValue configValue;
    private RestTemplate restTemplate;

    @Autowired
    public void setConfigValue(ConfigValue configValue) {
        this.configValue = configValue;
    }

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) {
        User user = findByUsername(userName);
        if (user == null || user.getId() == null || user.getUsername() == null) {
            throw new UsernameNotFoundException(userName);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                getAuthority(user));
    }

    @Override
    public User findByUsername(String name) {
        return restTemplate.getForObject(configValue.getUserUrl()+"/user/"+name, User.class);
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

//    public User testApi(String username, String token){
//        UriTemplateHandler url = restTemplate.getUriTemplateHandler();
//        url.expand("Authorization", token);
//        User test = restTemplate.getForObject(configValue.getUserUrl()+"/user/"+username, User.class);
//        return test;
//    }

}
