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
public class ValidatorEventRegistry implements InitializingBean {

    // La liste des validateurs enregistrés dans Spring
    @Autowired
    private Map<String, Validator> validators; // spring validator

    //Un Objet qui permet d'enregistrer des validateurs dans les events des repos Spring data rest
    @Autowired
    private ValidatingRepositoryEventListener validatingRepositoryEventListener;

    @Override
    public void afterPropertiesSet() throws Exception {
        List<String> events = Arrays.asList("beforeCreate", "beforeDelete", "beforeSave", "beforeUpdate", "beforeLink");

        //pour chaque event que j'ai, il faudrait que je puisse que l'objet que je souhaite valider respecte mon validator (attention le validator est pour le repository)
        for(Map.Entry<String, Validator> entry : validators.entrySet()){
            // Pour chaque event, on cherche le validator qui commence par le meme nom que l'event et on l'ajoute dans l'event du repos
            events.stream().filter(e -> entry.getKey().startsWith(e))
                    .findFirst().ifPresent(p ->
                    validatingRepositoryEventListener
                            .addValidator(p, entry.getValue())
            );
        }
    }
}
