package com.facec.estagio.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CNPJ;

@Entity
public class Convenio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "Nome do convênio não pode ser nulo")
	private String nome;
	@NotNull(message = "Percentual de desconto não pode ser nulo")
	private BigDecimal percentualDesconto;
	private boolean isAtivo;
	@CNPJ
	private String cnpj;
	@NotBlank(message = "Email não pode ser nulo")
	private String email;
	@NotBlank(message = "Telefone não pode ser nulo")
	private String telefone;
	@NotBlank(message = "Responsável Técnico não pode ser nulo")
	private String responsavelTecnico;
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "convenio")
	private List<Pessoa> clientes = new ArrayList<>();

	public Convenio() {
	}

	public Convenio(Long id, String nome, BigDecimal percentualDesconto, boolean isAtivo, String cnpj, String email,
			String telefone, String responsavelTecnico) {
		this.id = id;
		this.nome = nome;
		this.percentualDesconto = percentualDesconto;
		this.isAtivo = isAtivo;
		this.cnpj = cnpj;
		this.email = email;
		this.telefone = telefone;
		this.responsavelTecnico = responsavelTecnico;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPercentualDesconto() {
		return percentualDesconto;
	}

	public void setPercentualDesconto(BigDecimal percentualDesconto) {
		this.percentualDesconto = percentualDesconto;
	}

	public boolean getIsAtivo() {
		return isAtivo;
	}

	public void setAtivo(boolean isAtivo) {
		this.isAtivo = isAtivo;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getResponsavelTecnico() {
		return responsavelTecnico;
	}

	public void setResponsavelTecnico(String responsavelTecnico) {
		this.responsavelTecnico = responsavelTecnico;
	}

	public List<Pessoa> getClientes() {
		return clientes;
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
		Convenio other = (Convenio) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
