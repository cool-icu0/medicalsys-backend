package com.example.medicalsysbackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.medicalsysbackend.mapper")
public class MedicalsysBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedicalsysBackendApplication.class, args);
    }

}
