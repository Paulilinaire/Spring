package com.example.exo_spring_reactive.dao;

import com.example.exo_spring_reactive.model.Message;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.stereotype.Component;
import org.springframework.r2dbc.core.DatabaseClient;
import reactor.core.publisher.Mono;

@Component
public class MessageDao {

    private final ConnectionFactory connectionFactory;

    private DatabaseClient databaseClient;

    public MessageDao(ConnectionFactory connectionFactory){
        this.connectionFactory = connectionFactory;
        databaseClient = DatabaseClient.create(connectionFactory);
        Mono result = databaseClient
                .sql("CREATE TABLE IF NOT EXISTS message(id int primary key auto_increment, content varchar(300), time DATETIME, username varchar(100));")
                .then().doOnSuccess((Void) ->  {
                    System.out.println("Création de la table OK");
                }).doOnError((Void) ->  {
                    System.out.println("Création de la table Not OK");
                });
        result.subscribe();
    }
}