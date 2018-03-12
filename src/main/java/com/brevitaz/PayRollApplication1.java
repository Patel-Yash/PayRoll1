package com.brevitaz;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.brevitaz")
public class PayRollApplication1 {

    public static void main(String[] args) {
        SpringApplication.run(PayRollApplication1.class, args);
    }
}




