package com.izzat.restapi;

import com.izzat.restapi.model.User;
import com.izzat.restapi.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class RestapiApplication {


    //http://localhost:8080/api/swagger-ui/index.html
    public static void main(String[] args) {
        SpringApplication.run(RestapiApplication.class, args);
    }

//    @Bean
//    CommandLineRunner commandLineRunner(UserRepository userRepository) {
//        return args -> {
//            userRepository.save(new User("Izzat", LocalDate.now().minusYears(20)));
//            userRepository.save(new User("Ranga", LocalDate.now().minusYears(30)));
//            userRepository.save(new User("Jim", LocalDate.now().minusYears(15)));
//        };
//    }
}
