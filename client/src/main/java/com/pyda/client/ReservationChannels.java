package com.pyda.client;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * Created by jakubpyda on 03/09/16.
 */

interface ReservationChannels {

	@Output
	MessageChannel output();
}
