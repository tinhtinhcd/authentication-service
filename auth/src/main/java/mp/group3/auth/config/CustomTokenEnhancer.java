package mp.group3.auth.config;

import mp.group3.auth.entity.Privilege;
import mp.group3.auth.entity.User;
import mp.group3.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

@Component
public class CustomTokenEnhancer implements TokenEnhancer {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        Map<String, Object> additionalInfo = new HashMap<>();
        User user = userService.findByUsername(authentication.getName());
        additionalInfo.put("user_id", user.getId());
        List<Privilege> privileges = user.getRoles().stream()
                .map(u->u.getPrivileges()).flatMap(List::stream)
                .collect(Collectors.toList());
        additionalInfo.put("privileges", privileges);
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
        return accessToken;
    }
}
