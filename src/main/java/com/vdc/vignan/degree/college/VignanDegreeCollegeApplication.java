package com.vdc.vignan.degree.college;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan(basePackages = "com.vdc.vignan.degree.college.entity")  // Correct package name (should be lowercase 'entity')
@ComponentScan(basePackages = "com.vdc.vignan.degree.college")
public class VignanDegreeCollegeApplication {
    public static void main(String[] args) {
        SpringApplication.run(VignanDegreeCollegeApplication.class, args);
        System.out.println("Application started successfully!");
    }
}