<%-- 
    Document   : home
    Created on : 21/08/2018, 21:10:14
    Author     : Julio Cesar Alves
--%>

<%@page import="br.com.podechamar.dominio.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8">
        <link href="css/bootstrap-3.3.6-dist/bootstrap-3.3.6-dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="css/estilos.css" rel="stylesheet">
        <link href="js/jquery-1.3.2.min.js" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>Pode Chamar - Home</title>
    </head>
    <body>
        <%
            Usuario usuarioLogado = (Usuario) session.getAttribute("usuAutenticado");
        %>


        <nav class="navbar navbar-default fixed">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="/podechamar_v1/ChamadoRelStatus">Pode Chamar</a>
                </div>
                <ul class="nav navbar-nav navbar-leftt">
                    <li><a href="/podechamar_v1/ListarChamado">Chamados</a></li>
                    <%if(usuarioLogado.getUsu_papel().equals("Administrador")){%>
                    <li><a href="/podechamar_v1/ListarCliente">Clientes</a></li>  
                    <%-- 
                    <li><a href="/podechamar_v1/contrato_lista.jsp">Contratos</a></li>
                    --%>
                    <li><a href="/podechamar_v1/ListarFuncionario">Funcionários</a></li>
                    <li><a href="/podechamar_v1/ListarProduto">Produtos</a></li>
                    <li><div class="dropdown" style="positicion:absolute; top:15px;">
                        <a class=" " type="button" data-toggle="dropdown"> Gestão
                            <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="/podechamar_v1/ListarDepartamento">Departamentos</a></li>
                            <li><a href="/podechamar_v1/ListarTipoChamado">Tipos de Chamado</a></li>
                            <li><a href="ListarAtividade">Atividades</a></li>
                            <li><a href="ListarHistorico">Histórico de Operações</a></li>
                        </ul>
                    </div></li>

                    <%} //if%>
                </ul>

                <ul class="nav navbar-nav navbar-right">
                    <div class="dropdown" style="positicion:absolute; top:10px;">
                        <button  class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown"><%=usuarioLogado.getUsu_login()%> &nbsp; - &nbsp; <%=usuarioLogado.getUsu_papel()%> &nbsp; <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                            <span class="caret"></span></button>
                        <ul class="dropdown-menu">
                            <li><a href="/podechamar_v1/index.jsp">Logar</a></li>
                            <li><a href="/podechamar_v1/Deslogar">Sair</a></li>
                            <li><a href="/podechamar_v1/funcionario_alterarSenha.jsp">Alterar Senha</a></li>
                        </ul>
                    </div>
                </ul>
            </div>
        </nav>
        <%-- 
                   corpo
        --%>   
        <form action="AlterarSenha" method="post">
        <div class="container">
            <div class="row">
                <div class="form-group">
                    </br</br></br></br></br>
                    <h3>Alterar Senha</h3>
                </div>
                <div class="col-md-6 mb-3 row" >
                    
                    <label class="control-label">Senha Antiga:</label>
                    <input type="hidden" class="form-control" name="id" value="<%=usuarioLogado.getId()%>" />
                    <input type="password" class="form-control" name="usu_senha" placeholder="Senha atual" />
                    <label class="control-label">Nova Senha:</label>
                    <input type="password" class="form-control" name="usu_novasenha" placeholder="Nova Senha" />
                    <label class="control-label">Confirmar senha:</label>
                    <input type="password" class="form-control" name="usu_confirmacao" placeholder="Confirmar a Nova Senha" />
                    </br><button type="submit" class="btn btn-primary botao" name="btnOperacao" value="ALTERAR">GRAVAR </button>
                
                
                    <%
                        String mensagem = (String) request.getAttribute("mensagem");
                        if (mensagem != null) {
                    %>
                    </br></br>
                    <div class="alert alert-info">
                        <strong>Mensagem do sistema:</strong></br>${mensagem}
                    </div>
                    <%
                        }
                    %>
                </div>
            </div>

            <%-- 
             rodapé
            --%>  
            <hr>
            <h5>@Pode Chamar 0.1 - 2018</h5>    
        </div>
        </form>

    </body>
</html>
