package com.universal_yazilim.bid.ysm.transaction_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class MicroserviceTransactionApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceTransactionApplication.class, args);
	}

}
