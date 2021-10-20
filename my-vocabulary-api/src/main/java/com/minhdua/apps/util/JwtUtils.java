package com.minhdua.apps.util;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.minhdua.apps.document.User;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import reactor.core.publisher.Mono;

@Component
public class JwtUtils {
	@Value("${com.minhdua.apps.expire-time}")
	private String expireTimeMiliSec;
	@Value("${com.mindua.apps.secret-key}")
	private String secret;

	public String encoder(String key) {
		return Base64.getEncoder().encodeToString(key.getBytes());
	}

	public String generateToken(User user) {
		Map<String, Object> claims = new HashMap<>();
		claims.put("alg", "HS512");
		claims.put("typ", "JWT");
		return createToken(claims, user.getUsername());
	}

	public String createToken(Map<String, Object> claims, String subject) {
		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + Long.parseLong(expireTimeMiliSec)))
				.signWith(SignatureAlgorithm.HS512, encoder(secret)).compact();
	}

	public Mono<Claims> getClaimsFromToken(String token) {
		try {
			var jwt = Jwts.parser().setSigningKey(encoder(secret)).parseClaimsJws(token).getBody();
			return Mono.just(jwt);
		} catch (Exception e) {
			return Mono.error(e);
		}

	}

	public Mono<String> getUsernameFromToken(String token) {
		return getClaimsFromToken(token).map(Claims::getSubject);
	}

}