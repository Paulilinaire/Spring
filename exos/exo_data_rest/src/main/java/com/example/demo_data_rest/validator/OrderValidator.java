package com.example.demo_data_rest.validator;

import com.example.demo_data_rest.entity.Candy;
import com.example.demo_data_rest.entity.CandyOrder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Objects;


@Component("afterCreateOrderValidator")
public class OrderValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return CandyOrder.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CandyOrder candyOrder = (CandyOrder) target;
        if(Objects.equals(candyOrder.getStatus(), "NEW")){
            System.out.println("Sending confirmation email to client");
        }
    }
}