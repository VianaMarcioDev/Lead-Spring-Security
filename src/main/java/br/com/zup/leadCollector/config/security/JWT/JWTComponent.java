package br.com.zup.leadCollector.config.security.JWT;


import br.com.zup.leadCollector.config.security.JWT.exceptions.TokenInvalidoException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.UUID;

@Component
public class JWTComponent {

    @Value("${jwt.segredo}")
    private String segredo ;
    @Value("${jwt.milissegundo}")
    private Long milissegundo;

    public String gerarToken(String username, UUID id){
        Date vencimento = new Date(System.currentTimeMillis() + milissegundo);

        String token = Jwts.builder().setSubject(username)
                .claim("idUsuario", id)
                .setExpiration(vencimento)
                .signWith(SignatureAlgorithm.HS512, segredo.getBytes()).compact();
        return token;
    }

    public Claims pegarClaims(String token){
        try{
            Claims claims = Jwts.parser().setSigningKey(segredo.getBytes()).parseClaimsJws(token).getBody();
            return claims;
        }catch (Exception e){
            throw new TokenInvalidoException();
        }
    }
}
