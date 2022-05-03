package com.prueba;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.prueba.application.ILoadReadFileService;

@SpringBootApplication
public class PruebaTecnicaApplication implements CommandLineRunner{

	@Resource
	ILoadReadFileService iLoadReadFileService;

	public static void main(String[] args) {
		SpringApplication.run(PruebaTecnicaApplication.class, args);
	}
	
	@Override
	public void run(String... arg) throws Exception {
		iLoadReadFileService.createStorer();
	}
}
