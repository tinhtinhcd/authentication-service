package mp.group3.auth.dto;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class JwtResponse implements Serializable {
	private final String token;
	public JwtResponse(String token) {
		this.token = token;
	}
}