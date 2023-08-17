package com.rootcodelabs.skackintmaven.hello;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/from-slack")
public class InteractiveController {

    @PostMapping("/")
    public ResponseEntity slackInteractive(){
        return ResponseEntity.ok("Interactive working");
    }
}
