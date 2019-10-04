package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>TODO supply a title</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js\"></script>\n");
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
      out.write("        \n");
      out.write("    </head>\n");
      out.write("    <body align=\"center\">\n");
      out.write("        ");

            String msg = (String) request.getAttribute("msg");
        
      out.write("\n");
      out.write("        <h4 style=\"color:red\">");
 out.println(msg);
      out.write("</h4>\n");
      out.write("         <img src=\"logo.jpeg\" alt=\"aqui\"/>\n");
      out.write("           <div class=\"mover\">\n");
      out.write("             <a href=\"PortalServlet\" algin=\"center\"><button type=\"button\" class=\"btn btn-success\">Portal Servlet</button></a>   \n");
      out.write("           </div>\n");
      out.write("        <div class=\"login-page\">\n");
      out.write("            <div class=\"alinhado\" >\n");
      out.write("                <form  method=\"post\" action=\"LoginServlet\">          \n");
      out.write("                    <label>Usuario:</label>\n");
      out.write("                    <input type=\"text\"  class=\"form-control\" id=\"usuario\" placeholder=\"Enter usuario\" name=\"usuario\">\n");
      out.write("                    <label for=\"pwd\">Password:</label>\n");
      out.write("                    <input type=\"password\" class=\"form-control\" id=\"pwd\" placeholder=\"Enter password\" name=\"senha\"><br>             \n");
      out.write("                    <button type=\"submit\" class=\"btn btn-primary\">Logar</button>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
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
      out.write(" \n");
      out.write("            </div>\n");
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
