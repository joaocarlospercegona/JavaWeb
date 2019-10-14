<%-- 
    Document   : Index.jsp
    Created on : 23/09/2019, 21:16:25
    Author     : joao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="erro.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
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
    <body align="center">
        <%
            String msg = (String) request.getAttribute("msg");
        %>
        <h4 style="color:red"><% if (msg != null)
                out.println(msg);%></h4>
         <img src="logo.jpeg" alt="aqui"/>
           <div class="mover">
             <a href="PortalServlet" algin="center"><button type="button" class="btn btn-success">Portal Servlet</button></a>   
           </div>
         
        <div class="login-page">
            <div class="alinhado" >
                <form  method="post" action="JspForward.jsp">          
                    <label>Usuario:</label>
                    <input type="text"  class="form-control" id="usuario" placeholder="Enter usuario" name="usuario">
                    <label for="pwd">Password:</label>
                    <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="senha"><br>             
                    <button type="submit" class="btn btn-primary">Logar</button>    
                </form>
            </div>
        </div>
         
        <div class="rodape">Em caso de problemas, contactar o administrador  ${configuracao.email}</div>
    </body>
</html>
