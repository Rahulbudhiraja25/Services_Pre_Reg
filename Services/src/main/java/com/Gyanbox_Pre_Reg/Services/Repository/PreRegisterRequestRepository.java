package com.Gyanbox_Pre_Reg.Services.Repository;


import com.Gyanbox_Pre_Reg.Services.DTO.PreRegisterRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PreRegisterRequestRepository extends JpaRepository<PreRegisterRequest, Long> {

        boolean existsByEmailId(String emailId); // ✅ Use Spring Data JPA method
    }

