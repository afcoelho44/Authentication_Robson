package udesc.br.Authentication.Robson.security;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@AllArgsConstructor
public class JwtUtil {

    private final String SECRET = "secreta";
    private final long EXPIRATION_TIME = 1000 * 60 * 60;

    public String genereteToken(String username) {
    return Jwts.builder()
            .setSubject(username)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
            .signWith(SignatureAlgorithm.HS256, SECRET)
            .compact();
    }
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token);
            System.out.println("Token válido.");
            return true;
        } catch (Exception e) {
            System.out.println("Token inválido: " + e.getMessage());
            return false;
        }
    }

    public String extractUsername(String token) {
        try {
            String username = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody().getSubject();
            System.out.println("Extraído username: " + username);
            return username;
        } catch (Exception e) {
            System.out.println("Erro ao extrair username: " + e.getMessage());
            return null;
        }
    }
}
