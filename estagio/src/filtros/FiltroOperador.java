package filtros;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.TipoDeUsuario;

/**
 * Servlet Filter implementation class FiltroAdmin
 */
@WebFilter(urlPatterns={"/pages/operador/exames/baciloscopia/agendamento-baciloscopia.xhtml",
						"/pages/operador/exames/baciloscopia/cadastro-baciloscopia.xhtml",
						"/pages/operador/exames/baciloscopia/listar-baciloscopia.xhtml",
						"/pages/operador/exames/baciloscopia/resultado-baciloscopia.xhtml",
						"/pages/operador/exames/bioquimica/agendamento-bioquimica.xhtml",
						"/pages/operador/exames/bioquimica/cadastro-bioquimica.xhtml",
						"/pages/operador/exames/bioquimica/listar-bioquimica.xhtml",
						"/pages/operador/exames/bioquimica/resultado-bioquimica.xhtml",
						"/pages/operador/exames/hemograma/agendamento-hemograma.xhtml",
						"/pages/operador/exames/hemograma/cadastro-hemograma.xhtml",
						"/pages/operador/exames/hemograma/listar-hemograma.xhtml",
						"/pages/operador/exames/hemograma/resultado-hemograma.xhtml",
						"/pages/operador/exames/parasitologico/agendamento-parasitologico.xhtml",
						"/pages/operador/exames/parasitologico/cadastro-parasitologico.xhtml",
						"/pages/operador/exames/parasitologico/listar-parasitologico.xhtml",
						"/pages/operador/exames/parasitologico/resultado-parasitologico.xhtml",
						"/pages/operador/exames/plaqueta/agendamento-plaqueta.xhtml",
						"/pages/operador/exames/plaqueta/cadastro-parasitologico.xhtml",
						"/pages/operador/exames/plaqueta/listar-parasitologico.xhtml",
						"/pages/operador/exames/plaqueta/resultado-parasitologico.xhtml",
						"/pages/operador/exames/saguineo/agendamento-saguineo.xhtml",
						"/pages/operador/exames/saguineo/cadastro-saguineo.xhtml",
						"/pages/operador/exames/saguineo/listar-saguineo.xhtml",
						"/pages/operador/exames/saguineo/resultado-saguineo.xhtml",
						"/pages/operador/exames/urina/cadastro-urina.xhtml",
						"/pages/operador/exames/urina/agendamento-urina.xhtml",
						"/pages/operador/exames/urina/listar-urina.xhtml",
						"/pages/operador/exames/urina/resultado-urina.xhtml",
						"/pages/operador/gerenciar/perfil-operador.xhtml",
						"/pages/operador/paciente/cadastro-paciente.xhtml",
						"/pages/operador/paciente/listar-paciente.xhtml",
						"/pages/operador/relatorios/relatorio-geral.xhtml",
						"/pages/operador/relatorios/relatorio-solicitante.xhtml",
						"/pages/operador/home-operador.xhtml"})
public class FiltroOperador implements Filter {

    /**
     * Default constructor. 
     */
    public FiltroOperador() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpSession session = ((HttpServletRequest)request).getSession(false);		
		if (session.getAttribute("tipo") != null && session.getAttribute("tipo").equals(new TipoDeUsuario().getOperador())){
		  chain.doFilter(request, response);
		} else {
			String contextPath = ((HttpServletRequest) request).getContextPath();
		    ((HttpServletResponse)response).sendRedirect(contextPath+"/index.xhtml");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
