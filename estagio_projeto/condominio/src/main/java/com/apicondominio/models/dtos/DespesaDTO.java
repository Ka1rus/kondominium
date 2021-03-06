package com.apicondominio.models.dtos;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.apicondominio.models.TipoDespesa;

public class DespesaDTO {
	
	@NotNull
	private String nomeDespesa;
	@NotNull
	private Double valor;
	@NotNull
	private String descricao;
	@NotNull
	private List<TipoDespesa> tipoDespesas;
	public String getNomeDespesa() {
		return	 nomeDespesa;
	}
	
	public void setNomeDespesa(String nomeDespesa) {
		this.nomeDespesa = nomeDespesa;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public List<TipoDespesa> getTipoDespesas() {
		return tipoDespesas;
	}
	public void setTipoDespesas(List<TipoDespesa> tipoDespesas) {
		this.tipoDespesas = tipoDespesas;
	}
	
}
