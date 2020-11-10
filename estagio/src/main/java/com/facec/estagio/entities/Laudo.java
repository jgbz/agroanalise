package com.facec.estagio.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.facec.estagio.entities.enums.TipoPagamento;

@Entity
public class Laudo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id_amostra")
	private Amostra amostra;
	private TipoPagamento tipoPagamento;
	private String parcelas;
	private boolean foiPago;

	public Laudo() {

	}

	public Laudo(Amostra amostra) {
		this.amostra = amostra;
	}

	public Laudo(Long id, Amostra amostra, TipoPagamento tipoPagamento, String parcelas) {
		this.id = id;
		this.amostra = amostra;
		this.tipoPagamento = tipoPagamento;
		this.parcelas = parcelas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Amostra getAmostra() {
		return amostra;
	}

	public void setAmostra(Amostra amostra) {
		this.amostra = amostra;
	}

	public TipoPagamento getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(TipoPagamento tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public String getParcelas() {
		return parcelas;
	}

	public void setParcelas(String parcelas) {
		this.parcelas = parcelas;
	}

	public boolean isFoiPago() {
		return foiPago;
	}

	public void setFoiPago(boolean foiPago) {
		this.foiPago = foiPago;
	}

}
