package com.Gyanbox_Pre_Reg.Services.Controllers;
import com.Gyanbox_Pre_Reg.Services.DTO.PreRegisterRequest;
import com.Gyanbox_Pre_Reg.Services.Repository.PreRegisterRequestRepository;
import com.Gyanbox_Pre_Reg.Services.Services.EmailService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.SecureRandom;
import java.util.Optional;


@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private PreRegisterRequestRepository preRegisterRequestRepository; // ✅ Inject repository
    @GetMapping("/send-otp")
    public String sendOtp(@RequestParam String email){
        String otp =generateOtp();
        try{

            emailService.sendOtpMail(email,otp);


            return "OTP Sent Successfully to "+email;
        }
        catch (MessagingException e){
            return "Error in sending OTP"+e.getMessage();
        }
    }


    @GetMapping("/verify/mail")
    public String verifyMail(@RequestParam String email,String otp){
        boolean result;
        result=emailService.isOtpValid(email,otp);
        if(result==true){

            Optional<PreRegisterRequest> userOptional = preRegisterRequestRepository.findByEmailId(email);
                    if(userOptional.isPresent()){
                        PreRegisterRequest user = userOptional.get();
                        user.setVerification(true); // ✅ Update verification flag
                        preRegisterRequestRepository.save(user); // ✅ Save the updated record
                        return "Email Verified Successfully!";
                    }
                    else {
                        return "User Not Found";
                    }

        }
        else {

            return "Incorrect Otp or some error occured";
        }

    }

    private String generateOtp() {
        SecureRandom random = new SecureRandom();
        int otp = 100000 + random.nextInt(900000); // Generates between 100000 - 999999
        return String.valueOf(otp);
    }

}
