package com.Gyanbox_Pre_Reg.Services.Controllers;


import com.Gyanbox_Pre_Reg.Services.DTO.PreRegisterRequest;
import com.Gyanbox_Pre_Reg.Services.Services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

    @Autowired
    RegisterService registerService;

    @PostMapping("/user/register")
    public ResponseEntity<String> saveUser(@RequestBody PreRegisterRequest request){
        String resp;
        resp=registerService.registerUser(request);
    if(resp=="User Saved Successfully"){
        return ResponseEntity.ok("User Registered");
    }
    else {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Existing User");
    }
    }

}
