package com.nttdata.bootcoindomain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * bootcoindomain.
 */
@EnableDiscoveryClient
@SpringBootApplication
public class BootcoindomainApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootcoindomainApplication.class, args);
	}

}
