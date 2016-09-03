package com.pyda;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by jakubpyda on 03/09/16.
 */
public interface ReservationChannels {

	@Input
	SubscribableChannel input();
}
