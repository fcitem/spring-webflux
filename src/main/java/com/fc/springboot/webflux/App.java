package com.fc.springboot.webflux;

import java.time.Duration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import reactor.core.publisher.Flux;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class);
    }
    public void testFlux() {
		Flux<Long> flux=flux();
		flux.take(3).subscribe(System.out :: println);
		Flux.first(flux).toIterable().forEach(System.out::println);;
		System.out.println(flux);
	}
	public Flux<Long> flux(){
		return Flux.interval(Duration.ofMillis(5000),Duration.ofMillis(1000));
	}
}
