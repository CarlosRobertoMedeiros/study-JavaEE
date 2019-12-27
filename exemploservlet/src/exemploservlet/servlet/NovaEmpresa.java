package exemploservlet.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NovaEmpresa
 */
@WebServlet("/novaEmpresa")
public class NovaEmpresa extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String nomeInformado = req.getParameter("nome");
			
			PrintWriter out = resp.getWriter();
			out.println("<html><body> "+nomeInformado+" </body></html>");
			
			System.out.println("Cadastrando uma nova empresa "+nomeInformado);
			
		}
}
