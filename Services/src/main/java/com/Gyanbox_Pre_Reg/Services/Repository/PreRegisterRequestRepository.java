package com.Gyanbox_Pre_Reg.Services.Repository;


import com.Gyanbox_Pre_Reg.Services.DTO.PreRegisterRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface PreRegisterRequestRepository extends JpaRepository<PreRegisterRequest, Long> {

    Optional<PreRegisterRequest> findByEmailId(String email); // ✅ Corrected method signature

    boolean existsByEmailId(String emailId); // ✅ Valid method to check if email exists
    }

