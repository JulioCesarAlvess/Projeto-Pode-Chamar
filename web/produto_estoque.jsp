
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

        <div class="container ">
            <%
                //  Cliente c = (Cliente) request.getAttribute("cliente");
                String mensagem = (String) request.getAttribute("mensagem");
                String pro_nome = (String) request.getParameter("pro_nome");
                String pro_descricao = (String) request.getParameter("pro_descricao");
                String pro_fisico = (String) request.getParameter("pro_fisico");
                String pro_disponivel = (String) request.getParameter("pro_disponivel");
                String pro_reservado = (String) request.getParameter("pro_reservado");
                String id = (String) request.getParameter("id");
            %>

            <form role="form" class="form-horizontal" action="ListarProduto" method="post">
                <div class="row">
                    <div class="form-group">
                        </br></br></br>
                        <h2>&nbsp;Estoque </h2>
                        <h3>&nbsp;Dados do Produto </h3>
                    </div>
                    <div class="col-md-6 mb-3" >
                        <input type="hidden" name="id" value="<%=id%>">
                        <label class="control-label">Nome: </label>
                        <input type="text" class="form-control" name="pro_nome" placeholder="Nome Produto" value="<%=pro_nome%>" readonly="true" />
                    </div>

                    <div class="col-md-6 mb-3">
                        <label class=" control-label">Descrição: </label>
                        <input type="text" class="form-control" name="pro_descricao" placeholder="Descrição do Produto" value="<%=pro_descricao%>" readonly="true" />
                    </div>

                </div> 
                <div class="row">
                    <div class="form-group">

                        <h3>&nbsp;Estoque </h3>
                    </div>
                    <div class="col-md-4 mb-3" >
                        <label class="control-label">Estoque Fisico: </label>
                        <input type="text" class="form-control" name="pro_fisico" placeholder="Quantidade Produto" value="<%=pro_fisico%>" readonly="true"/>
                    </div>
                    <div class="col-md-4 mb-3" >
                        <label class="control-label">Estoque Reservado: </label>
                        <input type="text" class="form-control" name="pro_reservado" placeholder="Quantidade Produto" value="<%=pro_reservado%>" readonly="true"/>
                    </div>
                    <div class="col-md-4 mb-3" >
                        <label class="control-label">Estoque Disponivel: </label>
                        <input type="text" class="form-control" name="pro_disponivel" placeholder="Quantidade Produto" value="<%=pro_disponivel%>" readonly="true" />
                    </div>
                    <div class="col-md-6 mb-3" >
                        <label class="control-label">Movimentação: </label>
                        <select class="form-control" name="movimentacao">
                            <option value="Entrada" >Entrada</option>
                            <option value="Saida" >Saída</option>
                        </select>
                    </div>
                    <div class="col-md-6 mb-3" >
                        <label class=" control-label">Quantidade: </label>
                        <input type="text" class="form-control" name="quantidade" placeholder="Quantidade" />
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-3 mb-3">
                        </br></br><button type="submit" class="btn btn-primary botao" name="btnOperacao" value="EXCLUIR"> GRAVAR </button>
                    </div>
                </div>
            </form>
            <div>
                <%
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
            <%-- 
            rodapé
            --%>                  
            <hr>
            <h5>@Pode Chamar 0.1 - 2018</h5>      
        </div>  


    </body>
</html>
