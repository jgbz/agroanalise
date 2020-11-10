package com.facec.estagio.controllers.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import com.facec.estagio.entities.Convenio;
import com.facec.estagio.entities.Pessoa;
import com.facec.estagio.entities.PessoaFisica;
import com.facec.estagio.entities.PessoaJuridica;
import com.facec.estagio.entities.enums.TipoPessoa;

public class PessoaFisicaDto {

	private Long id;
	@NotBlank(message = "Nome não pode ser nulo")
	private String nome;
	@NotBlank(message = "Sexo não pode ser nulo")
	private String sexo;
	@NotNull(message = "Convênio não pode ser nulo")
	private Convenio convenio;
	@NotBlank(message = "Telefone não pode ser nulo")
	private String telefone;
	@NotBlank(message = "Celular não pode ser nulo")
	private String celular;
	@NotBlank(message = "Email não pode ser nulo")
	private String email;
	@NotBlank(message = "Endereço não pode ser nulo")
	private String endereco;
	@NotBlank(message = "Numero do endereço não pode ser nulo")
	private String numero;
	private String complemento;
	@NotBlank(message = "Cpf não pode ser nulo")
	private String cep;
	@NotBlank(message = "Municipio não pode ser nulo")
	private String municipio;
	@NotBlank(message = "UF não pode ser nulo")
	private String uf;
	private TipoPessoa tipoPessoa;
	private boolean isAtivo;
	@CPF
	private String cpf;
	private String rg;
	@CNPJ
	private String cnpj;
	private String inscricaoEstadual;
	private String razaoSocial;

	public PessoaFisicaDto() {
		// TODO Auto-generated constructor stub
	}

	public PessoaFisicaDto(Pessoa p) {
		this.setId(p.getId());
		this.setNome(p.getNome());
		this.setSexo(p.getSexo());
		this.setConvenio(p.getConvenio());
		this.setTelefone(p.getTelefone());
		this.setCelular(p.getCelular());
		this.setEmail(p.getEmail());
		this.setEndereco(p.getEndereco());
		this.setNumero(p.getNumero());
		this.setComplemento(p.getComplemento());
		this.setCep(p.getCep());
		this.setMunicipio(p.getMunicipio());
		this.setUf(p.getUf());
		this.setTipoPessoa(p.getTipoPessoa());
		this.setAtivo(p.isAtivo());
	}

	public PessoaFisicaDto(PessoaFisica p) {
		this.setId(p.getId());
		this.setNome(p.getNome());
		this.setSexo(p.getSexo());
		this.setConvenio(p.getConvenio());
		this.setTelefone(p.getTelefone());
		this.setCelular(p.getCelular());
		this.setEmail(p.getEmail());
		this.setEndereco(p.getEndereco());
		this.setNumero(p.getNumero());
		this.setComplemento(p.getComplemento());
		this.setCep(p.getCep());
		this.setMunicipio(p.getMunicipio());
		this.setUf(p.getUf());
		this.setTipoPessoa(p.getTipoPessoa());
		this.setAtivo(p.isAtivo());
		this.setCpf(p.getCpf());
		this.setRg(p.getRg());
	}

	public PessoaFisicaDto(PessoaJuridica p) {
		this.setId(p.getId());
		this.setNome(p.getNome());
		this.setSexo(p.getSexo());
		this.setConvenio(p.getConvenio());
		this.setTelefone(p.getTelefone());
		this.setCelular(p.getCelular());
		this.setEmail(p.getEmail());
		this.setEndereco(p.getEndereco());
		this.setNumero(p.getNumero());
		this.setComplemento(p.getComplemento());
		this.setCep(p.getCep());
		this.setMunicipio(p.getMunicipio());
		this.setUf(p.getUf());
		this.setTipoPessoa(p.getTipoPessoa());
		this.setAtivo(p.isAtivo());
		this.setCnpj(p.getCnpj());
		this.setRazaoSocial(p.getRazaoSocial());
		this.setInscricaoEstadual(p.getInscricaoEstadual());
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	

}
