package com.org.trs.repository;

import org.springframework.stereotype.Component;

/*This is User Repository Class*/
@Component
public class UserRepository {
    private String successMessage = "UserRepository.REGISTRATION_SUCCESS";

    public String registerUser(){
        return successMessage;
    }
}
