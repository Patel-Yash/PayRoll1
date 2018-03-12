package com.brevitaz;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.brevitaz")
public class PayRollApplication {

    public static void main(String[] args) {
        SpringApplication.run(PayRollApplication.class, args);
    }
}




