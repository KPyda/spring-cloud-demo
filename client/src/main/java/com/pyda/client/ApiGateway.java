package com.pyda.client;

import com.google.common.collect.Lists;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by jakubpyda on 03/09/16.
 */
@RestController
@RequestMapping("/reservation")
@Log4j
public class ApiGateway {

	private final ReservationReader reservationReader;
	private final ReservationWriter reservationWriter;

	public ApiGateway(ReservationReader reservationReader, ReservationWriter reservationWriter) {
		this.reservationReader = reservationReader;
		this.reservationWriter = reservationWriter;
	}

	public Collection<String> defaultFallback() {
		return Lists.newArrayList();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/names")
	@HystrixCommand(fallbackMethod = "defaultFallback")
	public Collection<String> names() {
		log.info("Getting names");
		return reservationReader.read()
				.getContent()
				.stream()
				.map(Reservation::getReservationName)
				.collect(Collectors.toList());
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void write(@RequestBody Reservation reservation) {
		reservationWriter.write(reservation.getReservationName());
	}
}
