package com.apicondominio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apicondominio.models.TipoDespesa;
import com.apicondominio.repositories.TipoDespesaRepository;

@Service
public class TipoDespesaService {

	@Autowired
	private TipoDespesaRepository tipoDespesaRepository;
	
	public List<TipoDespesa> findAll() {
		return tipoDespesaRepository.findAll();
	}

	public TipoDespesa create(TipoDespesa tipoDespesa) {
		return tipoDespesaRepository.save(tipoDespesa);
	}

	public Optional<TipoDespesa> findById(Integer id) {
		return tipoDespesaRepository.findById(id);
	}

	public void delete(Integer id) {
		tipoDespesaRepository.deleteById(id);
	}
	
	public Optional<TipoDespesa> findByNome(String nomeDespesa) {
		return tipoDespesaRepository.findByNomeDespesa(nomeDespesa);
	}

}
