package com.fc.springboot.webflux;

import static org.junit.Assert.fail;

import java.time.Duration;

import reactor.core.publisher.Flux;

public class TestWebflux {

	@org.junit.Test
	public void test() {
		fail("Not yet implemented");
	}
	@org.junit.Test
	public void testFlux() {
		Flux<Long> flux=flux();
		flux.take(3).subscribe(System.out :: println);
		System.out.println(flux);
	}
	public Flux<Long> flux(){
		return Flux.interval(Duration.ofMillis(5000),Duration.ofMillis(1000));
	}

}
