package br.ufc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		String uri = request.getRequestURI();

		if (uri.endsWith("loginFormulario") || uri.endsWith("login")
				|| uri.endsWith("/") || uri.endsWith("visualizarNoticia")
				|| uri.endsWith("listarClassificados")
				|| uri.endsWith("manchetes")
				|| uri.endsWith("listarClassificados")
				|| uri.endsWith("detalharClassificado")) {
			return true;
		}

		if (request.getSession().getAttribute("editor_logado") != null) {
			return true;
		}
		if (request.getSession().getAttribute("jornalista_logado") != null) {
			return true;
		}

		response.sendRedirect("loginFormulario");
		return false;
	}
}
