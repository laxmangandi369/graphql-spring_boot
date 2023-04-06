package com.graphqljava.tutorial.bookDetails.configuration;

import java.util.Date;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import com.graphqljava.tutorial.bookDetails.entity.MyUser;
import com.graphqljava.tutorial.bookDetails.exception.CustomException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtUtil {

	private static int tokenExpirationTime = 86400000;
	private static String jwtSecret = "qwerty123";
	
	public Claims getJwtClaims(String jwtToken) {
		Claims claims = null;
		
		try {
			claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(jwtToken).getBody();
		} catch (ExpiredJwtException e) {
			throw new CustomException("Token is expired");
		} catch ( MalformedJwtException e){
			throw new CustomException("Invalid Token");
		} catch(Exception e) {
			throw new CustomException("Internal server eroor while passing the token");
		}
		return claims;
	}
	
	public String generateToken(Authentication authentication) {
		MyUser user = (MyUser) authentication.getPrincipal();
		
		String authorities = authentication.getAuthorities().stream().map(GrantedAuthority :: getAuthority).collect(Collectors.joining(","));
		
		return Jwts.builder()
				.setHeaderParam("typ", "JWT")
				.setSubject(user.getUsername())
				.setIssuedAt(new Date(new Date().getTime() + tokenExpirationTime))
				.claim("roles", authorities)
				.signWith(SignatureAlgorithm.HS512,jwtSecret).compact();
	}
}
