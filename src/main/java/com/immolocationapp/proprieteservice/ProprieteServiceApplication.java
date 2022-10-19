package com.immolocationapp.proprieteservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProprieteServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProprieteServiceApplication.class, args);
    }
   /* @Bean
    CommandLineRunner start (ApartmentRepository apartmentRepository){
        return args -> {
            for (int i = 0; i < 10; i++) {
                Apartment apartment = new Apartment();

            }

        }
    }*/
}


