package com.example.demo_h2database.mapper;

import com.example.demo_h2database.entity.Cat;
import com.example.demo_h2database.model.CatDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;


import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

@Mapper(componentModel = "spring")
public interface CatMapper {

    @Mapping(source="name", target = "nickname") // on précise quel propriété Dto correspond à celle dans Entity
    @Mapping(source = "birthDate", target = "age", qualifiedByName = "convertDateToAge")// pareil ici, il n'y a pas d'age dans Entity mais depuis la date de naissance on peut devier l'age
    CatDto catToCatDto(Cat cat);

    @Mapping(source = "nickname", target = "name")
    Cat catDtoToCat(CatDto catDto);

    @Named("convertDateToAge")
    public static int convertDateToAge(Date date) {
        LocalDate birthDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate currentDate = LocalDate.now();

        Period period = Period.between(birthDate, currentDate);
        return period.getYears();
    }


}
