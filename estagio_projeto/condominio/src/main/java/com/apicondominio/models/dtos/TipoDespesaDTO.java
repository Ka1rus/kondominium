package com.apicondominio.models.dtos;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class TipoDespesaDTO {

	@NotNull(message = "O campo nome não pode ser nulo")
	@NotEmpty(message = "O campo nome não pode ser vazio")
	private String nomeDespesa;
	@NotNull(message = "O campo obs não pode ser nulo")
	@NotEmpty(message = "O campo obs não pode ser vazio")
	private String obsDespesa;
	@NotNull(message = "O campo tipoDespesa não pode ser nulo")
	@NotEmpty(message = "O campo tipoDespesa não pode ser vazio")
	private String tipoDespesa;
	
	public String getNomeDespesa() {
		return nomeDespesa;
	}
	public void setNomeDespesa(String nomeDespesa) {
		this.nomeDespesa = nomeDespesa;
	}
	public String getObsDespesa() {
		return obsDespesa;
	}
	public void setObsDespesa(String obsDespesa) {
		this.obsDespesa = obsDespesa;
	}
	public String getTipoDespesa() {
		return tipoDespesa;
	}
	public void setTipoDespesa(String tipoDespesa) {
		this.tipoDespesa = tipoDespesa;
	}
	
	
	
}
