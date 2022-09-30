package com.example.fileupload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableConfigurationProperties({
		FileStorageProperties.class
})
@EnableJpaRepositories("com.example.*")
@EntityScan("com.example.*")
@ComponentScan("com.example.*")
public class FileuploadApplication {


	public static void main(String[] args) {
		SpringApplication.run(FileuploadApplication.class, args);
	}

}
