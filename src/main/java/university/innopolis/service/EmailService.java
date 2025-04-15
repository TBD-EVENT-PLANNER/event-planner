package university.innopolis.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import java.security.SecureRandom;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailService {
    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String from;

    // in-memory store for demo)
    private final Map<String, String> verificationCodes = new ConcurrentHashMap<>();

    private void sendConfirmationEmail(String to, String confirmationCode) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject("Email Confirmation");

        String htmlContent = "<div style='font-family: Arial, sans-serif; color: #333;'>"
            + "<h2 style='text-align: center; color: #4CAF50;'>Email Confirmation</h2>"
            +
            "<p style='text-align: center;'>Thank you for registering. Please use the following confirmation code to complete your registration:</p>"
            +
            "<div style='font-size: 24px; font-weight: bold; margin: 20px auto; padding: 10px; width: 150px; text-align: center; background-color: #f9f9f9; border: 2px solid #4CAF50; border-radius: 5px;'>"
            + confirmationCode
            + "</div>"
            + "<p style='text-align: center;'>If you did not register for this service, please ignore this email.</p>"
            + "<p style='text-align: center;'>Best regards,<br/>TBD Team</p>"
            + "</div>";
        helper.setText(htmlContent, true);

        mailSender.send(message);
        log.debug("Mail sent successfully to {}", to);
    }

    public void sendVerificationCode(String email) {
        String code = CodeGenerator.generate4DigitCode();
        verificationCodes.put(email, code);
        try {
            sendConfirmationEmail(email, code);
        } catch (MessagingException e) {
            log.error("Failed to send email to {}", email, e);
            throw new IllegalArgumentException("Email sending failed", e);
        }
    }

    public boolean verifyCode(String email, String code) {
        String correctCode = verificationCodes.get(email);
        if (correctCode != null && correctCode.equals(code)) {
            verificationCodes.remove(email); // one-time code
            return true;
        }
        return false;
    }

    private static class CodeGenerator {
        private static final SecureRandom random = new SecureRandom();

        public static String generate4DigitCode() {
            int code = 1000 + random.nextInt(9000); // 4-digit number
            return String.valueOf(code);
        }
    }
}

