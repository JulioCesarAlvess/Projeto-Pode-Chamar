<%-- 
    Document   : chamados_novo
    Created on : 30/08/2018, 16:46:18
    Author     : Julio Cesar Alves
--%>

<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
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
            Chamado c = (Chamado) request.getAttribute("chamado");
            List<Produto> produtos = (List<Produto>) session.getAttribute("produtos");
            List<Funcionario> funcionarios = (List<Funcionario>) session.getAttribute("funcionarios");
            List<Atividade> atividades = (List<Atividade>) session.getAttribute("atividades");
            double total = 0;
            int cont = 0;
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
        <div class="container ">
            <%
                //Cliente c = (Cliente) request.getAttribute("cliente");
                String mensagem = (String) request.getAttribute("mensagem");
            %>



            <div class="row row-grupo" border="1">
                </br></br></br>

                <h2>Feedback do Chamado</h2>
                <%//form para o cliente dar o feedback para o funcionario
                    if (usuarioLogado.getUsu_papel().equals("Cliente") && c.getCha_nota_fun() == 0) {%>
                <form action="FeedbackFuncionario">

                    <div class="col-md-3 mb-3" >
                        <input type="hidden" value ="<%=c.getId()%>" class="form-control" name="id"/>
                        <label class=" control-label">Dê uma nota ao atendimento: </br> Nota de 1 a 5:</label>
                        <select class="form-control" name="nota_fun">
                            <option value="1"> 1 </option>
                            <option value="2"> 2 </option>
                            <option value="3"> 3 </option>
                            <option value="4"> 4 </option>
                            <option value="5"> 5 </option>
                        </select>
                    </div>
                    </br> 
                    <div class="col-md-12 mb-3" >
                        <label class=" control-label">Feedback descritivo:</label>
                        <input type="text" class="form-control" name="feedback_fun"/>
                    </div>    
                    <div class="col-md-4 mb-3" >
                        </br><button type="submit" class="btn btn-primary botao" name="btnOperacao" value="EXCLUIR">ATRIBUIR</button>
                    </div>
                </form>

                <%}// fim do if %>
                <%//form para o cliente dar o feedback para o cliente
                    if (usuarioLogado.getUsu_papel().equals("Operacional") && c.getCha_nota_cli() == 0) {%>
                <form action="FeedbackCliente">

                    <div class="col-md-3 mb-3" >
                        <input type="hidden" value ="<%=c.getId()%>" class="form-control" name="id"/>
                        <label class=" control-label">Dê uma nota ao cliente: </br> Nota de 1 a 5:</label>
                        <select class="form-control" name="nota_cli">
                            <option value="1"> 1 </option>
                            <option value="2"> 2 </option>
                            <option value="3"> 3 </option>
                            <option value="4"> 4 </option>
                            <option value="5"> 5 </option>
                        </select>
                    </div>
                    </br> 
                    <div class="col-md-12 mb-3" >
                        <label class=" control-label">Feedback descritivo:</label>
                        <input type="text" class="form-control" name="feedback_cli"/>
                    </div>    
                    <div class="col-md-4 mb-3" >
                        </br><button type="submit" class="btn btn-primary botao" name="btnOperacao" value="EXCLUIR">ATRIBUIR</button>
                    </div>
                </form>

                <%}// fim do if %>

                <div class="col-md-12 mb-3" >

                    <input type="hidden" value ="<%=c.getCha_cli_id()%>" class="form-control" name="cha_cli_id" readonly=""/>
                    <input type="hidden" value ="<%=c.getId()%>" class="form-control" name="id" readonly=""/>
                </div>

                <div class="col-md-6 mb-3" >
                    <label class="control-label">Nota para o funcionario:</label>
                    <%
                        if (c.getCha_nota_fun() == 0) {
                    %>
                    <i class="glyphicon glyphicon-star-empty"></i>
                    <%
                    } else {
                        for (int i = 0; i < c.getCha_nota_fun(); i++) {
                    %>
                    <i class="glyphicon glyphicon-star" style="color:yellowgreen;"></i>
                    <% }//for
                        }//else
                    %>
                    <input value ="<%=c.getCha_nota_fun()%>" type="hidden" class="form-control" name="cha_cli" readonly=""/>
                </div>
                </br>
                <div class="col-md-12 mb-3" >
                    <%=c.getCha_feedback_fun().trim()%> 
                    <%if(usuarioLogado.getUsu_id_owner() == c.getCha_cli_id()){%>
                    &nbsp; 
                    <a href="/podechamar_v1/FeedbackFuncionario?btnOperacao=EXCLUIR&id=<%=c.getId()%>&nota_fun=0&feedback_fun=<%=c.getCha_feedback_fun()%>" class="btn btn-default" > <i class="glyphicon glyphicon-pencil"></i></a>
                    <%}%>
                </div>
                <div class="col-md-0 mb-3" >

                    <input type="hidden" value ="<%=c.getCha_cli_id()%>" class="form-control" name="cha_cli_id" readonly=""/>
                    <input type="hidden" value ="<%=c.getId()%>" class="form-control" name="id" readonly=""/>
                </div>

                <div class="col-md-6 mb-3" >
                    </br>
                    <label class="control-label">Nota para o cliente:</label>
                    <%

                        if (c.getCha_nota_cli() == 0) {
                    %>
                    <i class="glyphicon glyphicon-star-empty"></i>
                    <%
                    } else {

                        for (int i = 0; i < c.getCha_nota_cli(); i++) {
                    %>
                    <i class="glyphicon glyphicon-star" style="color:yellowgreen;"></i>
                    <%
                            }//for
                        }//else
%>
                    <input value ="<%=c.getCha_nota_cli()%>" type="hidden" class="form-control" name="cha_cli" readonly=""/>
                </div>
                </br>
                <div class="col-md-12 mb-3" >
                    <%=c.getCha_feedback_cli()%>
                    <%if(usuarioLogado.getUsu_id_owner() == c.getCha_fun_id()){%>
                    &nbsp; 
                    <a href="/podechamar_v1/FeedbackCliente?btnOperacao=EXCLUIR&id=<%=c.getId()%>&nota_cli=0&feedback_cli=<%=c.getCha_feedback_fun()%>" class="btn btn-default" > <i class="glyphicon glyphicon-pencil"></i></a>
                    <%}%>
                </div>
                <div>
                    <%
                        if (mensagem != null) {
                            if (mensagem.length() > 0) {
                    %>

                    <div class="alert alert-info">
                        <strong>Mensagem do sistema:</strong></br>${mensagem}
                    </div>
                    <%
                            }
                        }
                    %>
                </div>
                <%-- 
                rodapé
                --%>    
                </br></br>
                </br>


            </div>

        </div> 
    </body>
</html>
