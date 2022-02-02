package com.example.Recommendmicroservice.Controller;

import com.example.Recommendmicroservice.Entity.Recommend;
import com.example.Recommendmicroservice.Service.RecommendService;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/recommend")
public class RecommendController {

    @Autowired
    RecommendService recommendService;



     RestTemplate restTemplate = new RestTemplate();

     @GetMapping("/{id}")
     public Optional<Recommend> getRecommendById(@PathVariable("id") long recommendationId)
     {
         return recommendService.getRecommendById(recommendationId);
     }




    @PostMapping("/post")
    public Recommend addRecommend(@RequestBody Recommend recommend)
    {
        return recommendService.addRecommend(recommend);
    }


    private static final String MAIN_SERVICE = "mainService";

    @GetMapping("/test")
    @ResponseStatus(HttpStatus.OK)
    @CircuitBreaker(name = MAIN_SERVICE, fallbackMethod="testFallBack")
    public ResponseEntity<String> test(){
        String response = restTemplate.getForObject("http://localhost:8081/products/all", String.class);
        return new ResponseEntity<String>(response, HttpStatus.OK);

    }
    private ResponseEntity<String> testFallBack(Exception e){
        return new ResponseEntity<String>("In fallback method", HttpStatus.INTERNAL_SERVER_ERROR);}






    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Recommend> getAllRecommend()
    {
        return recommendService.getAllRecommend();
    }

    @PutMapping("/update/{id}")
    public Recommend updateRecommend(@RequestBody Recommend recommend,@PathVariable("id") long recommendationId)
    {
        return recommendService.updateRecommend(recommend,recommendationId);
    }


    @DeleteMapping("/delete/{id}")
    public String deleteRecommend(@PathVariable("id") long recommendationId)
    {
        recommendService.deleteRecommendById(recommendationId);
        return "Recommend of ID " + recommendationId +" is deleted.";
    }


}
