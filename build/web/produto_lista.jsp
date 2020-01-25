
<%@page import="br.com.podechamar.util.Converter"%>
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
        <title>Pode Chamar - Lista de Produtos</title>
    </head>
    <body>
        <%
            Usuario usuarioLogado = (Usuario) session.getAttribute("usuAutenticado");
            //colher a lista
            List<Produto> produtos = (List<Produto>) request.getAttribute("produtos");
            int cont;
            cont = 0;
        %>
        <%-- 
        menu
        --%>


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

        <div class="container">

            <form role="form" class="form-horizontal" action="ListarProduto" >
                <div class="form-group">
                    </br></br></br>

                </div>
                <div class="form-group">
                    <div class="col-md-11 mb-3">
                        <input type="text" name="busca" class="form-control" placeholder="Digite a sua busca aqui"/></br>


                    </div>
                    <div class="col-md-1 mb-3">
                        <button type="submit" class="btn btn-primary botao" value="BUSCAR" name="btnOperacao"> <i class="glyphicon glyphicon-search"></i> </button>
                    </div>
                </div>
                <h2 class="titulo-formulario">Lista de Produtos <a href="/podechamar_v1/produto_gestao.jsp" class="btn btn-primary"><i class="glyphicon glyphicon-plus"></i></a></h2>

                <div class="container" >
                    <%
                        //   if (clientes != null) {
                    %>    
                    <table class="table table-hover table-condensed" >
                        <thead >
                            <tr>
                                <th>Nome: </th>
                                <th>Cod. EAN: </th>
                                <th>Est. Físico: </th>
                                <th>Est. Reservado </th>
                                <th>Est. Disponível </th>
                                <th>Valor de Venda: </th>
                                <th>Status: </th>
                            </tr>
                        </thead>
                        <tbody>
                            <%   for (Produto p : produtos) {
                                    cont++;
                            %>
                            <tr>
                                <td> <%= p.getPro_nome()%> </td>
                                <td> <%= p.getPro_ean()%> </td>
                                <td> <%= p.getPro_fisico()%> </td>
                                <td> <%= p.getPro_reservado()%> </td>
                                <td> <%= p.getPro_disponivel()%> </td>
                                <td> <%= Converter.criaDinheiro(p.getPro_preco_venda()) %> </td>
                                <td> <%= p.getPro_status()%> </td>
                                <td><a href="/podechamar_v1/AlterarProduto?btnOperacao=BUSCAR&id=<%= p.getId()%> " class="btn btn-default" > <i class="glyphicon glyphicon-pencil"></i></a> <td>
                                <td><a href="/podechamar_v1/produto_estoque.jsp?&id=<%= p.getId()%>&pro_nome=<%= p.getPro_nome()%>&pro_descricao=<%= p.getPro_descricao()%>&pro_fisico=<%= p.getPro_fisico()%>&pro_reservado=<%= p.getPro_reservado()%>&pro_disponivel=<%= p.getPro_disponivel()%> " class="btn btn-default" >Estoque</a> 
                                <td>
                                    <%
                                        if (!p.getPro_status().equals("Inativo")) {
                                    %>
                                <td><a href="/podechamar_v1/ListarProduto?btnOperacao=EXCLUIR&id=<%= p.getId()%> " class="btn btn-default" > Inativar</a> <td>
                                    <%
                                        }//if
                                    %>
                            </tr>
                            <%}//for
%>
                        </tbody>
                        <tfoot class="text-uppercase">
                            <tr><td>
                        <bold>Encontrados: <%=cont%> </bold>
                        </td></tr>
                        </tfoot>
                    </table>
                </div>
            </form>
            <%-- 
                        rodapé
            --%>                  
            <hr>
            <h5>@Pode Chamar 0.1 - 2018</h5>                    
        </div>  
        <%-- 
        rodapé
        --%> 
    </body>
</html>
