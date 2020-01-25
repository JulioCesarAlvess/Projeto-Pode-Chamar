<%-- 
    Document   : index
    Created on : 21/08/2018, 21:10:14
    Author     : Julio Cesar Alves
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8">

        <link href="/podechamar_v1/css/bootstrap-3.3.6-dist/bootstrap-3.3.6-dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="/podechamar_v1/js/jquery-1.3.2.min.js" rel="stylesheet">
        <link href="/podechamar_v1/css/estilos.css" rel="stylesheet">

        <title>Pode Chamar</title>
    </head>
    <body>

        <nav class="navbar navbar-default">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#"></a>
                </div>
            </div>
        </nav>
        <div class="container">
            <form role="form" class="form-horizontal" action="Logar" method="post">
                <div >
                    <%
                        String mensagem = (String) request.getAttribute("mensagem");
                        if (mensagem != null) {
                    %>
                    </br>
                    <div class="alert alert-info">
                        <strong>Mensagem do sistema:</strong></br>${mensagem}
                    </div>
                    <%
                        }
                    %>
                </div>  
                <div class="form-group">
                    <label class="col-xs-3 control-label">Login:</label>
                    <div class="col-xs-4">
                        <input type="text" class="form-control" name="usu_login" placeholder="login:"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-xs-3 control-label">Senha:</label>
                    <div class="col-xs-4">
                        <input type="password" class="form-control" name="usu_senha" placeholder="senha:"/>

                    </div>
                </div>
                <div class="form-group">
                    <label class="col-xs-3 control-label"></label>
                    <div class="col-xs-4">
                        <button type="submit" class="btn btn-primary botao" value="BUSCAR" name="btnOperacao"> Entrar </button>

                    </div>
                </div>
                <%-- <div class="form-group">
                    <a class="col-xs-3 control-label" href="/podechamar_v1/home.jsp">Esqueceu a senha ?</a>

                </div> --%>                
            </form>
            <%-- 
            rodapé
            --%>                  
            <hr>
            <h5>@Pode Chamar 0.1 - 2018</h5>    
        </div>
    </body>
</html>
