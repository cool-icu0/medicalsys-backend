package com.example.medicalsysbackend.domain.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserLoginRequest implements Serializable {
    String userAccount;
    String password;
    private static final long serialVersionUID = 3191241716373120793L;
}
