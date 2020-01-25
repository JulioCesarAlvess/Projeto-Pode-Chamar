
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
                    <h3>Contratos</h3>
                </div>
                <div class="form-group">
                    <div class="col-md-11 mb-3">
                        <input type="text" name="busca" class="form-control" placeholder="Digite a sua busca aqui"/></br>
                        
                        
                    </div>
                    <div class="col-md-1 mb-3">
                       <button type="submit" class="btn btn-primary botao" value="BUSCAR" name="btnOperacao"> <i class="glyphicon glyphicon-search"></i> </button>
                    </div>
                </div>
                <h2 class="titulo-formulario">Lista de Contratos</h2>

                <div class="container">
                    <%
                     //   if (clientes != null) {
                    %>    
                    <table class="table table-hover table-condensed">
                        <thead >
                            <tr>
                                <th>Cliente: </th>
                                <th>Numero Contrato: </th>
                                <th>Data Termino: </th>
                                <th>Valor: </th>
                                <th>Status </th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                            //    for (Cliente c : clientes) {
                            //        cont++;
                            %>
                            <tr>
                                <td> Empresa Tal</td>
                                <td> 100345 </td>
                                <td> 12/05/2019  </td>
                                <td> 300,00 </td>
                                <td> Ativo </td>
                                <td><a href="/podechamar_v1/contrato_atualizar.jsp" class="btn btn-default" > <i class="glyphicon glyphicon-eye-open"></i> </a> <td>
                                    <%--   <td><a href="/podechamar_v1/produto_estoque.jsp" class="btn btn-default" > Estoque </a> <td> --%>
                            </tr>
                            <tr>
                                <tr>
                                <td> Empresa X </td>
                                <td> 100400 </td>
                                <td> 15/12/2018 </td>
                                <td> 450,00 </td>
                                <td> Bloqueado </td>
                                   <td><a href="/podechamar_v1/contrato_atualizar.jsp"  class="btn btn-default" > <i class="glyphicon glyphicon-eye-open"></i> </a> <td>
                                       <%--   <td><a href="/podechamar_v1/produto_estoque.jsp" class="btn btn-default" > Estoque </a> <td> --%>
                            </tr>
                            <%--
                                <td><a href="/podechamar_v1/AlterarFuncionario?btnOperacao=BUSCAR&id=" class="btn btn-default" > Editar</a> <td>
                                    <%
                                  //      if (!c.getCli_status().equals("Inativo")) {
                                    %>
                                <td><a href="/podechamar_v1/ListarCliente?btnOperacao=EXCLUIR&id=" class="btn btn-default" > Inativar</a> <td>
                                    <%
                                    //    }
                                    %>
                            --%>
                            <%//  }
                 //   }//if
%>
                        </tbody>
                        <tfoot class="text-uppercase">
                            <tr><td>
                        <bold>Encontrados: 2<%//=cont%> </bold>
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
