package com.example.demo_data_rest.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.validation.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Configuration
public class ValidatorEventOrderRegistry implements InitializingBean {

    @Autowired
    private Map<String, Validator> validators;

    @Autowired
    private ValidatingRepositoryEventListener validatingRepositoryEventListener;

    @Override
    public void afterPropertiesSet() throws Exception {
        List<String> events = Arrays.asList("afterCreate");

        for(Map.Entry<String, Validator> entry : validators.entrySet()){

            events.stream().filter(e -> entry.getKey().startsWith(e))
                    .findFirst().ifPresent(p ->
                    validatingRepositoryEventListener
                            .addValidator(p, entry.getValue())
            );
        }
    }
}
