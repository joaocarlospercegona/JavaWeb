<%-- 
    Document   : ClientesVisualizar
    Created on : 30/09/2019, 22:09:25
    Author     : joao
--%>

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
         
         <jsp:useBean id="s" class="Beans.Cliente" scope="request" />
         
            <nav class="navbar navbar-default">
              <div class="container-fluid">
                <div class="navbar-header">
                  <a class="navbar-brand" href="#">WebSiteName</a>
                </div>
                <ul class="nav navbar-nav">
                  <li class="active"><a href="Index.jsp">Home</a></li>
                  <li><a href="ClienteServlet">Lista de Clientes</a></li>
                  <li><a href="LogoutServlet">Sair</a></li>
                </ul>
              </div>
            </nav>
            <div class="login-page">
                <div class="alinhado" >
                    <h3>Id:</h3> <jsp:getProperty name="s" property="id" />
                    <h3>Nome:</h3> <jsp:getProperty name="s" property="nome" />
                    <h3>Cpf:</h3> <jsp:getProperty name="s" property="cpf" />
                    <h3>Email:</h3> <jsp:getProperty name="s" property="email" />
                    <h3>Data:</h3> <jsp:getProperty name="s" property="data" />
                    <h3>Rua:</h3> <jsp:getProperty name="s" property="rua" />
                    <h3>Numero:</h3> <jsp:getProperty name="s" property="nr" />
                    <h3>Cep:</h3> <jsp:getProperty name="s" property="cep" />
                    <h3>Cidade:</h3> <jsp:getProperty name="s" property="cidade" />
                    <h3>UF:</h3> <jsp:getProperty name="s" property="uf" />
                    
                </div>
            </div>
                
    </body>
</html>
