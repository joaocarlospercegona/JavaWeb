package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Beans.LoginBean;
import Beans.ConfigBean;
import DAO.UsuarioDAO;
import Beans.Usuario;
import java.util.List;

public final class Portal_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			"erro.jsp", true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Portal Jsp</title>\n");
      out.write("         <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css\">\n");
      out.write("  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\n");
      out.write("  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js\"></script>\n");
      out.write("        <link rel=\\\"stylesheet\\\" type=\\\"text/css\\\" href=\\\"estilo.css\\\" />\n");
      out.write("        <style>\n");
      out.write("            .rodape{\n");
      out.write("                position: absolute;\n");
      out.write("                top: 95%;\n");
      out.write("                left: 35%;\n");
      out.write("            }\n");
      out.write("            .login-page {\n");
      out.write("              width: 360px;\n");
      out.write("              padding: 3% 0 0;\n");
      out.write("              margin: auto;\n");
      out.write("            }            \n");
      out.write("            .alinhado{\n");
      out.write("                position: relative;\n");
      out.write("                z-index: 1;\n");
      out.write("                background: #FFFFFF;\n");
      out.write("                max-width: 360px;\n");
      out.write("                margin: 0 auto 100px;\n");
      out.write("                padding: 50px;\n");
      out.write("                text-align: center;\n");
      out.write("                box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("          ");

            LoginBean logado = (LoginBean) session.getAttribute("logado");
            
            String msg = "Página Indisponível, favor logar.";

            if (logado == null) {
                request.setAttribute("msg", "Usuario deve se autenticar para acessar o sistema.");
                request.setAttribute("page", "index.html");
                RequestDispatcher rd = getServletContext().
                        getRequestDispatcher("/Index.jsp");
                rd.forward(request, response);

            } 
        
      out.write("\n");
      out.write("            <nav class=\"navbar navbar-default\">\n");
      out.write("              <div class=\"container-fluid\">\n");
      out.write("                <div class=\"navbar-header\">\n");
      out.write("                  <a class=\"navbar-brand\" href=\"#\">Analise</a>\n");
      out.write("                </div>\n");
      out.write("                <ul class=\"nav navbar-nav\">\n");
      out.write("                  <li class=\"active\"><a href=\"#\">Home</a></li>\n");
      out.write("                  <li><a href=\"ClienteServlet?action=ver\">Cadastro de clientes.</a></li>\n");
      out.write("                  <li><a href=\"LogoutServlet\">Sair</a></li>\n");
      out.write("                </ul>\n");
      out.write("              </div>\n");
      out.write("             </nav>\n");
      out.write("      \n");
      out.write("        <br>\n");
      out.write("            ");
      Beans.LoginBean logados = null;
      synchronized (session) {
        logados = (Beans.LoginBean) _jspx_page_context.getAttribute("logados", PageContext.SESSION_SCOPE);
        if (logados == null){
          logados = new Beans.LoginBean();
          _jspx_page_context.setAttribute("logados", logados, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\n");
      out.write("            <h1 align=\"center\">O usuario logado é: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${logados.nome}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h1>      \n");
      out.write("            <div class=\"rodape\">Em caso de problemas, contactar o administrador  ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${configuracao.email}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</div>\n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
