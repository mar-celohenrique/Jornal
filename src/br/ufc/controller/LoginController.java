package br.ufc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.IEditorDAO;
import br.ufc.dao.IJornalistaDAO;
import br.ufc.model.Criptografia;
import br.ufc.model.Editor;
import br.ufc.model.Jornalista;
import br.ufc.model.Login;

@Controller
public class LoginController {

	@Autowired
	@Qualifier(value = "jDAO")
	private IJornalistaDAO jDAO;

	@Autowired
	@Qualifier(value = "eDAO")
	private IEditorDAO eDAO;

	@RequestMapping("/loginFormulario")
	public String loginFormulario() {
		return "formulario_login";
	}

	@RequestMapping("/login")
	public String login(Login login, HttpSession session) {
		Jornalista jornalista = jDAO.buscarJornalista(login.getLogin());
		if (jornalista != null) {
			if (jornalista.getSenha().equals(Criptografia.criptografar(login.getSenha()))) {
				session.setAttribute("jornalista_logado", jornalista);
				return "menu_jornalista";
			}
		}

		else {
			Editor editor = eDAO.buscarEditor(login.getLogin());
			if (editor != null) {
				if (editor.getSenha().equals(Criptografia.criptografar(login.getSenha()))) {
					session.setAttribute("editor_logado", editor);
					return "menu_editor";
				}
			}
		}
		return "redirect:loginFormulario";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:loginFormulario";
	}

}
