package com.example.demo_r2dbc.dao;

import com.example.demo_r2dbc.entity.Person;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Component
public class PersonDao {

    private final ConnectionFactory connectionFactory;

    private DatabaseClient databaseClient;

    public PersonDao(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
        databaseClient = DatabaseClient.create(connectionFactory);
        Mono result = databaseClient
                .sql("CREATE TABLE IF NOT EXISTS person(id int primary key auto_increment, firstname varchar(100), lastname varchar(100)); CREATE TABLE IF NOT EXISTS address (id int primary key auto_increment, full_Address varchar(100), person_Id int);")
                .then().doOnSuccess((Void) ->  {
                    System.out.println("Création de la table OK");
                }).doOnError((Void) ->  {
                    System.out.println("Création de la table Not OK");
                });
        result.subscribe(); // souscription importante afin de créer la table, tant qu'il n'y a pas de souscription, ile ne trouvera pas le thread
    }

    public Flux<Person> getAll(){
        return databaseClient.sql("SELECT * FROM person").fetch()
                .all()
                .map(m -> Person.builder()
                        .id(Long.parseLong(m.get("id").toString()))
                        .firstname(m.get("firstname").toString())
                        .lastname((m.get("lastname").toString()))
                        .build()); // la mapper récupère les données, c'est à nous de les caster (donner le type aux données)
    }

    public Mono add(String firstname, String lastname) {
        Map<String, Object> values = new HashMap<>();
        values.put("firstname", firstname);
        values.put("lastname", lastname);
        Mono result = databaseClient.sql("INSERT INTO person (firstname, lastname) values (:firstname, :lastname)")
                //.bind("firstname", firstname).bind("lastname", lastname)
                .bindValues(values)
                .then();
        return result;
    }

    public Mono delete(int id){
        return databaseClient.sql("DELETE FROM person where id=:id").bind("id", id).then();
    }

    public Mono update(int id, Person person) {
        Map<String, Object> values = new HashMap<>();
        values.put("id", id);
        values.put("firstname", person.getFirstname());
        values.put("lastname", person.getLastname());

        Mono result = databaseClient.sql("UPDATE person SET firstname=:firstname, lastname=:lastname WHERE id=:id")
                .bindValues(values)
                .then();

        return result;
    }

    public Mono<Person> getById(int id) {
        return databaseClient
                .sql("SELECT id, firstname, lastname FROM person WHERE id=:id")
                .bind("id", id)
                .fetch()
                .one()
                .map(m -> Person.builder()
                        .id(Long.parseLong(m.get("id").toString()))
                        .firstname(m.get("firstname").toString())
                        .lastname(m.get("lastname").toString())
                        .build());
        // bind is used for parameterizing the query, and map is used for transforming the result into the desired object type.
    }






}
