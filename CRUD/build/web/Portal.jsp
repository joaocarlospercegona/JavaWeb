<%-- 
    Document   : Portal
    Created on : 29/09/2019, 15:22:37
    Author     : joao
--%>

<%@page import="Beans.LoginBean"%>
<%@page import="Beans.ConfigBean"%>
<%@page import="DAO.UsuarioDAO"%>
<%@page import="Beans.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Portal Jsp</title>
         <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <link rel=\"stylesheet\" type=\"text/css\" href=\"estilo.css\" />
        <style>
            .rodape{
                position: absolute;
                top: 95%;
                left: 35%;
            }
            .login-page {
              width: 360px;
              padding: 3% 0 0;
              margin: auto;
            }            
            .alinhado{
                position: relative;
                z-index: 1;
                background: #FFFFFF;
                max-width: 360px;
                margin: 0 auto 100px;
                padding: 50px;
                text-align: center;
                box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
            }
        </style>
    </head>
    <body>
          <%
            LoginBean logado = (LoginBean) session.getAttribute("logado");
            
            String msg = "Página Indisponível, favor logar.";

            if (logado == null) {
                request.setAttribute("msg", "Usuario deve se autenticar para acessar o sistema.");
                request.setAttribute("page", "index.html");
                RequestDispatcher rd = getServletContext().
                        getRequestDispatcher("/Index.jsp");
                rd.forward(request, response);

            } else {
                
                UsuarioDAO dao = new UsuarioDAO();
                List<Usuario> lista = dao.buscarTodos();
                
            }
        %>
            <nav class="navbar navbar-default">
              <div class="container-fluid">
                <div class="navbar-header">
                  <a class="navbar-brand" href="#">Analise</a>
                </div>
                <ul class="nav navbar-nav">
                  <li class="active"><a href="#">Home</a></li>
                  <li><a href="ClienteServlet">Cadastro de clientes.</a></li>
                  <li><a href="LogoutServlet">Sair</a></li>
                </ul>
              </div>
             </nav>
      
        <br>
            <jsp:useBean id="logados" class="Beans.LoginBean" scope="session" />
            <h1 align="center">O usuario logado é: <jsp:getProperty name="logados" property="nome" /></h1>
       
            <jsp:useBean id="configuracao" class="Beans.ConfigBean" scope="application" />
            <div class="rodape">Em caso de problemas, contactar o administrador <jsp:getProperty name="configuracao" property="email" /></div>
    </body>
</html>