package com.example.bewerbungstest.domain.model.repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import java.time.LocalDateTime;



@Component
@AllArgsConstructor
@Getter
@Setter
//What Annotation to use for mongogb database entries as class? @Entity? no @Component? @Repository?
public class User {

    @Id
    private final String id ;

    private final String credentialName;


    public static final Mono<User> createUser(String Name){
        return Mono.just(new User((new ObjectId(String.valueOf(LocalDateTime.now())).toString()), Name));
    }

}
