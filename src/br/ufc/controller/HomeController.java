package br.ufc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.INoticiaDAO;
import br.ufc.dao.ISecaoDAO;
import br.ufc.model.Noticia;
import br.ufc.model.Secao;

@Transactional
@Controller
public class HomeController {
		
	@Autowired
	@Qualifier(value = "nDAO")
	private INoticiaDAO nDAO;

	@Autowired
	@Qualifier(value = "sDAO")
	private ISecaoDAO sDAO;

	@RequestMapping("/")
	public String index(Model model){
		List<Secao> secoes = sDAO.listarSecao();
		List<Noticia> noticias = nDAO.listarNoticia();
		model.addAttribute("secoes", secoes);
		model.addAttribute("noticias", noticias);
		return "index";
	}
	
}
