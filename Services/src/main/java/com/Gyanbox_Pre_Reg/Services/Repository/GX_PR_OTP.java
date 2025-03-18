package com.Gyanbox_Pre_Reg.Services.Repository;

import com.Gyanbox_Pre_Reg.Services.DTO.Otp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GX_PR_OTP extends JpaRepository<Otp,String> {
    Otp findByEmail(String email);
    Otp save(Otp Otp);
}
