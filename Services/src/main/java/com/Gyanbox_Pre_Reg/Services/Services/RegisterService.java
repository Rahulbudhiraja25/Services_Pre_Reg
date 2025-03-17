package com.Gyanbox_Pre_Reg.Services.Services;

import com.Gyanbox_Pre_Reg.Services.DTO.PreRegisterRequest;
import com.Gyanbox_Pre_Reg.Services.Repository.PreRegisterRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

@Autowired
    private PreRegisterRequestRepository preRegisterRequestRepository;


    public  String registerUser(PreRegisterRequest request) {
        if(preRegisterRequestRepository.existsByEmailId(request.getEmailId())){
//         if (preRegisterRequestRepository.emailExists(request.getEmailId())) {

        return "User already exists";
        }
        else {
            preRegisterRequestRepository.save(request);
            return "User Saved Successfully";
        }
    }
}
