package com.example.spring_security.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@AllArgsConstructor
public class BaseResponseDto {

    private Object message;
    private Object data;

    public BaseResponseDto(Object message) {
        this.message = message;
    }
}
