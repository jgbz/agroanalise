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

import com.facec.estagio.controllers.dto.PessoaFisicaDto;
import com.facec.estagio.entities.Convenio;
import com.facec.estagio.entities.Pessoa;
import com.facec.estagio.entities.PessoaFisica;
import com.facec.estagio.entities.PessoaJuridica;
import com.facec.estagio.entities.enums.TipoPessoa;
import com.facec.estagio.repositories.ConvenioRepository;
import com.facec.estagio.repositories.PessoaFisicaRepository;
import com.facec.estagio.repositories.PessoaJuridicaRepository;
import com.facec.estagio.repositories.PessoaRepository;

@RequestMapping(value = "/clientes")
@Controller
public class PessoaController {

	@Autowired
	PessoaRepository repository;

	@Autowired
	PessoaFisicaRepository pfrepository;

	@Autowired
	PessoaJuridicaRepository pjrepository;
	
	@Autowired
	ConvenioRepository convenioRepository;

	@GetMapping()
	public String clienteIndex(Model model) {
		model.addAttribute("clientes", repository.findAll());
		return "cliente";
	}

	@RequestMapping("formulario")
	public String abrirFormulario(PessoaFisicaDto pessoa, Model model) {
		List<Convenio> convenios = convenioRepository.findAll();
		model.addAttribute("convenios", convenios);
		return "formularioPessoaJ";
	}

	@PostMapping(value = "salvar")
	public String salvar(@Valid PessoaFisicaDto pessoa, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("erros", result.getAllErrors());
			return abrirFormulario(pessoa, model);
		}

		if (pessoa.getTipoPessoa() == TipoPessoa.FISICA) {
			repository.save(new PessoaFisica(pessoa));
		} else {
			repository.save(new PessoaJuridica(pessoa));
		}

		return "redirect:../clientes";
	}

	@PostMapping(value = "editar/salvar")
	public String atualizar(PessoaFisicaDto pessoa, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("erros", result.getAllErrors());
			return abrirFormulario(pessoa, model);
		}

		if (pessoa.getTipoPessoa() == TipoPessoa.FISICA) {
			repository.save(new PessoaFisica(pessoa));
		} else {
			repository.save(new PessoaJuridica(pessoa));
		}

		return "redirect:../../clientes";
	}

	@GetMapping(value = "editar")
	public String editar(@PathParam(value = "id") Long id, Model model) {
		Pessoa p = repository.getOne(id);
		PessoaFisicaDto pessoa;
		if (p.getTipoPessoa() == TipoPessoa.FISICA) {
			pessoa = new PessoaFisicaDto(p);
			pessoa.setCpf(pfrepository.getOne(id).getCpf());
			pessoa.setRg(pfrepository.getOne(id).getRg());
		} else {
			pessoa = new PessoaFisicaDto(p);
			pessoa.setConvenio(p.getConvenio());
			pessoa.setRazaoSocial(pjrepository.getOne(id).getRazaoSocial());
			pessoa.setInscricaoEstadual(pjrepository.getOne(id).getInscricaoEstadual());
		}
		model.addAttribute("pessoaFisicaDto", pessoa);
		return abrirFormulario(pessoa, model);
	}

	@GetMapping(value = "excluir")
	public String excluir(@PathParam(value = "id") Long id, Model model, RedirectAttributes redirAttrs) {

		if (repository.getOne(id).getTerrenos().isEmpty()) {
			repository.deleteById(id);
			return "redirect:../../clientes";
		} else {
			redirAttrs.addFlashAttribute("message", "Proibido a exclusão de um cliente que possui terrenos vinculados");
			return "redirect:../../clientes";
		}

	}

}
