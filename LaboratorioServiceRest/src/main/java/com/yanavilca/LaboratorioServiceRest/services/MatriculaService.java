package com.yanavilca.LaboratorioServiceRest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yanavilca.LaboratorioServiceRest.model.Matricula;
import com.yanavilca.LaboratorioServiceRest.repostories.MatriculaRepository;

@Service
public class MatriculaService {
	
	@Autowired
	private MatriculaRepository matriculaRepository;
	
	public List<Matricula> listar(){
		return matriculaRepository.listar();
	}
	
	public void crear(Matricula matricula) {
		matriculaRepository.crear(matricula);
	}

}
