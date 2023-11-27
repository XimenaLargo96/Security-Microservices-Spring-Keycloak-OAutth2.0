package com.msbills;

import com.msbills.models.Bill;
import com.msbills.repositories.BillRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableEurekaClient
@SpringBootApplication
@EnableJpaRepositories
public class MsBillsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsBillsApplication.class, args);
    }
    @Bean
    public CommandLineRunner loadData(BillRepository repository) {
        return (args) -> {
            if (!repository.findAll().isEmpty()) {
                return;
            }
            repository.save(new Bill( "9e814b0d-3a94-4811-9386-53aa3706beec", "courses/Java", 500.0));
            repository.save(new Bill("9e814b0d-3a94-4811-9386-53aa3706beec", "courses/Java", 500.0));
            repository.save(new Bill( "9e814b0d-3a94-4811-9386-53aa3706beec", "courses/Java", 500.0));
        };
    }

}
