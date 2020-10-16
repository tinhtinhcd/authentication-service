package mp.group3.auth.config;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@ToString
@Component
@Data
public class JwtConfig {

    @Value("${security.jwt.uri}")
    private String Uri;

    @Value("${security.jwt.header}")
    private String header;

    @Value("${security.jwt.prefix}")
    private String prefix;

    @Value("${security.jwt.expiration}")
    private int expiration;

    @Value("${security.jwt.secret}")
    private String secret;

    @Value("${security.jwt.client}")
    private String client;

}
