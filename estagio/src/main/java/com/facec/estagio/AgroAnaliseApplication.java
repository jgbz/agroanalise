package com.facec.estagio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.facec.estagio.entities.Amostra;
import com.facec.estagio.entities.Terreno;
import com.facec.estagio.repositories.AmostraRepository;
import com.facec.estagio.repositories.ConvenioRepository;
import com.facec.estagio.repositories.NematoideRepository;
import com.facec.estagio.repositories.NpaRepository;
import com.facec.estagio.repositories.PessoaRepository;
import com.facec.estagio.repositories.TerrenoRepository;

@SpringBootApplication
public class AgroAnaliseApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AgroAnaliseApplication.class, args);
	}

	@Autowired
	PessoaRepository prepository;
	
	@Autowired
	NpaRepository nparepository;
	
	@Autowired
	AmostraRepository arepository;
	
	@Autowired
	NematoideRepository nrepository;

	@Autowired
	ConvenioRepository crepository;

	@Autowired
	TerrenoRepository trepository;
	
	

	@Override
	public void run(String... args) throws Exception {
		/*PessoaFisica pessoa = new PessoaFisica();
		PessoaFisica pessoa2 = new PessoaFisica();
		PessoaJuridica pessoa3 = new PessoaJuridica();
		PessoaJuridica pessoa4 = new PessoaJuridica();
		
		pessoa.setAtivo(true);
		pessoa.setConvenio(crepository.getOne(1L));
		pessoa.setTipoPessoa(TipoPessoa.FISICA);
		pessoa2.setNome("joao");
		pessoa2.setConvenio(crepository.getOne(1L));
		pessoa2.setTipoPessoa(TipoPessoa.FISICA);
		pessoa3.setCnpj("23");
		pessoa4.setCnpj("24");*/
		
		
		//pessoa.setCpf("04605170901");
		/*prepository.save(pessoa);
		prepository.save(pessoa2);
		prepository.save(pessoa3);
		prepository.save(pessoa4);*/
		Terreno terreno;
		Terreno terreno2;
		/*trepository.save(terreno = new Terreno(1L, pessoa, "rua paraiba", "23", "2", "69", "100", "", ""));
		trepository.save(terreno2 = new Terreno(2L, pessoa, "rua humaita", "23", "2", "69", "100", "", ""));*/
		
		
		/*Amostra amostra = new Amostra();
		amostra.setId(1L);
		amostra.setTerreno(trepository.getOne(2L));
		
		
		
		arepository.save(amostra);
		nparepository.save(new NematoidePorAmostra(amostra, nrepository.getOne(1L), 2, 5));
		nparepository.save(new NematoidePorAmostra(amostra, nrepository.getOne(2L), 23, 6));
		nparepository.save(new NematoidePorAmostra(amostra, nrepository.getOne(3L), 4, 5));*/
	}

}
