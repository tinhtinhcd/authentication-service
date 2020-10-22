package mp.group3.auth.dto;

import lombok.*;
import mp.group3.auth.entity.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.*;
import java.util.stream.Collectors;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JwtResponse implements OAuth2User {

	private Map<String, Object> attributes;
	private String name;
	private List<Role> roles;

	@Override
	public Map<String, Object> getAttributes() {
		if (this.attributes == null) {
			this.attributes = new HashMap<>();
			this.attributes.put("name", this.getName());
			this.attributes.put("roles", this.getRoles());
		}
		return attributes;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return AuthorityUtils.createAuthorityList(roles.stream().map(m->m.getName())
				.collect(Collectors.joining()));
	}

	@Override
	public String getName() {
		return name;
	}
}