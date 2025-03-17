package com.Gyanbox_Pre_Reg.Services.DTO;


import jakarta.persistence.*;

@Entity
@Table(name = "pre_register_requests")
public class PreRegisterRequest {

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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false , unique = true)
    private String emailId;
    @Column(nullable = false)
    private String name;

    private boolean newsletterConsent;


    public PreRegisterRequest() {
    }
    public PreRegisterRequest(String emailId, String name, boolean newsletterConsent) {
        this.emailId = emailId;
        this.name = name;
        this.newsletterConsent = newsletterConsent;
    }
}
