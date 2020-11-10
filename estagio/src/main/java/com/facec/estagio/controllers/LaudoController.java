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

import com.facec.estagio.entities.Amostra;
import com.facec.estagio.entities.Laudo;
import com.facec.estagio.repositories.LaudoRepository;

@Controller
@RequestMapping(value = "laudos")
public class LaudoController {

	@Autowired
	LaudoRepository repository;

	@GetMapping
	public String laudoIndex(Model model) {
		List<Laudo> laudos = repository.findAll();
		model.addAttribute("laudos", laudos);
		return "laudo";
	}

	@RequestMapping(value = "formulario")
	public String abrirFormulario(Laudo laudo, Amostra amostra, Model model) {
		return "formularioLaudo";
	}

	@GetMapping(value = "editar")
	public String editar(@PathParam(value = "id") Long id, Model model, Amostra amostra) {
		Laudo l = repository.getOne(id);
		Amostra a = l.getAmostra();
		model.addAttribute("laudo", l);
		return abrirFormulario(l, a, model);
	}
	
	@PostMapping(value = "editar/salvar")
	public String atualizar(@Valid Laudo laudo, BindingResult result, Model model, Amostra amostra) {

		if (result.hasErrors()) {
			model.addAttribute("erros", result.getAllErrors());
			return abrirFormulario(laudo, amostra, model);
		}

		repository.save(laudo);
		return "redirect:../../laudos";
	}
	
	@GetMapping(value = "view")
	public String laudoView(@PathParam(value = "id") Long id, Model model) {
		Laudo l = repository.getOne(id);
		model.addAttribute("laudo", l);
		model.addAttribute("nematoides", l.getAmostra().getNpm());
		return "laudoview";
	}
	
	@GetMapping(value = "excluir")
	public String excluir(@PathParam(value = "id") Long id, Model model, RedirectAttributes redirAttrs) {

		if (!repository.getOne(id).isFoiPago()) {
			repository.deleteById(id);
			return "redirect:../../laudos";
		} else {
			redirAttrs.addFlashAttribute("message", "Proibido a exclusão de um Laudo que foi confirmado o pagamento");
			return "redirect:../../laudos";
		}		
	}
	
	@GetMapping(value = "pagar")
	public String pagar(@PathParam(value = "id") Long id, Model model, RedirectAttributes redirAttrs) {
		
		if (repository.getOne(id).isFoiPago()) {
			redirAttrs.addFlashAttribute("message", "Laudo já foi pago!");
			return "redirect:../../laudos";
		} else {
			Laudo l = repository.getOne(id);
			l.setFoiPago(true);
			repository.save(l);
			return "redirect:../../laudos";
		}
		
	}
	

}
