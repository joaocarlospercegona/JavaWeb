package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Beans.LoginBean;
import Beans.Cliente;

public final class ClienteAlterar_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>TODO supply a title</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js\"></script>\n");
      out.write("         <link rel=\\\"stylesheet\\\" type=\\\"text/css\\\" href=\\\"estilo.css\\\" />\n");
      out.write("        <style>\n");
      out.write("            .mover{\n");
      out.write("                position: absolute;\n");
      out.write("                top: 85%;\n");
      out.write("                left: 85%;\n");
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
      out.write("            .rodape{\n");
      out.write("                        position: absolute;\n");
      out.write("                        top: 95%;\n");
      out.write("                        left: 35%;\n");
      out.write("                        color: black;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            LoginBean logado = (LoginBean) session.getAttribute("logado");
            
            String msg = "Página Indisponível, favor logar.";

            if (logado == null) {
                request.setAttribute("msg", "Usuario deve se autenticar para acessar o sistema.");
                request.setAttribute("page", "index.html");
                RequestDispatcher rd = getServletContext().
                        getRequestDispatcher("/Index.jsp");
                rd.forward(request, response);

            } 
            else{
                
                
            }
        
      out.write("\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <div class=\"login-page\">\n");
      out.write("            <div class=\"alinhado\" >\n");
      out.write("                <form  method=\"post\" action=\"ClienteServlet?action=update\">         \n");
      out.write("                    <label>Id:</label>\n");
      out.write("                    <input type=\"text\"  class=\"form-control\" id=\"nome\" placeholder=\"Enter nome\" value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${alterar.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("' name=\"id\">\n");
      out.write("                    <label>Nome:</label>\n");
      out.write("                    <input type=\"text\"  class=\"form-control\" id=\"nome\" placeholder=\"Enter nome\" value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${alterar.nome}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("'  name=\"nome\">\n");
      out.write("                    <label>CPF:</label>\n");
      out.write("                    <input type=\"text\"  class=\"form-control\" id=\"cpf\" placeholder=\"Enter cpf\"  value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${alterar.cpf}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("'   name=\"cpf\"><br>  \n");
      out.write("                    <label>Email:</label>\n");
      out.write("                    <input type=\"text\"  class=\"form-control\" id=\"email\" placeholder=\"Enter email\" value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${alterar.email}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("'   name=\"email\"><br>\n");
      out.write("                    <label>Rua:</label>\n");
      out.write("                    <input type=\"text\"  class=\"form-control\" id=\"rua\" placeholder=\"Enter rua\" value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${alterar.rua}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("'   name=\"rua\"><br>\n");
      out.write("                    <label>Numero:</label>\n");
      out.write("                    <input type=\"text\"  class=\"form-control\" id=\"numero\" placeholder=\"Enter numero\" value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${alterar.numero}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("'   name=\"numero\"><br>\n");
      out.write("                    <label>Cep:</label>\n");
      out.write("                    <input type=\"text\"  class=\"form-control\" id=\"cep\" placeholder=\"Enter cep\" value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${alterar.cep}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("'   name=\"cep\"><br>\n");
      out.write("                    <label>Cidade:</label>\n");
      out.write("                    <input type=\"text\"  class=\"form-control\" id=\"cidade\" placeholder=\"Enter cidade\" value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${alterar.cidade}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("'   name=\"cidade\"><br>\n");
      out.write("                    <label>UF:</label>\n");
      out.write("                    <input type=\"text\"  class=\"form-control\" id=\"uf\" placeholder=\"Enter UF\" value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${alterar.uf}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("'   name=\"uf\"><br>\n");
      out.write("                    \n");
      out.write("                    <button type=\"submit\" class=\"btn btn-primary\">Alterar</button>\n");
      out.write("                   \n");
      out.write("                </form>\n");
      out.write("                    <br><a href=\"ClienteServlet?action=ver\"><button class=\"btn btn-primary\">Cancelar</button></a>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
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
