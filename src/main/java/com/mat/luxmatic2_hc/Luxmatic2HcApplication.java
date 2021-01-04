package com.mat.luxmatic2_hc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class Luxmatic2HcApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Luxmatic2HcApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(Luxmatic2HcApplication.class, args);
    }
}
