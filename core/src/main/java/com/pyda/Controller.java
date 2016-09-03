package com.pyda;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jakubpyda on 03/09/16.
 */
@RestController
@RefreshScope
public class Controller {
	private final String value;

	public Controller(@Value("${message}") String value) {
		this.value = value;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/message")
	String read() {
		return value;
	}

}
