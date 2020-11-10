package com.facec.estagio.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.facec.estagio.entities.Pessoa;
import com.facec.estagio.repositories.ConvenioRepository;
import com.facec.estagio.repositories.PessoaFisicaRepository;
import com.facec.estagio.repositories.PessoaJuridicaRepository;
import com.facec.estagio.repositories.PessoaRepository;


@RequestMapping(value = "/relatorioClientes")
@Controller
public class RelatorioPessoaController {

	@Autowired
	PessoaRepository repository;

	@Autowired
	PessoaFisicaRepository pfrepository;

	@Autowired
	PessoaJuridicaRepository pjrepository;
	
	@Autowired
	ConvenioRepository convenioRepository;
	
	List<Pessoa> listPessoa = new ArrayList<Pessoa>();

	@GetMapping()
	public String clienteIndex(Model model) {
		model.addAttribute("pessoas", repository.findAll());
		return "relatorioPessoa";
	}
	
	//relatorio
	@PostMapping("consultarNome")
	public String consultarNome(String consultaNome, Model model) {
		listPessoa = repository.queryByNome("%" + consultaNome + "%");
		model.addAttribute("pessoas", listPessoa);
		return "relatorioPessoa";
	}
	
	@PostMapping("consultarCidade")
	public String consultarCidade(String consultaCidade, Model model) {
		listPessoa = repository.queryByCidade("%" + consultaCidade + "%");
		model.addAttribute("pessoas", listPessoa);
		return "relatorioPessoa";
	}	

	@RequestMapping("relatorio")
	public String abrirRelatorio(Model model) {
		model.addAttribute("pessoas", listPessoa);
		return "relatorioPessoaImpresso";
	}	
	//fim relatorio
}
