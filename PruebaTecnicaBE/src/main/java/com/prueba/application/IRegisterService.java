package com.prueba.application;

import java.util.List;

import com.prueba.domain.Register;
import com.prueba.domain.exception.RegisterNotFound;

public interface IRegisterService {
	
	public Register searchRegisterId(Long registerId) throws RegisterNotFound;

	public List<Register> searchRegisters();
}
