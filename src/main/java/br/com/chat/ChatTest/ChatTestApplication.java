package br.com.chat.ChatTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"br.com.chat.ChatTest", "br.com.chat.Controllers", "br.com.chat.Services"})
@EnableJpaRepositories(basePackages = "br.com.chat.Repository")
@EntityScan("br.com.chat.Models")
public class ChatTestApplication {

	// Version of application
	public static final String version = "1.0";

	public static void main(String[] args) {
		SpringApplication.run(ChatTestApplication.class, args);
	}

}
