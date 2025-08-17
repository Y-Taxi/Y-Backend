package com.example.ytaxi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class YTaxiApplication {

    public static void main(String[] args) {
        SpringApplication.run(YTaxiApplication.class, args);
    }

}
