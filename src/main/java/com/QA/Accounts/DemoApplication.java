package com.QA.Accounts;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.stream.Stream;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    
    @Bean
    ApplicationRunner init(UserRepository repository) {
        return args -> {
            Stream.of("Adam", "Bob", "Charlie").forEach(firstName -> {
            	Stream.of("Smith", "Cooper", "Miller").forEach(lastName -> {
            		User user = new User();
            		user.setFirstName(firstName);
            		user.setLastName(lastName);
            		repository.save(user);          		
            	});
            }) ;
            repository.findAll().forEach(System.out::println);
        };
    }
}