package br.ufc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.IJornalistaDAO;
import br.ufc.model.Criptografia;
import br.ufc.model.Editor;
import br.ufc.model.Jornalista;

@Transactional
@Controller
public class JornalistaController {

	@Autowired
	@Qualifier(value = "jDAO")
	private IJornalistaDAO jDAO;

	@RequestMapping("/inserirJornalistaFormulario")
	public String inserirJornalistaFormulario(HttpSession sessao) {
		Editor editor = (Editor) sessao.getAttribute("editor_logado");
		if (editor != null) {
			return "jornalista/inserir_jornalista_formulario";
		} else {
			return "permissao_negada";
		}
	}

	@RequestMapping("/inserirJornalista")
	public String inserirJornalista(Jornalista jornalista) {
		jornalista.setSenha(Criptografia.criptografar(jornalista.getSenha()));
		this.jDAO.inserirJornalista(jornalista);
		return "redirect:listarJornalistas";
	}

	@RequestMapping("/listarJornalistas")
	public String listarJornalistas(Model model, HttpSession sessao) {
		List<Jornalista> jornalistas = this.jDAO.listarJornalista();
		model.addAttribute("jornalistas", jornalistas);

		Editor editor = (Editor) sessao.getAttribute("editor_logado");
		if (editor != null) {

			return "jornalista/listar_jornalistas";
		} else {
			return "permissao_negada";
		}
	}

}
