package com.facec.estagio.entities;

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

@Entity
public class Terreno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_pessoa")
	@NotNull(message = "Proprietário não pode ser nulo")
	private Pessoa proprietario;
	@NotBlank(message = "Local não pode ser nulo")
	private String local;
	private String talhao;
	private String lote;
	private String matricula;
	private String area;
	private String gleba;
	@NotBlank(message = "Municipio não pode ser nulo")
	private String municipio;
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "terreno")
	private List<Amostra> amostras = new ArrayList<>();

	public Terreno() {
	}

	public Terreno(Long id, Pessoa proprietario, String local, String talhao, String lote, String matricula,
			String area, String gleba, String municipio) {
		this.id = id;
		this.proprietario = proprietario;
		this.local = local;
		this.talhao = talhao;
		this.lote = lote;
		this.matricula = matricula;
		this.area = area;
		this.gleba = gleba;
		this.municipio = municipio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pessoa getProprietario() {
		return proprietario;
	}

	public void setProprietario(Pessoa proprietario) {
		this.proprietario = proprietario;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getTalhao() {
		return talhao;
	}

	public void setTalhao(String talhao) {
		this.talhao = talhao;
	}

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getGleba() {
		return gleba;
	}

	public void setGleba(String gleba) {
		this.gleba = gleba;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public List<Amostra> getAmostras() {
		return amostras;
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
		Terreno other = (Terreno) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
