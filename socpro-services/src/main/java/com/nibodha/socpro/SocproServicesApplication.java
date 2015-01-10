package com.nibodha.socpro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class SocproServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SocproServicesApplication.class, args);
    }
}
