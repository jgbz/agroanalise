package com.facec.estagio.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.facec.estagio.entities.Convenio;
import com.facec.estagio.repositories.ConvenioRepository;

@RequestMapping(value = "/relatorioConvenios")
@Controller
public class RelatorioConvenioController {

	@Autowired
	ConvenioRepository repository;

	List<Convenio> listConvenio = new ArrayList<Convenio>();

	@GetMapping()
	public String convenioIndex(Model model) {
		listConvenio = repository.findAll();
		model.addAttribute("convenios", listConvenio);
		return "relatorioConvenio";
	}

	// relatorio
	@PostMapping("consultarConvenio")
	public String consultarNome(String consultaNome, Model model) {
		listConvenio = repository.queryByConvenio("%" + consultaNome + "%");
		model.addAttribute("convenios", listConvenio);
		return abrirRelatorio(model);
	}

	@PostMapping("consultarCnpj")
	public String consultarCnpj(String consultaCnpj, Model model) {
		listConvenio = repository.queryByCnpj("%" + consultaCnpj + "%");
		model.addAttribute("convenios", listConvenio);
		return abrirRelatorio(model);
	}

	@RequestMapping("relatorio")
	public String abrirRelatorio(Model model) {
		model.addAttribute("convenios", listConvenio);
		return "relatorioConvenioImpresso";
	}
	// fim relatorio

}