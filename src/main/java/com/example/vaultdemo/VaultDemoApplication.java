package com.example.vaultdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class VaultDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(VaultDemoApplication.class, args);
	}

}


@RestController
class TestController {

	private final Environment environment;
	
	TestController(Environment environment) {
		this.environment = environment;
	}
	
	
	@GetMapping("/fetch/{key}")
	public String fetch(@PathVariable String key) {

		String value = environment.getProperty(key);
		return "Key-" +key + " : Value -" + value;
		
	}
}