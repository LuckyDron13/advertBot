package com.dron8.parserestate;

import com.dron8.parserestate.entity.Advertisement;
import com.dron8.parserestate.repository.AdvertisementRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ParserEstateApplication {
    private static final Logger log = LoggerFactory.getLogger(ParserEstateApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ParserEstateApplication.class, args);
    }
}
