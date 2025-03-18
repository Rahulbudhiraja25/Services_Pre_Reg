package com.Gyanbox_Pre_Reg.Services.Services;

import com.Gyanbox_Pre_Reg.Services.DTO.Otp;
import com.Gyanbox_Pre_Reg.Services.Repository.GX_PR_OTP;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private GX_PR_OTP otpRepository;
    public void sendOtpMail(String to, String otp) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(to);
        helper.setSubject("Your OTP Code");
        helper.setText(getOtpTemplate(otp), true); // Send as HTML


        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, 5);
        Date expiryTime = calendar.getTime();

        Otp otpEntry = new Otp(to, otp, expiryTime);

        otpRepository.save(otpEntry);

        mailSender.send(message);
    }

    public boolean isOtpValid(String email, String enteredOtp) {
        Otp otpEntry = otpRepository.findByEmail(email);
        if (otpEntry == null) {
            return false;
        }

        Date now = new Date();
        return otpEntry.getOtpCode().equals(enteredOtp) && now.before(otpEntry.getOtpExpiry());
    }

    private String getOtpTemplate(String otp) {
        return String.format("""
        <html>
            <body style="font-family: Arial, sans-serif; text-align: center; padding: 20px;">
                <h2 style="color: #333;">Your OTP Code</h2>
                <p style="font-size: 18px;">Use the OTP below to proceed:</p>
                <div style="display: inline-block; font-size: 24px; font-weight: bold; color: #fff; 
                            background-color: #007bff; padding: 10px 20px; border-radius: 5px; 
                            margin: 20px;">
                    %s
                </div>
                <p>OTP will expire in 5 minutes</p>
                <p>If you didn’t request this, please ignore this email.</p>
            </body>
        </html>
        """, otp);
    }
}
