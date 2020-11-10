package com.facec.estagio.entities;

import javax.persistence.Entity;

import org.hibernate.validator.constraints.br.CPF;

import com.facec.estagio.controllers.dto.PessoaFisicaDto;

@Entity
public class PessoaFisica extends Pessoa {

	@CPF
	private String cpf;
	private String rg;

	public PessoaFisica() {

	}

	public PessoaFisica(String cpf, String rg) {
		super();
		this.cpf = cpf;
		this.rg = rg;
	}
	
	public PessoaFisica(PessoaFisicaDto dto) {
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
		this.cpf = dto.getCpf();
		this.setRg(dto.getRg());
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
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
		PessoaFisica other = (PessoaFisica) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

}
