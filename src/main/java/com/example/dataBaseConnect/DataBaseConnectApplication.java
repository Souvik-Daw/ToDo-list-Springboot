package com.example.dataBaseConnect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DataBaseConnectApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataBaseConnectApplication.class, args);
		System.out.println("Server Started at port 8080");
	}

}
