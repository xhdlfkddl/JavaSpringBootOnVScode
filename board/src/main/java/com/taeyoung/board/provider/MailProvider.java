package com.taeyoung.board.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

// 해당 로직을 사용하려면 aplication.properties
@Component
public class MailProvider {
    
    @Autowired private JavaMailSender javaMailSender;

    public boolean sendMail() {
        try {
            
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            // 발신자 메일 주소
            simpleMailMessage.setFrom("${spring.mail.username}");
            // 수신자 메일 주소
            simpleMailMessage.setTo("xhdlfkddl@naver.com");
            // 메일 제목
            simpleMailMessage.setSubject("메일 제목입니다.");
            // html 형식의 내용
            simpleMailMessage.setText("메일 내용입니다.");
            // 전송
            javaMailSender.send(simpleMailMessage);
            
        } catch (Exception exception) {
            
            exception.printStackTrace();
            return false;
            
        }
        
        return true;
    }

}
