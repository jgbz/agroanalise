package com.facec.estagio.entities;

import javax.persistence.Entity;

import com.facec.estagio.controllers.dto.PessoaFisicaDto;

@Entity
public class PessoaJuridica extends Pessoa {


	private String cnpj;
	private String inscricaoEstadual;
	private String razaoSocial;

	public PessoaJuridica() {
	}

	public PessoaJuridica(String cnpj, String inscricaoEstadual, String razaoSocial) {
		super();
		this.cnpj = cnpj;
		this.inscricaoEstadual = inscricaoEstadual;
		this.razaoSocial = razaoSocial;
	}
	
	public PessoaJuridica(PessoaFisicaDto dto) {
		this.setId(dto.getId());
		this.setNome(dto.getNome());
		this.setSexo(dto.getSexo());
		this.setConvenio(dto.getConvenio());
		this.setTelefone(dto.getTelefone());
		this.setCelular(dto.getCelular());
		this.setEmail(dto.getEmail());
		this.setEndereco(dto.getEndereco());
		this.setNumero(dto.getNumero());
		this.setComplemento(dto.getComplemento());
		this.setCep(dto.getCep());
		this.setMunicipio(dto.getMunicipio());
		this.setUf(dto.getUf());
		this.setTipoPessoa(dto.getTipoPessoa());
		this.setAtivo(dto.isAtivo());
		this.setRazaoSocial(dto.getRazaoSocial());
		this.setInscricaoEstadual(dto.getInscricaoEstadual());
		this.setCnpj(dto.getCnpj());
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PessoaJuridica other = (PessoaJuridica) obj;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		return true;
	}
	
	

}
