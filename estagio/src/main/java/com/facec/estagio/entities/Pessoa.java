package com.facec.estagio.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.facec.estagio.entities.enums.TipoPessoa;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String sexo;
	@ManyToOne
	@JoinColumn(name = "id_convenio")
	private Convenio convenio;
	private String telefone;
	private String celular;
	private String email;
	private String endereco;
	private String numero;
	private String complemento;
	private String cep;
	private String municipio;
	private String uf;
	private TipoPessoa tipoPessoa;
	private boolean isAtivo;
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "proprietario")
	private List<Terreno> terrenos = new ArrayList<>();

	public Pessoa() {
	}

	public Pessoa(Long id, String nome, String sexo, Convenio convenio, String telefone, String celular, String email,
			String endereco, String numero, String complemento, String cep, String municipio, String uf,
			TipoPessoa tipoPessoa, boolean isAtivo) {
		this.id = id;
		this.nome = nome;
		this.sexo = sexo;
		this.convenio = convenio;
		this.telefone = telefone;
		this.celular = celular;
		this.email = email;
		this.endereco = endereco;
		this.numero = numero;
		this.complemento = complemento;
		this.cep = cep;
		this.municipio = municipio;
		this.uf = uf;
		this.tipoPessoa = tipoPessoa;
		this.isAtivo = isAtivo;
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

	public Convenio getConvenio() {
		return convenio;
	}

	public void setConvenio(Convenio convenio) {
		this.convenio = convenio;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public boolean isAtivo() {
		return isAtivo;
	}

	public void setAtivo(boolean isAtivo) {
		this.isAtivo = isAtivo;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public List<Terreno> getTerrenos() {
		return terrenos;
	}

	public void setTerrenos(List<Terreno> terrenos) {
		this.terrenos = terrenos;
	}

}
