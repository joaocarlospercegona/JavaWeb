package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import Beans.Cliente;
import java.util.List;

public final class ClientesListar_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      			null, true, 8192, true);
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
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
      out.write("        <nav class=\"navbar navbar-default\">\n");
      out.write("              <div class=\"container-fluid\">\n");
      out.write("                <div class=\"navbar-header\">\n");
      out.write("                  <a class=\"navbar-brand\" href=\"#\">WebSiteName</a>\n");
      out.write("                </div>\n");
      out.write("                <ul class=\"nav navbar-nav\">\n");
      out.write("                  <li class=\"active\"><a href=\"#\">Home</a></li>\n");
      out.write("                  <li><a href=\"ClientesServlet\">Inserir Jsp.</a></li>\n");
      out.write("                  <li><a href=\"LogoutServlet\">Sair</a></li>\n");
      out.write("                </ul>\n");
      out.write("              </div>\n");
      out.write("            </nav>\n");
      out.write("        ");

            String logado = (String) session.getAttribute("logado");
            out.print(logado);
            String msg = "Página Indisponível, favor logar.";

            if (logado == null) {
                request.setAttribute("msg", "Usuario deve se autenticar para acessar o sistema.");
                RequestDispatcher rd = getServletContext().
                        getRequestDispatcher("/Index.jsp");
                rd.forward(request, response);

            } 
                List<Cliente> lista = new ArrayList<Cliente>();
                lista= (List)request.getAttribute("cliente");
        
      out.write("\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        ");
      Beans.LoginBean logado = null;
      synchronized (session) {
        logado = (Beans.LoginBean) _jspx_page_context.getAttribute("logado", PageContext.SESSION_SCOPE);
        if (logado == null){
          logado = new Beans.LoginBean();
          _jspx_page_context.setAttribute("logado", logado, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\n");
      out.write("        O usuario Logado é: ");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((Beans.LoginBean)_jspx_page_context.findAttribute("logado")).getNome())));
      out.write("\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("         <h1 align=\\\"center\\\">Usuarios:</h1> \n");
      out.write("              <div class=\\\"container\\\" style=\\\"width:500px;\\\"> <table class=\\\"table table-striped\\\">  \n");
      out.write("                    <tr bgcolor=\\\"00FF7F\\\">\n");
      out.write("                        <th><b>CPF</b></th>\n");
      out.write("                        <th><b>Nome</b></th>\n");
      out.write("                        <th><b>Email</b></th>\n");
      out.write("                        <th><b>Visualizar</b></th>\n");
      out.write("                        <th><b>Editar</b></th>\n");
      out.write("                        <th><b>Excluir</b></th>\n");
      out.write("                    </tr> \n");
      out.write("                    \n");
      out.write("            ");
        
                
                for (Cliente s : lista) { 
      out.write("\n");
      out.write("                    <tr> \n");
      out.write("                        <td>");
out.println(s.getCpf());
      out.write("</td>\n");
      out.write("                        <td>");
out.println(s.getNome());
      out.write("</td>\n");
      out.write("                        <td>");
out.println(s.getEmail());
      out.write("</td>\n");
      out.write("                        <td></td>\n");
      out.write("                        <td></td>\n");
      out.write("                        <td><img src=\"exclui.png\" width=60 height=40></td>\n");
      out.write("                    </tr>\n");
      out.write("            ");
  }  
      out.write("\n");
      out.write("                  </table>\n");
      out.write("       \n");
      out.write("            ");
      Beans.ConfigBean email = null;
      synchronized (application) {
        email = (Beans.ConfigBean) _jspx_page_context.getAttribute("email", PageContext.APPLICATION_SCOPE);
        if (email == null){
          email = new Beans.ConfigBean();
          _jspx_page_context.setAttribute("email", email, PageContext.APPLICATION_SCOPE);
        }
      }
      out.write("\n");
      out.write("            <div class=\"rodape\">Em caso de problemas, contactar o administrador ");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((Beans.ConfigBean)_jspx_page_context.findAttribute("email")).getEmail())));
      out.write("</div>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
