package com.fc.springboot.webflux;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.time.Duration;

import org.junit.runner.RunWith;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import reactor.core.publisher.Flux;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.DEFINED_PORT)
public class TestWebflux {

	/*@Before
	public void init() {
		SpringApplication.run(TestWebflux.class);
	}*/
	@org.junit.Test
	public void test() {
		fail("Not yet implemented");
	}
	@org.junit.Test
	public void testFlux() {
		Flux<Long> flux=flux();
		final Flux<Long> t=flux.take(4);
		System.out.println("current thread:" +Thread.currentThread().getName());
        t.subscribe(new Subscriber<Long>() {

			@Override
			public void onComplete() {
				System.err.println("线程:"+Thread.currentThread().getName()+"完成");
			}

			@Override
			public void onError(Throwable arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSubscribe(Subscription arg0) {
				arg0.request(9);
			}

			@Override
			public void onNext(Long t) {
				System.out.println("doNext thread:"+Thread.currentThread().getName());
				/*System.out.println("next "+t);*/
			}
		});
        sleep();
	}
	public Flux<Long> flux(){
		System.out.println(Thread.currentThread().getName());
		return Flux.interval(Duration.ofMillis(5000),Duration.ofMillis(1000));
	}

	public void sleep() {
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
