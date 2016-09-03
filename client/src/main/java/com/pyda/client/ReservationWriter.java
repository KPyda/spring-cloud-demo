package com.pyda.client;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

/**
 * Created by jakubpyda on 03/09/16.
 */
@MessagingGateway
interface ReservationWriter {

	@Gateway(requestChannel = "output")
	void write(String name);
}
