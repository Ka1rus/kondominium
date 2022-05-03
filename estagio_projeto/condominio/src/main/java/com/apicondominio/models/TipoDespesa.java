package com.apicondominio.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class TipoDespesa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String nomeDespesa;
	private String obsDespesa;
	private String tipoDespesa;

	@OneToMany(mappedBy = "tipoDespesa", cascade = CascadeType.ALL)
	private List<Despesa> despesas;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
