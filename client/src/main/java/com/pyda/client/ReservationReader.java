package com.pyda.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by jakubpyda on 03/09/16.
 */
@FeignClient("reservation-service")
interface ReservationReader {

	@RequestMapping(method = RequestMethod.GET, value = "/reservations")
	Resources<Reservation> read();
}
