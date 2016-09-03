package com.pyda;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

/**
 * Created by jakubpyda on 03/09/16.
 */
@MessageEndpoint
public class ReservationProcessor {

	private final ReservationRepository reservationRepository;

	public ReservationProcessor(ReservationRepository reservationRepository) {
		this.reservationRepository = reservationRepository;
	}

	@ServiceActivator(inputChannel = "input")
	public void onNewReservation(String reservationName) {
		reservationRepository.save(new Reservation(reservationName));
	}
}
