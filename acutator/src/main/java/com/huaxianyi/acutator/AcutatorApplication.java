package com.huaxianyi.acutator;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer
public class AcutatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(AcutatorApplication.class, args);
    }

}
