package application;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import rest.StorageService;

import javax.ws.rs.core.Application;

public class APIApplication {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);

    }

    @Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
            storageService.init();
        };
    }
}
