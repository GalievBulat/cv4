package com.kakadurf.cv4.framework.controller.rest.task_cv;

import com.kakadurf.cv4.domain.entities.UserEntity;
import com.kakadurf.cv4.framework.data.transport.UserMapper;
import com.kakadurf.cv4.framework.security.UserDetailsImpl;
import freemarker.cache.ClassTemplateLoader;
import freemarker.core.ParseException;
import freemarker.template.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.*;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

@RestController
public class RestMailUserDetails {


    @Autowired
    private  JavaMailSender mailSender;
    @Autowired
    Configuration configuration;

    @GetMapping("/mail")
    @PreAuthorize("@JwtPopulation.inflateJwt(#security.user)")
    public ResponseEntity<?> mail(@AuthenticationPrincipal UserDetailsImpl security,
                                  @RequestParam String mail)  {
        try {
            ByteArrayOutputStream outputStream =  new ByteArrayOutputStream();
            Map<String, Object> root = new HashMap<>();
            root.put("user", UserMapper.INSTANCE.userToDto(security.user));
            Template temp = configuration.getTemplate("profile.ftl");

            Writer out = new OutputStreamWriter(outputStream);
            temp.process(root, out);

            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            String htmlMsg = new String(outputStream.toByteArray(), Charset.defaultCharset());
            helper.setText(htmlMsg, true);
            helper.setTo(mail);
            helper.setSubject("mail");
            helper.setFrom("abc@gmail.com");
            mailSender.send(mimeMessage);
            return ResponseEntity.ok().build();
        } catch (MessagingException e){
            throw new RuntimeException(e);
        } catch (TemplateException | IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().build();

    }
}
