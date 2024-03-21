package com.example.backendspringsecurity.dto;

import com.example.backendspringsecurity.model.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BaseResponseDto {
    private Object message;
    private Object data;
    private Roles roles;


}
