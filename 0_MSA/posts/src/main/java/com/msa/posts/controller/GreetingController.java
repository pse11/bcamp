package com.msa.posts.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${server.port}")
    private String serverPort;

    private static final Log logger = LogFactory.getLog(GreetingController.class);

    @GetMapping("/posts/{id}") //{id}로 변수처리 여기있는 {id}를 아래의 매개변수로 주입시켜줘야함.
    public Map post(@PathVariable String id) { //위에 있는 id와 이름 맞춰줘야함.
        //System.out.println(serverPort);
        logger.info(serverPort+":posts() has been called");
        Post post = restTemplate.getForObject(
                "https://jsonplaceholder.typicode.com/posts/"+id, Post.class);
        //postId에 comments 정보를 같이 리턴하는 구조(map 사용)
        Comment[] comments = restTemplate.getForObject(
                "http://localhost:8082/comments/"+id, Comment[].class);
        Map result = new HashMap();
        result.put("post",post);
        result.put("comments",comments);
        return result;
    }
}