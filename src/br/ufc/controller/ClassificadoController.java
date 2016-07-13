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

import br.ufc.dao.IClassificadoDAO;
import br.ufc.dao.IEditorDAO;
import br.ufc.model.Classificado;
import br.ufc.model.Editor;
import br.ufc.util.FileUtil;

@Transactional
@Controller
public class ClassificadoController {

	@Autowired
	@Qualifier(value = "cDAO")
	private IClassificadoDAO cDAO;

	@Autowired
	@Qualifier(value = "eDAO")
	private IEditorDAO eDAO;

	@Autowired
	private ServletContext servletContext;

	@RequestMapping("/inserirClassificadoFormulario")
	public String inserirClassificadoFormulario(HttpSession sessao) {
		Editor editor = (Editor) sessao.getAttribute("editor_logado");
		if (editor != null) {
			return "classificado/inserir_classificado_formulario";
		} else {
			return "permissao_negada";
		}
	}

	@RequestMapping("/inserirClassificado")
	public String inserirClassificado(Classificado classificado,
			HttpSession sessao, BindingResult result,
			@RequestParam(value = "imagem", required = false) MultipartFile imagem) {
		System.out.println("Inserir classificado");
		Editor editor = (Editor) sessao.getAttribute("editor_logado");
		if (result.hasFieldErrors("nome")) {
			return "noticia/inserir_noticia_formulario";
		}

		String path = servletContext.getRealPath("/") + "resources/images/"
				+ classificado.getTitulo();

		FileUtil.salvarImagem(path, imagem);

		classificado.setEditor(editor);
		this.cDAO.inserirClassificado(classificado);
		return "redirect:listarClassificadoEditor?idEditor="
				+ editor.getIdEditor();
	}

	@RequestMapping("/listarClassificados")
	public String listarClassificados(Model model) {
		List<Classificado> classificados = this.cDAO.listarClassificado();
		model.addAttribute("classificados", classificados);
		return "classificado/listar_classificados";
	}

	@RequestMapping("/removerClassificado")
	public String removerClassificado(Long idClassificado, HttpSession sessao) {
		Editor editor = (Editor) sessao.getAttribute("editor_logado"); 
		this.cDAO.removerClassificado(idClassificado);
		return "redirect:listarClassificadoEditor?idEditor="
		+ editor.getIdEditor();
	}

	@RequestMapping("/alterarClassificadoFormulario")
	public String alterarClassificadoFormulario(Long idClassificado,
			Model model, HttpSession sessao) {
		Classificado classificado = cDAO.recuperarClassificado(idClassificado);
		model.addAttribute("classificado", classificado);
		Editor editor = (Editor) sessao.getAttribute("editor_logado");
		if (editor != null) {
			return "classificado/alterar_classificado_formulario";
		} else {
			return "permissao_negada";
		}
	}

	@RequestMapping("/alterarClassificado")
	public String alterarClassificado(Classificado classificado, Model model) {
		Editor editor = this.eDAO.recuperarEditor(classificado.getIdEditor());
		classificado.setEditor(editor);
		model.addAttribute("classificado", classificado);
		this.cDAO.alterarClassificado(classificado);
		return "redirect:listarClassificados";
	}

	@RequestMapping("/listarClassificadoEditor")
	public String listarClassificadoEditor(Long idEditor, Model model,
			HttpSession sessao) {
		List<Classificado> classificados = this.cDAO
				.listarClassificadoEditor(idEditor);
		model.addAttribute("classificados", classificados);
		Editor editor = (Editor) sessao.getAttribute("editor_logado");
		if (editor != null) {

			return "classificado/listar_classificados_editor";
		} else {
			return "permissao_negada";
		}
	}

	@RequestMapping("/detalharClassificado")
	public String detalharClassificado(Long id, Model model) {
		List<Classificado> classificados = this.cDAO.detalharClassificado(id);
		Classificado c = this.cDAO.recuperarClassificado(id);
		model.addAttribute("classificado", classificados);
		model.addAttribute("c", c);
		return "classificado/classificado";
	}

}
