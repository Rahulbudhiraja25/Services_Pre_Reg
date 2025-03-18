package com.Gyanbox_Pre_Reg.Services.DTO;

import jakarta.persistence.*;

@Entity
@Table(name = "pre_register_requests")
public class PreRegisterRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String emailId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false) // Default value will be set manually
    private boolean verification = false;

    private boolean newsletterConsent;

    // Constructors
    public PreRegisterRequest() {
        this.verification = false; // Ensure default value is set
    }

    public PreRegisterRequest(String emailId, String name, boolean newsletterConsent) {
        this.emailId = emailId;
        this.name = name;
        this.newsletterConsent = newsletterConsent;
        this.verification = false; // Default verification to false
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isNewsletterConsent() {
        return newsletterConsent;
    }

    public void setNewsletterConsent(boolean newsletterConsent) {
        this.newsletterConsent = newsletterConsent;
    }

    public boolean isVerification() {
        return verification;
    }

    public void setVerification(boolean verification) {
        this.verification = verification;
    }
}
