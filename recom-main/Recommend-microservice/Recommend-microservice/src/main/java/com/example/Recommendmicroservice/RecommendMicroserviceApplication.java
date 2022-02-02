package com.example.Recommendmicroservice;

import com.example.Recommendmicroservice.Entity.Recommend;
import com.example.Recommendmicroservice.Repository.RecommendRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.ConfigurableApplicationContext;

//@EnableEurekaClient

@SpringBootApplication
public class RecommendMicroserviceApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(RecommendMicroserviceApplication.class, args);
		RecommendRepo recommendRepo = configurableApplicationContext.getBean(RecommendRepo.class,args);
		recommendRepo.save(new Recommend(1L,11L,"akhil","goog",1));
	}


}
