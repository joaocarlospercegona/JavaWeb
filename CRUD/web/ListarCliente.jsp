<%-- 
    Document   : ListarCliente
    Created on : 30/09/2019, 16:02:10
    Author     : joao
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Beans.Cliente"%>
<%@page import="Beans.Cliente"%>
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
         <nav class="navbar navbar-default">
              <div class="container-fluid">
                <div class="navbar-header">
                  <a class="navbar-brand" href="#">WebSiteName</a>
                </div>
                <ul class="nav navbar-nav">
                  <li class="active"><a href="#">Home</a></li>
                  <li><a href="NovoClienteServlet">Novo Cliente</a></li>
                  <li><a href="LogoutServlet">Sair</a></li>
                </ul>
              </div>
            </nav>
        <%
            String logado = (String) session.getAttribute("logado");
            
            String msg = "Página Indisponível, favor logar.";

            if (logado == null) {
                request.setAttribute("msg", "Usuario deve se autenticar para acessar o sistema.");
                RequestDispatcher rd = getServletContext().
                        getRequestDispatcher("/Index.jsp");
                rd.forward(request, response);

            } 
                List<Cliente> lista;
                lista= (List) request.getAttribute("cliente");
                
        %>
        
        
       <h1 align="center">Usuarios:</h1> 
              <div class="container" style=\"width:500px;\"> 
                  <table class="table table-striped">  
                    <tr bgcolor="00FF7F">
                        <th><b>ID</b></th>
                        <th><b>CPF</b></th>
                        <th><b>Nome</b></th>
                        <th><b>Email</b></th>
                        <th><b>Visualizar</b></th>
                        <th><b>Editar</b></th>
                        <th><b>Excluir</b></th>
                    </tr> 
       
                <%  for (Cliente s : lista) { %>
                    <tr> 
                        <td><%out.println(s.getId());%></td>
                        <td><%out.println(s.getCpf());%></td>
                        <td><%out.println(s.getNome());%></td>
                        <td><%out.println(s.getEmail());%></td>
                        <td><a href="VisualizarClienteServlet?id=<%out.println(s.getId());%>"><img src="ver.jpeg" width=45 height=40></a></td>
                        <td><a href="FormAlterarClienteServlet?id=<%out.println(s.getId());%>"><img src="edita.jpeg" width=45 height=40></a></td>
                        <td><a href="RemoverClienteServlet?id=<%out.println(s.getId());%> "><img src="retira.jpeg" width=45 height=40></a></td>
                    </tr>
            <%  }  %>
                  </table>
      
         <jsp:useBean id="email" class="Beans.ConfigBean" scope="application" />
            <div class="rodape">Em caso de problemas, contactar o administrador <jsp:getProperty name="email" property="email" /></div>
    </body>
</html>
