package com.facec.estagio.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.facec.estagio.entities.Nematoide;
import com.facec.estagio.repositories.NematoideRepository;

@RequestMapping(value = "/relatorioNematoides")
@Controller
public class RelatorioNematoideController {

	@Autowired
	NematoideRepository repository;
	
	List<Nematoide> listNematoide = new ArrayList<Nematoide>();


	@GetMapping()
	public String nematoideIndex(Model model) {
		model.addAttribute("nematoides", repository.findAll());
		return "relatorioNematoide";
	}

	//relatorio
	@PostMapping("consultarEspecie")
	public String consultarEspecie(String consultaEspecie, Model model) {
		listNematoide = repository.queryByEspecie("%" + consultaEspecie + "%");
		model.addAttribute("nematoides", listNematoide);
		return "relatorioNematoide";
	}

	@PostMapping("consultarGenero")
	public String consultarGenero(String consultaGenero, Model model) {
		listNematoide = repository.queryByGenero("%" + consultaGenero + "%");
		model.addAttribute("nematoides", listNematoide);
		return "relatorioNematoide";
	}
	
	
	@RequestMapping("relatorio")
	public String abrirRelatorio(Model model) {
		model.addAttribute("nematoides", listNematoide);
		return "relatorioNematoideImpresso";
	}	
	//fim relatorio
	
	
}
