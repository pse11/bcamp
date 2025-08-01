package com.comments.Comments.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @Autowired
    private RestTemplate restTemplate;

    private static final Log logger = LogFactory.getLog(GreetingController.class);
    @GetMapping("/comments/{postId}")
    public Comment[] comments(@PathVariable String postId) {
        logger.info("comments() has been called");
        Comment[] comments = restTemplate.getForObject(
                "https://jsonplaceholder.typicode.com/posts/"+postId+"/comments", Comment[].class);
        return comments;
    }

}