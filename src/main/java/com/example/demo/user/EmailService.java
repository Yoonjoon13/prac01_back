package com.example.demo.user;

import com.example.demo.common.exception.BaseException;
import com.example.demo.common.model.BaseResponseStatus;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EmailService {
    private final JavaMailSender mailSender;
    @Value("${spring.mail.username}")
    private String fromEmail;

    public String sendWelcomeMail(String uuid, String email){
        MimeMessage message  = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setTo(email);
            helper.setFrom(fromEmail);
            String subject = "[안녕] 환영";
            String htmlContents = "<a href='http://localhost:8080/user/verify?uuid="+uuid+"'>이메일 인증</a>";
            helper.setSubject(subject);
            helper.setText(htmlContents, true);
            mailSender.send(message);

            return uuid;
        } catch (Exception e) {
            throw BaseException.from(BaseResponseStatus.SIGNUP_EMAIL_SEND_FAIL);
        }
    }
}
