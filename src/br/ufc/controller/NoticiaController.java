package br.ufc.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.ufc.dao.IJornalistaDAO;
import br.ufc.dao.INoticiaDAO;
import br.ufc.dao.ISecaoDAO;
import br.ufc.model.Jornalista;
import br.ufc.model.Noticia;
import br.ufc.model.Secao;
import br.ufc.util.FileUtil;

@Transactional
@Controller
public class NoticiaController {

	@Autowired
	@Qualifier(value = "nDAO")
	private INoticiaDAO nDAO;

	@Autowired
	@Qualifier(value = "sDAO")
	private ISecaoDAO sDAO;

	@Autowired
	@Qualifier(value = "jDAO")
	private IJornalistaDAO jDAO;
	@Autowired
	private ServletContext servletContext;

	@RequestMapping("/inserirNoticiaFormulario")
	public String inserirNoticiaFormulario(Model model, HttpSession sessao) {
		List<Secao> secoes = sDAO.listarSecao();

		model.addAttribute("secoes", secoes);
		Jornalista jornalista = (Jornalista) sessao
				.getAttribute("jornalista_logado");
		if (jornalista != null) {
			return "noticia/inserir_noticia_formulario";
		} else {
			return "permissao_negada";
		}
	}

	@RequestMapping("/inserirNoticia")
	public String inserirNoticia(
			@Valid Noticia noticia,
			HttpSession sessao,
			String nome,
			BindingResult result,
			@RequestParam(value = "imagem", required = false) MultipartFile imagem) {
		Secao s = this.sDAO.buscarSecao(nome);
		Jornalista jornalista = (Jornalista) sessao
				.getAttribute("jornalista_logado");
		if (result.hasFieldErrors("nome")) {
			return "noticia/inserir_noticia_formulario";
		}

		String path = servletContext.getRealPath("/") + "resources/images/"
				+ noticia.getTitulo();

		FileUtil.salvarImagem(path, imagem);

		noticia.setJornalista(jornalista);
		noticia.setSecao(s);
		this.nDAO.inserirNoticia(noticia);
		return "redirect:listarNoticiaJornalista?idJornalista="
				+ jornalista.getIdJornalista();
	}

	@RequestMapping("/listarNoticiaJornalista")
	public String listarNoticiaJornalista(Long idJornalista, Model model,
			HttpSession sessao) {
		List<Noticia> noticia = this.nDAO.listarNoticiaJornalista(idJornalista);
		model.addAttribute("noticia", noticia);
		Jornalista jornalista = (Jornalista) sessao
				.getAttribute("jornalista_logado");
		if (jornalista != null) {
			return "noticia/listar_noticia_jornalista";
		} else {
			return "permissao_negada";
		}

	}

	@RequestMapping("/listarNoticias")
	public String listarNoticias(Model model) {
		List<Noticia> noticias = this.nDAO.listarNoticia();
		model.addAttribute("noticia", noticias);

		return "noticia/listar_noticia";
	}

	@RequestMapping("/removerNoticiaJornalista")
	public String removerNoticiaJornalista(Long idNoticia) {
		Noticia noticia = nDAO.recuperarNoticia(idNoticia);
		Jornalista jornalista = jDAO.recuperarJornalista(noticia
				.getIdJornalista());
		this.nDAO.removerNoticia(idNoticia);

		return "redirect:listarNoticiaJornalista?idJornalista="
				+ jornalista.getIdJornalista();
	}

	@RequestMapping("/removerNoticiaEditor")
	public String removerNoticiaEditor(Long idNoticia) {
		this.nDAO.removerNoticia(idNoticia);

		return "redirect:listarNoticiaEditor";
	}

	@RequestMapping("/alterarNoticiaFormulario")
	public String alterarNoticiaFormulario(Long idNoticia, Model model,
			HttpSession sessao) {
		Noticia noticia = this.nDAO.recuperarNoticia(idNoticia);
		model.addAttribute("noticia", noticia);
		Jornalista jornalista = (Jornalista) sessao
				.getAttribute("jornalista_logado");
		if (jornalista != null) {
			return "noticia/alterar_noticia_formulario";
		} else {
			return "permissao_negada";
		}
	}

	@RequestMapping("/alterarNoticia")
	public String alterarNoticia(Noticia noticia, Model model) {
		Jornalista jornalista = this.jDAO.recuperarJornalista(noticia
				.getIdJornalista());
		Secao secao = this.sDAO.recuperarSecao(noticia.getIdSecao());
		noticia.setJornalista(jornalista);
		noticia.setSecao(secao);

		model.addAttribute("noticia", noticia);

		this.nDAO.alterarNoticia(noticia);

		return "redirect:listarNoticiaJornalista?idJornalista="
				+ jornalista.getIdJornalista();
	}

	@RequestMapping("/visualizarNoticia")
	public String visualizarNoticia(Long id, Model model) {
		List<Noticia> noticia = nDAO.detalharNoticia(id);
		Noticia n = nDAO.recuperarNoticia(id);
		Jornalista jornalista = this.jDAO.recuperarJornalista(n.getIdJornalista());
		Secao secao = this.sDAO.recuperarSecao(n.getIdSecao());
		model.addAttribute("jornalista", jornalista);
		model.addAttribute("secao", secao);
		model.addAttribute("noticia", noticia);
		model.addAttribute("n", n);
		return "noticia/noticia_detalhada";
	}
	@RequestMapping("/manchetes")
	public String manchetes(Long id, Model model){
		Secao secao = sDAO.recuperarSecao(id);
		List<Noticia> noticias = nDAO.listarNoticiaSecao(secao);
		model.addAttribute("secao", secao);
		model.addAttribute("noticias", noticias);
		return "noticia/manchetes";
}

}
