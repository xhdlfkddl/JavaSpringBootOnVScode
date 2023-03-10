package com.koreait.board.provider;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.stereotype.Component;
// import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

// @Service
@Component
public class TokenProvider {
    
    // token은 문자열로 구성되어있기때문에 반환 타입은 String
    public String create() {
        
        // 과거에 사용한 방식
        // Date expireDate = new Date(); // 현재 날짜를 불러올 수 있음
        // expireDate.setHours(expireDate.getHours() + 1); 

        // 현재 시간을 불러올 수 있음
        Date expireDate = Date.from(Instant.now().plus(1, ChronoUnit.HOURS)); // 현재시간에 +1시간 된 값이 저장

        String jwt =
                    //? Jwt 클래스를 이용하여 JWT build (생성)
                    Jwts.builder()
                    //? 암호화 알고리즘, 암호화 할 때 사용할 키 (설정)
                    .signWith(SignatureAlgorithm.HS256, "SecureKey")
                    //? jwt sub의 값 지정
                    .setSubject("id")
                    //? jwt iat의 값 지정 (= 생성시간 설정)
                    .setIssuedAt(new Date())
                    //? jwt exp의 값 지정 (= 만료시간 설정)
                    .setExpiration(expireDate)
                    //? 암호화 알고리즘 암호화 키를 이용하여 지정한 값들을 토큰으로 변형
                    .compact();

        return jwt;

    }

    // 발급된 Token을 검증
    public String validate (String jwt) {

        // 매개변수로 받은 jwt를 소유하고 있는 SecureKey를 사용하여 복호화 (= Decoding)
        Claims claims = Jwts.parser()
                        // 암호화 할 때 사용할 키
                        .setSigningKey("SecureKey")
                        .parseClaimsJws(jwt)
                        .getBody();

        return claims.getSubject();
    }

}
