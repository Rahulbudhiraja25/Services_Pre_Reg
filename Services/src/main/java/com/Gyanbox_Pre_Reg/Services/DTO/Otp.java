package com.Gyanbox_Pre_Reg.Services.DTO;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Otp {

    @Id
    private String email;

    private String otpCode;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date otpExpiry;


    public Otp() {
    }

    public Otp(String email, String otpCode, Date otpExpiry) {

        this.email = email;
        this.otpCode = otpCode;
        this.otpExpiry = otpExpiry;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOtpCode() {
        return otpCode;
    }

    public void setOtpCode(String otpCode) {
        this.otpCode = otpCode;
    }

    public Date getOtpExpiry() {
        return otpExpiry;
    }

    public void setOtpExpiry(Date otpExpiry) {
        this.otpExpiry = otpExpiry;
    }
}
