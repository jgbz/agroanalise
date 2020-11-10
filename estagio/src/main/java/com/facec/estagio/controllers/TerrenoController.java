package com.facec.estagio.controllers;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.facec.estagio.entities.Pessoa;
import com.facec.estagio.entities.Terreno;
import com.facec.estagio.repositories.PessoaRepository;
import com.facec.estagio.repositories.TerrenoRepository;

@RequestMapping(value = "terrenos")
@Controller
public class TerrenoController {
	
	@Autowired
	TerrenoRepository repository;
	
	@Autowired
	PessoaRepository pessoaRepository;
	
	@GetMapping()
	public String terrenoIndex(Model model) {		
		model.addAttribute("terrenos", repository.findAll());
		return "terreno";
	}
	
	@RequestMapping("formulario")
	public String abrirFormulario(Terreno terreno, Model model) {	
		List<Pessoa> pessoas = pessoaRepository.findAll();
		model.addAttribute("pessoas", pessoas);
		return "formularioTerreno";
	}
	
	@PostMapping(value = "salvar")
	public String salvar(@Valid Terreno terreno, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("erros", result.getAllErrors());
			return abrirFormulario(terreno, model);
		}

		repository.save(terreno);
		return "redirect:../terrenos";		
	}
	
	@PostMapping(value = "editar/salvar")
	public String atualizar(@Valid Terreno terreno, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("erros", result.getAllErrors());
			return abrirFormulario(terreno, model);
		}

		repository.save(terreno);
		return "redirect:../../terrenos";
	}

	@GetMapping(value = "editar")
	public String editar(@PathParam(value = "id") Long id, Model model) {
		Terreno t = repository.getOne(id);
		model.addAttribute("terreno", t);

		return abrirFormulario(t, model);
	}

	@GetMapping(value = "excluir")
	public String excluir(@PathParam(value = "id") Long id, Model model, RedirectAttributes redirAttrs) {

		if (repository.getOne(id).getAmostras().isEmpty()) {
			repository.deleteById(id);
			return "redirect:../../terrenos";
		} else {
			redirAttrs.addFlashAttribute("message", "Proibido a exclusão de um cliente que possui terrenos vinculados");
			return "redirect:../../terrenos";
		}

	}

}
