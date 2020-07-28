package com.example.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginParam {

    private String phone;

    private String phoneCode;

    private String userName;

    private String password;

    private String Email;

    private String emailCode;




}
