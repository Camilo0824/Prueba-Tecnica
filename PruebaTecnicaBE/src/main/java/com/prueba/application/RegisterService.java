package com.prueba.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.domain.Register;
import com.prueba.domain.RegisterRepository;
import com.prueba.domain.exception.RegisterNotFound;

@Service
public class RegisterService implements IRegisterService{
	
	@Autowired
	private RegisterRepository registerRepo;
	
	@Override
	public Register searchRegisterId(Long registerId) throws RegisterNotFound {
		return registerRepo.findById(registerId).orElseThrow(()-> new RegisterNotFound(String.valueOf(registerId)));
	}

	@Override
	public List<Register> searchRegisters() {
		return registerRepo.findAll();
	}


}
