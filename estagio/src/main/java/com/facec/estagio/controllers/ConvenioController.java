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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.facec.estagio.entities.Convenio;
import com.facec.estagio.repositories.ConvenioRepository;

@RequestMapping(value = "/convenios")
@Controller
public class ConvenioController {

	@Autowired
	ConvenioRepository repository;

	@GetMapping()
	public String convenioIndex(Model model) {
		model.addAttribute("convenios", repository.findAll());
		return "convenio";
	}
	@RequestMapping(value = "formulario")
	public String abrirFormulario(Convenio convenio, Model model) {
		return "formularioConvenio";
	}

	@PostMapping(value = "salvar")
	public String salvar(@Valid Convenio convenio, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("erros", result.getAllErrors());
			return abrirFormulario(convenio, model);
		}

		repository.save(convenio);
		return "redirect:../convenios";
		
	}
	
	@PostMapping(value = "editar/salvar")
	public String atualizar(@Valid Convenio convenio, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("erros", result.getAllErrors());
			return abrirFormulario(convenio, model);
		}

		repository.save(convenio);
		return "redirect:../../convenios";
		
	}

	@GetMapping(value = "editar")
	public String editar(@PathParam(value = "id") Long id, Model model) {
		Convenio c = repository.getOne(id);
		model.addAttribute("convenio", c);

		return abrirFormulario(c, model);
	}

	@GetMapping(value = "excluir")
	public String excluir(@PathParam(value = "id") Long id, Model model, RedirectAttributes redirAttrs) {

		if (repository.getOne(id).getClientes().isEmpty()) {
			repository.deleteById(id);
			return "redirect:../../convenios";
		} else {
			redirAttrs.addFlashAttribute("message", "Proibido a exclusão de um convênio que possui clientes vinculados");
			return "redirect:../../convenios";
		}
		
	}
}
