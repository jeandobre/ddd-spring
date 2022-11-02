package com.ddd.spring;

import com.ddd.spring.application.Publisher;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@Slf4j
public class DddSpringApplication implements CommandLineRunner {

	@Autowired
	private ApplicationContext context;

	public static void main(String[] args) {

		SpringApplication.run(DddSpringApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		Publisher bean = context.getBean("publisher", Publisher.class);
		bean.sendMoney("Nova mensagem 0001", 25d, false);
		log.info("Inicializando módulo");
	}
}
