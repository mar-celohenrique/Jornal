package br.ufc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.ISecaoDAO;
import br.ufc.model.Editor;
import br.ufc.model.Secao;

@Transactional
@Controller
public class SecaoController {

	@Autowired
	@Qualifier(value = "sDAO")
	private ISecaoDAO sDAO;

	@RequestMapping("/inserirSecaoFormulario")
	public String inserirSecaoFormulario(HttpSession sessao) {
		Editor editor = (Editor) sessao.getAttribute("editor_logado");
		if (editor != null) {
			return "secao/inserir_secao_formulario";
		} else {
			return "permissao_negada";
		}
	}

	@RequestMapping("/inserirSecao")
	public String inserirSecao(Secao secao) {
		sDAO.inserirSecao(secao);
		return "redirect:listarSecao";
	}

	@RequestMapping("/listarSecao")
	public String listarSecao(Model model, HttpSession sessao) {
		List<Secao> secao = this.sDAO.listarSecao();
		model.addAttribute("secoes", secao);
		Editor editor = (Editor) sessao.getAttribute("editor_logado");
		if (editor != null) {
			return "secao/listar_secao";
		} else {
			return "permissao_negada";
		}
	}

	@RequestMapping("/alterarSecaoFormulario")
	public String alterarSecaoFormulario(Long idSecao, Model model,
			HttpSession sessao) {
		Secao secao = this.sDAO.recuperarSecao(idSecao);
		model.addAttribute("secao", secao);
		Editor editor = (Editor) sessao.getAttribute("editor_logado");
		if (editor != null) {
			return "secao/alterar_secao_formulario";
		} else {
			return "permissao_negada";
		}
	}

	@RequestMapping("/alterarSecao")
	public String alterarSecao(Secao secao) {
		this.sDAO.alterarSecao(secao);

		return "redirect:listarSecao";
	}

}
