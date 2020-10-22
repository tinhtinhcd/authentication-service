package mp.group3.auth.service;

import mp.group3.auth.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends UserDetailsService {
    UserDetails loadUserByUsername(String userName);
    User findByUsername(String username);
    User getUSerById(long id);
}
