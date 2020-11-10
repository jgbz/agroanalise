package com.facec.estagio.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
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

import com.facec.estagio.entities.Amostra;
import com.facec.estagio.entities.Laudo;
import com.facec.estagio.entities.Nematoide;
import com.facec.estagio.entities.NematoidePorAmostra;
import com.facec.estagio.entities.Terreno;
import com.facec.estagio.entities.enums.StatusAmostra;
import com.facec.estagio.repositories.AmostraRepository;
import com.facec.estagio.repositories.LaudoRepository;
import com.facec.estagio.repositories.NematoideRepository;
import com.facec.estagio.repositories.NpaRepository;
import com.facec.estagio.repositories.TerrenoRepository;

@RequestMapping(value = "amostras")
@Controller
public class AmostraController {

	@Autowired
	private AmostraRepository repository;
	
	@Autowired
	private TerrenoRepository trepository;

	@Autowired
	private NematoideRepository nrepository;
	
	@Autowired
	private NpaRepository nparepository;
	
	@Autowired
	private LaudoRepository lparepository;
	
	@GetMapping()
	public String amostraIndex(Model model) {
		List<Amostra> amostras = new ArrayList<>();
		repository.findAll().forEach(a ->{
			if (a.getStatus() == StatusAmostra.AGUARDANDO || a.getStatus() == StatusAmostra.ANALISADO) {
				amostras.add(a);
			}
		});
		model.addAttribute("amostras", amostras);
		return "amostra";
	}

	@RequestMapping("formulario")
	public String abrirFormulario(Amostra amostra, Model model) {
		List<Terreno> terrenos = trepository.findAll();
		model.addAttribute("terrenos", terrenos);
		model.addAttribute("amostra", amostra);
		return "formularioAmostra";
	}
	
	@PostMapping(value = "salvar")
	public String salvar(@Valid Amostra amostra, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("erros", result.getAllErrors());
			return abrirFormulario(amostra, model);
		}

		repository.save(amostra);
		return "redirect:../amostras";		
	}
	
	@PostMapping(value = "editar/salvar")
	public String atualizar(@Valid Amostra amostra, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("erros", result.getAllErrors());
			return abrirFormulario(amostra, model);
		}

		repository.save(amostra);
		return "redirect:../../amostras";
	}
	
	@RequestMapping("npm")
	public String npm(Amostra amostra, NematoidePorAmostra npm, Model model) {
		model.addAttribute("npa", amostra.getNpm());
		List<Nematoide> nematoides = nrepository.findAll();
		model.addAttribute("nematoides", nematoides);
		model.addAttribute("amostra", amostra);
		model.addAttribute("npm", npm);		
		return "amostraNpm";
	}
	
	@GetMapping(value = "np")
	public String editarNpm(@PathParam(value = "id") Long id, Model model) {
		Amostra a = repository.getOne(id);
		model.addAttribute("amostra", a);
		return npm(a, new NematoidePorAmostra(), model);
	}
	
	@PostMapping(value = "np/salvarnp")
	public String salvarNp(@Valid Amostra amostra, BindingResult result, Model model, NematoidePorAmostra npm) {

		/*if (result.hasErrors()) {
			model.addAttribute("erros", result.getAllErrors());
			return abrirFormulario(amostra, model);
		}*/
		String id = npm.getIdAmostra().getId().toString();
		amostra = repository.getOne(npm.getIdAmostra().getId());
		amostra.getNpm().add(npm);
		System.out.println(npm.getIdAmostra().getId());
		nparepository.save(npm);
		repository.save(amostra);
		
		return "redirect:?id="+id;		
	}
	
	@GetMapping(value = "np/delete")
	public String deleteNpm(@PathParam(value = "id") Long id, Model model, Amostra amostra, NematoidePorAmostra npm) {
		NematoidePorAmostra np = nparepository.getOne(npm.getId());
		Amostra am = np.getIdAmostra();
		Long idr = am.getId();
		/*am.getNpm().forEach(a -> {
			if (a.getNematoide().getEspecie().equals(np.getNematoide().getEspecie())) {
				amostra.getNpm().remove(a);
			}
		});*/
		
		nparepository.delete(npm);
		nparepository.flush();
		repository.save(am);
		return "redirect:../?id="+idr;
		/*if (!repository.findById(id).isEmpty()) {
			repository.deleteById(id);
			return "redirect:../../amostras";
		} else {
			model.addAttribute("erros", "erro");
			return amostraIndex(model);
		} */

	}
	
	@GetMapping(value = "editar")
	public String editar(@PathParam(value = "id") Long id, Model model) {
		Amostra a = repository.getOne(id);
		model.addAttribute("amostra", a);

		return abrirFormulario(a, model);
	}
	
	
	
	@GetMapping(value = "excluir")
	public String excluir(@PathParam(value = "id") Long id, Model model) {
		
		repository.getOne(id).setStatus(StatusAmostra.DESCARTADO);
		repository.save(repository.getOne(id));
		return "redirect:../../amostras";
	}
	
	@GetMapping(value = "laudo")
	public String gerarLaudo(@PathParam(value = "id") Long id, Model model) {
		Amostra a = repository.getOne(id);
		a.setDataTermino(LocalDate.now());
		a.setStatus(StatusAmostra.FINALIZADO);
		repository.save(a);
		lparepository.save(new Laudo(repository.getOne(id)));	
		return "redirect:../../amostras";
	}
	 

}
