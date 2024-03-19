package com.example.demo_exceptions.controller;

import com.example.demo_exceptions.exception.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class ExceptionRestController {

    @ResponseBody // va récupérer les datas brut de l'api
    @ExceptionHandler(ArithmeticException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handlerArithmeticException(ArithmeticException ex) {
        return "Oops, seems we have a match problem (I'm in the rest controller advice) " + ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(CustomException.class)
   // @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handlerCustomException(CustomException ex){
        return "Oops, seems we have a custom exception (I'm in the rest controller advice) " + ex.getMessage();
    }



}
