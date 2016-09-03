package com.pyda;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableBinding(value = ReservationChannels.class)
public class CoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoreApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ReservationRepository reservationRepository) {
		return strings -> Stream.of("Test", "Test 2 ", "rezerwacja ", "uczymy sie")
				.map(s -> reservationRepository.save(new Reservation(s)))
				.forEach(System.out::println);
	}
}
