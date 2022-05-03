package com.prueba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.prueba.application.IRegisterService;
import com.prueba.domain.Register;

@RestController
@CrossOrigin("http://localhost:4200")
public class RegisterController {
	
	@Autowired
	private IRegisterService iRegisterService;

	@GetMapping("/registers")
	private List<Register> buscarArchivos() {
		try {
			List<Register> registers= iRegisterService.searchRegisters();
			return registers;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage(),e);
		}
		
	
	}
}
