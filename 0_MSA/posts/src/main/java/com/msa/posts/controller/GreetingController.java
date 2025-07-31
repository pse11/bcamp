package com.msa.posts.controller;

import java.util.concurrent.atomic.AtomicLong;

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
    //선언한 restemplate 주입
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/posts")
    public Post[] posts() {
        Post[] posts = restTemplate.getForObject(
                "https://jsonplaceholder.typicode.com/posts", Post[].class); //list보는 것이기 때문에 Post[]
        return posts;
    }

    @GetMapping("/posts/{id}") //{id}로 변수처리 여기있는 {id}를 아래의 매개변수로 주입시켜줘야함.
    public Post post(@PathVariable String id) { //위에 있는 id와 이름 맞춰줘야함.
        Post post = restTemplate.getForObject(
                "https://jsonplaceholder.typicode.com/posts/"+id, Post.class); //list보는 것이기 때문에 Post[]
        return post;
    }
}