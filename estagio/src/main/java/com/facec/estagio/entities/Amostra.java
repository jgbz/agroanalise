package com.facec.estagio.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.facec.estagio.entities.enums.StatusAmostra;

@Entity
public class Amostra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "id_terreno")
	@NotNull(message = "Terreno não pode ser nulo")
	private Terreno terreno;
	@DateTimeFormat(iso = ISO.DATE)
	@NotNull(message = "Data de coleta não pode ser nulo")
	private LocalDate dataColeta;
	@DateTimeFormat(iso = ISO.DATE)
	@NotNull(message = "Data de recebimento não pode ser nulo")
	private LocalDate dataRecebimento;
	private LocalDate dataTermino;
	@NotNull(message = "Peso da amostra não pode ser nulo")
	private BigDecimal pesoAmostra;
	@NotNull(message = "Peso da raiz não pode ser nulo")
	private BigDecimal pesoRaiz;
	@NotBlank(message = "Cultura não pode ser nulo")
	private String cultura;
	private String hibrido;
	private String variedade;
	@Length(min = 0, max = 600)
	private String observacao;
	@NotNull(message = "Custo da análise não pode ser nulo")
	private BigDecimal custo;
	private StatusAmostra status;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idAmostra")
	private List<NematoidePorAmostra> npm = new ArrayList<>();

	public Amostra() {
	}

	public Amostra(Long id, Terreno terreno, LocalDate dataColeta, LocalDate dataRecebimento, BigDecimal pesoAmostra,
			BigDecimal pesoRaiz, String cultura, String hibrido, String variedade, String observacao, BigDecimal custo,
			StatusAmostra status) {
		super();
		this.id = id;
		this.terreno = terreno;
		this.dataColeta = dataColeta;
		this.dataRecebimento = dataRecebimento;
		this.pesoAmostra = pesoAmostra;
		this.pesoRaiz = pesoRaiz;
		this.cultura = cultura;
		this.hibrido = hibrido;
		this.variedade = variedade;
		this.observacao = observacao;
		this.custo = custo;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Terreno getTerreno() {
		return terreno;
	}

	public void setTerreno(Terreno terreno) {
		this.terreno = terreno;
	}

	public LocalDate getDataColeta() {
		return dataColeta;
	}

	public void setDataColeta(LocalDate dataColeta) {
		this.dataColeta = dataColeta;
	}

	public LocalDate getDataRecebimento() {
		return dataRecebimento;
	}

	public void setDataRecebimento(LocalDate dataRecebimento) {
		this.dataRecebimento = dataRecebimento;
	}

	public LocalDate getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(LocalDate dataTermino) {
		this.dataTermino = dataTermino;
	}

	public BigDecimal getPesoAmostra() {
		return pesoAmostra;
	}

	public void setPesoAmostra(BigDecimal pesoAmostra) {
		this.pesoAmostra = pesoAmostra;
	}

	public BigDecimal getPesoRaiz() {
		return pesoRaiz;
	}

	public void setPesoRaiz(BigDecimal pesoRaiz) {
		this.pesoRaiz = pesoRaiz;
	}

	public String getCultura() {
		return cultura;
	}

	public void setCultura(String cultura) {
		this.cultura = cultura;
	}

	public String getHibrido() {
		return hibrido;
	}

	public void setHibrido(String hibrido) {
		this.hibrido = hibrido;
	}

	public String getVariedade() {
		return variedade;
	}

	public void setVariedade(String variedade) {
		this.variedade = variedade;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public BigDecimal getCusto() {
		return custo;
	}

	public void setCusto(BigDecimal custo) {
		this.custo = custo;
	}

	public StatusAmostra getStatus() {
		return status;
	}

	public void setStatus(StatusAmostra status) {
		this.status = status;
	}

	public List<NematoidePorAmostra> getNpm() {
		return npm;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Amostra other = (Amostra) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
