package com.example.backendspringsecurity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserLoginDto {
    private String email;
    private String password;

}
