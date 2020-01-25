
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
        <title>Pode Chamar - Novo chamado</title>
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
                String mensagem = (String) request.getAttribute("mensagem");
                
            %>

            <form role="form" class="form-horizontal" action="SalvarTipoChamado" method="post">
                <div class="row">
                    <div class="form-group">
                        </br></br></br>
                        <h3>Novo Tipo de Chamado </h3>
                    </div>
                    <div class="col-md-6 mb-3" >
                        <label class="control-label">Nome: </label>
                        <input type="text" class="form-control" name="tch_nome" placeholder="Nome do tipo do Chamado" />
                    </div>
                    <div class="col-md-6 mb-3">
                        <label class=" control-label">Status:</label>
                        <select class="form-control" name="tch_status">
                            <option value="">Selecione</option>
                            <option value="Ativo" >Ativo</option>
                            <option value="Inativo" >Inativo</option>
                        </select>
                    </div>
                    <div class="col-md-12 mb-3">
                        <label class=" control-label">Descricao: </label>
                        <input type="text" class="form-control" name="tch_descricao" placeholder="Descrição do tipo do Chamado" />
                        </div>
                    </div>
                    </br>
                    <div class="row">
                    <div class="form-group">
                        <h3>Informe a SLA por Severidade do Tipo de Chamado (em horas) </h3>
                    </div> 
                    <div class="col-md-4 mb-3">
                        <label class=" control-label">Normal: </label>
                        <input type="text" class="form-control" name="tch_normal" placeholder="valor em horas serveridade normal"/>
                    </div>
                    <div class="col-md-4 mb-3">
                        <label class=" control-label">Urgente: </label>
                        <input type="text" class="form-control" name="tch_urgente" placeholder="valor em horas serveridade urgente"/>
                    </div>
                    <div class="col-md-4 mb-3">
                        <label class=" control-label">Critico: </label>
                        <input type="text" class="form-control" name="tch_critico" placeholder="valor em horas serveridade critico" />
                    </div>
                    <div class="row">
                    <div class="col-md-3 mb-3">
                        </br><button type="submit" class="btn btn-primary botao" name="btnOperacao" value="SALVAR"> Gravar </button>
                    </div>
                   </div>
                    </br>
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
