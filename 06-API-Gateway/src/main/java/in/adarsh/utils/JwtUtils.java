package in.adarsh.utils;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtils {

	public static final String SECRET = "357638792F423F4428472B4B6250655368566D597133743677397A2443264629";
	
	private SecretKey getSignKey() {
	    return Keys.hmacShaKeyFor(SECRET.getBytes());
	}

	public void validateToken(String token) {
		Jwts.parser().setSigningKey(getSignKey()).parseClaimsJws(token); // throws exception if invalid
	}

	public String extractUsername(String token) {
		Claims claims = Jwts.parser().setSigningKey(getSignKey()).parseClaimsJws(token).getBody();
		return claims.getSubject();
	}
}
