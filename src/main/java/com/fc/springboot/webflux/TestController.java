package com.fc.springboot.webflux;

import java.time.Duration;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
public class TestController {

	@RequestMapping("test")
	public String test() {
		Flux<Long> flux=flux();
		final Flux<Long> t=flux.take(3);
        t.subscribe(new Subscriber<Long>() {

			@Override
			public void onComplete() {
				System.err.println("线程:"+Thread.currentThread().getName()+"完成");
			}

			@Override
			public void onError(Throwable arg0) {
				System.out.println("error");
			}

			@Override
			public void onSubscribe(Subscription arg0) {
				arg0.request(3);
			}

			@Override
			public void onNext(Long t) {
				System.out.println(Thread.currentThread().getName());
				System.out.println("next "+t);
			}
		});
        t.blockLast();
        System.out.println("complete");
        return "ok";
	}
	public Flux<Long> flux(){
		 return Flux.interval(Duration.ofMillis(1000),Duration.ofMillis(1000));
	}
	@RequestMapping("hello")
	public String hello() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "hello!";
	}
}
