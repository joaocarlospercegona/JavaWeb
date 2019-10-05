<%-- 
    Document   : ClienteAlterar
    Created on : 30/09/2019, 23:10:28
    Author     : joao
--%>

<%@page import="Beans.LoginBean"%>
<%@page import="Beans.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
         <link rel=\"stylesheet\" type=\"text/css\" href=\"estilo.css\" />
        <style>
            .mover{
                position: absolute;
                top: 85%;
                left: 85%;
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
            .rodape{
                        position: absolute;
                        top: 95%;
                        left: 35%;
                        color: black;
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

            } 
            else{
                
                
            }
        %>
        <jsp:useBean id="alterar" class="Beans.Cliente" scope="request" />
        
        <div class="login-page">
            <div class="alinhado" >
                <form  method="post" action="AlterarClienteServlet">         
                    <label>Id:</label>
                    <input type="text"  class="form-control" id="nome" placeholder="Enter nome" value='<jsp:getProperty name="alterar" property="id" />'  name="id">
                    <label>Nome:</label>
                    <input type="text"  class="form-control" id="nome" placeholder="Enter nome" value='<jsp:getProperty name="alterar" property="nome" />'  name="nome">
                    <label>CPF:</label>
                    <input type="text"  class="form-control" id="cpf" placeholder="Enter cpf"  value='<jsp:getProperty name="alterar" property="cpf" />'   name="cpf"><br>  
                    <label>Email:</label>
                    <input type="text"  class="form-control" id="email" placeholder="Enter email" value='<jsp:getProperty name="alterar" property="email" />'   name="email"><br>
                    <label>Rua:</label>
                    <input type="text"  class="form-control" id="rua" placeholder="Enter rua" value='<jsp:getProperty name="alterar" property="rua" />'   name="rua"><br>
                    <label>Numero:</label>
                    <input type="text"  class="form-control" id="numero" placeholder="Enter numero" value='<jsp:getProperty name="alterar" property="nr" />'   name="numero"><br>
                    <label>Cep:</label>
                    <input type="text"  class="form-control" id="cep" placeholder="Enter cep" value='<jsp:getProperty name="alterar" property="cep" />'   name="cep"><br>
                    <label>Cidade:</label>
                    <input type="text"  class="form-control" id="cidade" placeholder="Enter cidade" value='<jsp:getProperty name="alterar" property="cidade" />'   name="cidade"><br>
                    <label>UF:</label>
                    <input type="text"  class="form-control" id="uf" placeholder="Enter UF" value='<jsp:getProperty name="alterar" property="uf" />'   name="uf"><br>
                    
                    <button type="submit" class="btn btn-primary">Alterar</button>
                   
                </form>
                    <br><a href="ClienteServlet"><button class="btn btn-primary">Cancelar</button></a>
            </div>
        </div>
    </body>
</html>
