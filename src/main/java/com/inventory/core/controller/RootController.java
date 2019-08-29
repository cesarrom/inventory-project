package com.inventory.core.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.helpers.ResponseCanonical;

@RestController
@RequestMapping("/")
public class RootController {
	@GetMapping(path="/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseCanonical<String> heartBeat() {
        return new ResponseCanonical<String>("OK");
    }
}
