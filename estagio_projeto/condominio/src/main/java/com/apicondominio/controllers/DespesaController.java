package com.apicondominio.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.apicondominio.models.Despesa;
import com.apicondominio.services.DespesaService;

/**
 * Classe de controller para receber as requisições e retornar
 */
@RestController
@RequestMapping("api/despesa")
public class DespesaController {

	@Autowired
	private DespesaService despesaService;
	
	@GetMapping	
	@ResponseStatus(HttpStatus.OK)
	public List<Despesa> findAll() {
		return despesaService.findAll();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Despesa findById(@PathVariable Integer id) {
		return despesaService.findById(id).get();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Despesa create(@RequestBody Despesa despesa) {
		despesa.setDataReferencia(LocalDate.now());
		return despesaService.create(despesa);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		despesaService.delete(id);
	}

	@PutMapping("/{id}")
	public Despesa update(@PathVariable Integer id, @RequestBody Despesa despesa) {
		Despesa despesaExistente = despesaService.findById(id).get();
		BeanUtils.copyProperties(despesa, despesaExistente);
		despesa.setId(id);
		return despesaService.create(despesa);
	}
	
}
