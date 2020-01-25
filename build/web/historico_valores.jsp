<%@page import="java.util.List"%>
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
                        <%if (usuarioLogado.getUsu_papel().equals("Administrador")) {%>
                    <li><a href="/podechamar_v1/ListarCliente">Clientes</a></li>  
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

        <div class="container ">
            <%
                List<Historico> historicos = (List<Historico>) request.getAttribute("historicos");
                Historico h = historicos.get(0);
                String mensagem = (String) request.getAttribute("mensagem");
                String[] valores = h.getHis_valoranterior().split(",", 999);
            %>



            <div class="row">
                <div class="form-group">
                    </br></br></br>
                    <h3>Operação </h3>
                    <div class="col-md-3 mb-3" >
                        <label class="control-label">Usuario:</label>
                        <input type="text" class="form-control" value = "<%=h.getHis_usuario()%>" readonly=""/>
                    </div>
                    <div class="col-md-2 mb-3" >
                        <label class="control-label">Operação:</label>
                        <input type="text" class="form-control" value = "<%=h.getHis_operacao()%>" readonly=""/>
                    </div>
                    <div class="col-md-3 mb-3" >
                        <label class="control-label">Data:</label>
                        <input type="text" class="form-control"  value = "<%=h.getHis_dataalteracao()%>" readonly=""/>
                    </div>
                    <div class="col-md-3 mb-3" >
                        <label class="control-label">Objeto:</label>
                        <input type="text" class="form-control"  value = "<%=h.getHis_entidade()%>" readonly=""/>
                    </div>
                    <div class="col-md-1 mb-3" >
                        <label class="control-label">Código:</label>
                        <input type="text" class="form-control"  value = "<%=h.getHis_id()%>" readonly=""/>
                    </div>

                </div>
                </br></br></br>
                <h3>Dados Antes da Alteração: </h3>
                <%for (String s : valores) {
                        if ( !s.contains("null")) {
                %>
                <div class="col-md-4 mb-3" >
                    <label class="control-label"></label>
                    <input type="text" class="form-control" name="dep_nome" value = "<%=s%>" readonly=""/>
                </div>
                <%}//if
                    }//for
                %>


            </div>
            <%-- 
            rodapé
            --%>                  
            <hr>
            <h5>@Pode Chamar 0.1 - 2018</h5>      
        </div>  


    </body>
</html>
