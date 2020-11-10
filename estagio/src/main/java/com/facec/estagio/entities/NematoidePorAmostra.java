package com.facec.estagio.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
public class NematoidePorAmostra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "id_amostra")
	private Amostra idAmostra;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_nematoide")
	private Nematoide nematoide;
	private Integer qtdeSolo;
	private Integer qtdeRaiz;

	public NematoidePorAmostra() {
	}

	public NematoidePorAmostra(Long id,Amostra idAmostra, Nematoide nematoide, Integer qtdeSolo, Integer qtdeRaiz) {
		this.id = id;
		this.idAmostra = idAmostra;
		this.nematoide = nematoide;
		this.qtdeSolo = qtdeSolo;
		this.qtdeRaiz = qtdeRaiz;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Amostra getIdAmostra() {
		return idAmostra;
	}

	public void setIdAmostra(Amostra idAmostra) {
		this.idAmostra = idAmostra;
	}

	public Nematoide getNematoide() {
		return nematoide;
	}

	public void setNematoide(Nematoide nematoide) {
		this.nematoide = nematoide;
	}

	public Integer getQtdeSolo() {
		return qtdeSolo;
	}

	public void setQtdeSolo(Integer qtdeSolo) {
		this.qtdeSolo = qtdeSolo;
	}

	public Integer getQtdeRaiz() {
		return qtdeRaiz;
	}

	public void setQtdeRaiz(Integer qtdeRaiz) {
		this.qtdeRaiz = qtdeRaiz;
	}

}
