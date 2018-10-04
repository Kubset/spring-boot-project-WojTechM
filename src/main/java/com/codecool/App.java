package com.codecool;


import it.ozimov.springboot.mail.configuration.EnableEmailTools;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableEmailTools
@SpringBootApplication
public class App {
    private static final Logger log = Logger.getLogger(App.class);

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    public static void log(String message) {
        log.info(message);
    }
}
