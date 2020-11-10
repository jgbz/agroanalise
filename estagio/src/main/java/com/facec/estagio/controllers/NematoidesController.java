package com.facec.estagio.controllers;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.facec.estagio.entities.Nematoide;
import com.facec.estagio.repositories.NematoideRepository;

@RequestMapping(value = "/nematoides")
@Controller
public class NematoidesController {

	@Autowired
	NematoideRepository repository;

	@GetMapping()
	public String nematoideIndex(Model model) {
		model.addAttribute("nematoides", repository.findAll());
		return "nematoides";
	}

	@RequestMapping("formulario")
	public String abrirFormulario(Nematoide nematoide, Model model) {
		return "formularioNematoide";
	}

	@PostMapping(value = "salvar")
	public String salvar(@Valid Nematoide nematoide, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("erros", result.getAllErrors());
			return abrirFormulario(nematoide, model);
		}

		repository.save(nematoide);
		return "redirect:../nematoides";
	}

	@PostMapping(value = "editar/salvar")
	public String atualizar(@Valid Nematoide nematoide, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("erros", result.getAllErrors());
			return abrirFormulario(nematoide, model);
		}

		repository.save(nematoide);
		return "redirect:../../nematoides";
	}
	
	@GetMapping(value = "editar")
	public String editar(@PathParam(value = "id") Long id, Model model) {
		Nematoide n = repository.getOne(id);
		model.addAttribute("nematoide", n);

		return abrirFormulario(n, model);
	}

	@GetMapping(value = "excluir")
	public String excluir(@PathParam(value = "id") Long id, Model model) {

		if (!repository.findById(id).isEmpty()) {
			repository.deleteById(id);
			return "redirect:../../nematoides";
		} else {
			model.addAttribute("erros", "erro");
			return nematoideIndex(model);
		}

	}
}
