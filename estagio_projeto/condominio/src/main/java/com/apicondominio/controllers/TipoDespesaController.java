package com.apicondominio.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.apicondominio.models.TipoDespesa;
import com.apicondominio.models.exceptions.TipoDespesaExistente;
import com.apicondominio.services.TipoDespesaService;

/**
 * Classe de controller para receber as requisições e retornar
 */
@RestController
@RequestMapping("/api/tipo_despesa")
public class TipoDespesaController {

	@Autowired
	private TipoDespesaService tipoDespesaService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<TipoDespesa> findAll() {
		return tipoDespesaService.findAll();
	}

	@GetMapping("/{id}")
	public TipoDespesa findById(@PathVariable Integer id) {
		return tipoDespesaService.findById(id).get();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public TipoDespesa create(@RequestBody TipoDespesa tipoDespesa) {
		Optional<TipoDespesa> tipoDespesaOpt = tipoDespesaService.findByNome(tipoDespesa.getNomeDespesa());
		if (tipoDespesaOpt.isPresent()) {
			throw new TipoDespesaExistente();
		}
		return tipoDespesaService.create(tipoDespesa);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		tipoDespesaService.delete(id);
	}

	@PutMapping("/{id}")
	public TipoDespesa update(@PathVariable Integer id, @RequestBody TipoDespesa tipoDespesa) {
		tipoDespesa.setId(id);
		return tipoDespesaService.create(tipoDespesa);
	}

}
