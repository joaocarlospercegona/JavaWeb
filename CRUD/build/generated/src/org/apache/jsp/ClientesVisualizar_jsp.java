package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ClientesVisualizar_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("             <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("             <title>Portal Jsp</title>\n");
      out.write("             <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("             <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css\">\n");
      out.write("             <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\n");
      out.write("             <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js\"></script>\n");
      out.write("    \n");
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
      out.write("        \n");
      out.write("        ");
      Beans.Cliente encontrado = null;
      synchronized (request) {
        encontrado = (Beans.Cliente) _jspx_page_context.getAttribute("encontrado", PageContext.REQUEST_SCOPE);
        if (encontrado == null){
          encontrado = new Beans.Cliente();
          _jspx_page_context.setAttribute("encontrado", encontrado, PageContext.REQUEST_SCOPE);
        }
      }
      out.write("\n");
      out.write("        ai");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((Beans.Cliente)_jspx_page_context.findAttribute("encontrado")).getNome())));
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
