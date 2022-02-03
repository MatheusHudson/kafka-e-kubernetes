package br.com.academy.ratkovski.Poc.Java.Kafka.Producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PocJavaKafkaProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocJavaKafkaProducerApplication.class, args);
	}

}
