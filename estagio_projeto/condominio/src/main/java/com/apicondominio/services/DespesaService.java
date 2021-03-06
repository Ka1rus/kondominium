package com.apicondominio.services;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apicondominio.models.Despesa;
import com.apicondominio.models.TipoDespesa;
import com.apicondominio.repositories.DespesaRepository;
import com.apicondominio.repositories.TipoDespesaRepository;

@Service
public class DespesaService {

	@Autowired
	private DespesaRepository despesaRepository;
	
	@Autowired
	private TipoDespesaRepository tipoDespesaRepository;
		
	public List<Despesa> findAll() {
		return despesaRepository.findAll();
	}

	public Optional<Despesa> findById(Integer id) {
		return despesaRepository.findById(id);
	}
	
	public Despesa create(Despesa despesa) {
		TipoDespesa tipoDespesa = tipoDespesaRepository.findById(despesa.getTipoDespesa().getId()).get();
		despesa.setTipoDespesa(tipoDespesa);
 		return despesaRepository.save(despesa);
	}

	public void delete(Integer id) {
		// Despesa despesa = despesaRepository.findById(id).get();
		// despesa.setTipoDespesa(null);
		despesaRepository.deleteById(id);
	}
	
}
