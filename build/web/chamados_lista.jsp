<%-- 
    Document   : home
    Created on : 21/08/2018, 21:10:14
    Author     : Julio Cesar Alves
--%>

<%@page import="br.com.podechamar.util.Converter"%>
<%@page import="br.com.podechamar.dominio.Usuario"%>
<%@page import="br.com.podechamar.dominio.*"%>
<%@page import="java.util.List"%>
<%@page import="br.com.podechamar.dominio.Cliente"%>
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
        <script language="Javascript">
            window.onload = function () {
                setTimeout('location.reload();', 20000);
            }
        </script>
        <%
            List<Chamado> chamados = (List<Chamado>) request.getAttribute("chamados");
            Usuario usuarioLogado = (Usuario) session.getAttribute("usuAutenticado");
            int cont = 0;
            int contConcluido = 0;
            int contRetido = 0;
            int contAberto = 0;
            int contCancelado = 0;
            int contPendente = 0;
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
          cli_id integer NOT NULL,
          cli_rasaosocial character varying(255),
          cli_nomefantasia character varying(255),
          cli_contato character varying(255),
          cli_cnpj character varying(255),
          cli_ramoatividade character varying(255),
          cli_email character varying(255),
          cli_telefone character varying(255),
          cli_datcadastro timestamp without time zone,
          cli_status character varying(255)
        --%>        
        <div class="container">
            <form role="form" class="form-horizontal" action="ListarChamado" >
                <div class="form-group">
                    <h2>Chamados</h2>
                </div>
                <div class="form-group">

                    <div class="col-md-11 mb-3"  >
                        <input type="text" name="busca" class="form-control" placeholder="Digite a sua busca aqui"/></br>                      
                    </div >
                    <div class="col-md-1 mb-3">
                        <button type="submit" class="btn btn-primary botao" value="BUSCAR" name="btnOperacao"> <i class="glyphicon glyphicon-search"></i> </button>
                    </div>
                </div>
                <%
                    for (Chamado c : chamados) {
                        cont++;
                        if (c.getCha_status().equals("Aberto")) {
                            contAberto++;
                        }
                        if (c.getCha_status().equals("Cancelado")) {
                            contCancelado++;
                        }
                        if (c.getCha_status().equals("Pendente")) {
                            contPendente++;
                        }
                        if (c.getCha_status().equals("Concluido")) {
                            contConcluido++;
                        }
                        if (c.getCha_status().equals("Retido")) {
                            contRetido++;
                        }
                    }//for
                %>   
                <h2 class="">Lista de Chamados 
                    <%if (usuarioLogado.getUsu_papel().equals("Cliente")) {%>
                    <a href="/podechamar_v1/chamados_novo.jsp" class="btn btn-primary">Abrir Chamado</a>
                    <%}//if%>
                </h2>
                <div class="col-md-2 mb-3" style="background-color: lightgray; border-radius: 10px;padding-bottom: 10px;"  >
                    <label class=" control-label">Total: </label>
                    <%=cont%>
                </div>

                <div class="col-md-2 mb-3" style="background-color: green; color:white; border-radius: 10px; padding-bottom: 10px;">
                    <label class=" control-label">Abertos: </label>
                    <%=contAberto%>
                </div>
                <div class="col-md-2 mb-3" style="background-color: yellow; color: #000; border-radius: 10px; padding-bottom: 10px;">
                    <label class=" control-label">Pendentes: </label>
                    <%=contPendente%>
                </div>
                <div class="col-md-2 mb-3" style="background-color: blue; color: white; border-radius: 10px; padding-bottom: 10px;">
                    <label class=" control-label">Concluídos: </label>
                    <%=contConcluido%>
                </div>
                <div class="col-md-2 mb-3" style="background-color: lightblue; color: black; border-radius: 10px; padding-bottom: 10px;">
                    <label class=" control-label">Cancelados: </label>
                    <%=contCancelado%>
                </div>
                <div class="col-md-2 mb-3" style="background-color: red; color: white; border-radius: 10px; padding-bottom: 10px;">
                    <label class=" control-label">Retidos: </label>
                    <%=contRetido%>
                </div>
                </br></br>

                <div class="container">
                    <%
                        if (chamados != null) {
                    %>    
                    <table class="table table-hover table-condensed">
                        <thead >
                            <tr>
                                <th>Chamado: </th>
                                <th>Departamento: </th>
                                <th>Abertura: </th>
                                <th>Fim: </th>
                                <th>Responsável: </th>
                                <th>Cliente: </th>
                                <th>Tipo: </th>
                                <th>Severidade: </th>
                                <th>SLA: </th>
                                <th>Status: </th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <%   for (Chamado c : chamados) {
                            %>
                            <tr>
                                <td><%=c.getId()%> </td>
                                <td><%=c.getCha_dep()%> </td>
                                <td><%=c.getCha_databertura()%> </td>
                                <td><%=c.getCha_datafechamento()%> </td>
                                <td><%=c.getCha_fun()%> </td>
                                <td> <%=c.getCha_cli()%> </td>
                                <td> <%= c.getCha_tipo()%> </td>

                                <td> <%=c.getCha_severidade()%> </td>
                                <td> <%=Converter.criaHora(c.getCha_sla())%> </td>
                                <td> <%=c.getCha_status()%> </td>
                                <td> 
                                    <%if (c.getCha_status().equals("Aberto")) {
                                    %>
                                    <button type="button" class="btn btn-default btn-circle" style="background-color: green"></button><%//= //c.getCli_status() %> 
                                    <%}%>
                                    <%if(c.getCha_status().equals("Pendente")){
                                    %>
                                    <button type="button" class="btn btn-default btn-circle" style="background-color: yellow"></button><%//= //c.getCli_status() %> 
                                    <%}%>
                                    <%if(c.getCha_status().equals("Concluido")){
                                    %>
                                    <button type="button" class="btn btn-default btn-circle" style="background-color: blue"><i class="glyphicon glyphicon-ok" style="color: lightblue"></i></button> 
                                        <%}%>
                                        <%if (c.getCha_status().equals("Cancelado")) {
                                        %>
                                    <button type="button" class="btn btn-default btn-circle" style="background-color: lightblue"><i class="glyphicon glyphicon-ok" style="color: white"></i></button> 
                                        <%}%>
                                        <%if (c.getCha_status().equals("Retido")) {
                                        %>
                                    <button type="button" class="btn btn-default btn-circle" style="background-color: red"></button>
                                    <%}%>
                                </td>

                                <td><a href="/podechamar_v1/VisualizaChamado?btnOperacao=BUSCAR&id=<%= c.getId()%> " class="btn btn-default"><i class="glyphicon glyphicon-folder-open"></i></a> </td>
                                        <%
                                            //fazer o feedback
                                            if (c.getCha_status().equals("Concluido")) {
                                        %>
                                <td>
                                    <%
                                        if (c.getCha_nota_cli() == 0 && usuarioLogado.getUsu_papel().equals("Operacional")) {
                                    %>
                                    <a href="/podechamar_v1/Feedback?btnOperacao=BUSCAR&id=<%= c.getId()%> " class="btn btn-default"><i class="glyphicon glyphicon-star-empty"></i></a> 
                                        <%
                                        }//if para o caso do funcionario não ter dado a nota
                                        else if (c.getCha_nota_fun() == 0 && usuarioLogado.getUsu_papel().equals("Cliente")) {
                                        %>
                                    <a href="/podechamar_v1/Feedback?btnOperacao=BUSCAR&id=<%= c.getId()%> " class="btn btn-default"><i class="glyphicon glyphicon-star-empty"></i></a> 
                                        <%
                                        }//if para o caso do cliente não ter dado a nota
                                        else if ((c.getCha_nota_fun() == 0 || c.getCha_nota_cli() == 0) && usuarioLogado.getUsu_papel().equals("Administrador")) {
                                        %>
                                    <a href="/podechamar_v1/Feedback?btnOperacao=BUSCAR&id=<%= c.getId()%> " class="btn btn-default"><i class="glyphicon glyphicon-star-empty"></i></a> 
                                        <%} // if para o supervisor logado e sem uma das notas
                                        //else para o caso de o chamado já ter tido o feedback
                                        else {
                                        %>
                                    <a href="/podechamar_v1/Feedback?btnOperacao=BUSCAR&id=<%= c.getId()%> " class="btn btn-default"><i class="glyphicon glyphicon-star" style="color: yellowgreen"></i></a>
                                        <%}//else%>
                                </td>
                                <%
                                    }//if do feedback
                                %>
                                
                                <%
                                    //verificar os chamados retidos e solicitar a justificativa
                                    if (c.getCha_status().equals("Retido")) {
                                        if(c.getCha_justificativa().equals("Sem Justificativa")){
                                   
                                %>
                                    <td><a href="/podechamar_v1/Justificativa?btnOperacao=BUSCAR&id=<%= c.getId()%> " class="btn btn-default"><i class="glyphicon glyphicon-exclamation-sign" style="color: red"></i></a><td>
                                <%      }//if do retido sem justificativa
                                        //else para a justificativa apresentada
                                        else{
                                    %>
                                    <td><a href="/podechamar_v1/Justificativa?btnOperacao=BUSCAR&id=<%= c.getId()%> " class="btn btn-default"><i class="glyphicon glyphicon-ok" style="color: green"></i></a><td>                                    
                                    <%
                                        }//else
                                    }//if do retido
                                %>
                            </tr>
                            <%-- 
                            //código comentado que foi usado para teste  
                            <tr>
                                <td>003 <%//= //c.getCli_rasaosocial() %> </td>
                                <td> 19/10/2018 <%//= //c.getCli_nomefantasia() %> </td>
                                <td> Leonardo de faria <%//= //c.getCli_contato() %> </td>
                                <td> Gerdau<%//= //c.getCli_telefone() %> </td>
                                <td> Dúvida<%//= //c.getCli_email() %> </td>

                                <td> Normal<%//= //c.getCli_ramoatividade() %> </td>
                                <td> 24 horas<%//= //c.getCli_ramoatividade() %> </td>
                                <td> Retido<%//= //c.getCli_ramoatividade() %> </td>
                                <td> <button type="button" class="btn btn-default btn-circle" style="background-color: red"></button><%//= //c.getCli_status() %> </td>

                                <td><a href="/podechamar_v1/chamados_atualizar.jsp" class="btn btn-default">Concluir/Cancelar</a> <td>
                                <td><a href="/podechamar_v1/chamados_atualizar.jsp" class="btn btn-default"><i class="glyphicon glyphicon-eye-open"></i></a> <td>

                                <td><div class="dropdown">
                                        <button class="btn btn-danger dropdown-toggle" type="button" data-toggle="dropdown">Justificar
                                            <span class="caret"></span></button>
                                        <ul class="dropdown-menu">
                                            <li>&nbsp; Justificativa: &nbsp;<input type="text" name="busca" class="form-control" placeholder="Digite a Justificativa"/></li>
                                            <li>&nbsp;<button type="submit" class="btn btn-default botao" name="btnOperacao" value="SALVAR">Enviar </button></li>
                                        </ul>
                                    </div><td>
                            </tr>
                            <tr>
                                <td>004 <%//= //c.getCli_rasaosocial() %> </td>
                                <td> 15/13/2018 <%//= //c.getCli_nomefantasia() %> </td>
                                <td> João Pedro<%//= //c.getCli_contato() %> </td>
                                <td> Tivit<%//= //c.getCli_telefone() %> </td>
                                <td> Instalação<%//= //c.getCli_email() %> </td>

                                <td> Normal<%//= //c.getCli_ramoatividade() %> </td>
                                <td> 15 horas<%//= //c.getCli_ramoatividade() %> </td>
                                <td> Concluído<%//= //c.getCli_ramoatividade() %> </td>
                                <td> <button type="button" class="btn btn-default btn-circle" style="background-color: blue"><i class="glyphicon glyphicon-ok" style="color: lightblue"></i></button><%//= //c.getCli_status() %> </td>
                                <td><a href="/podechamar_v1/chamados_atualizar.jsp" class="btn btn-default">Concluir/Cancelar</a> <td>
                                <td><a href="/podechamar_v1/chamados_atualizar.jsp" class="btn btn-default"><i class="glyphicon glyphicon-eye-open"></i></a> <td>


                            </tr>
                            <tr>
                                <td>005 <%//= //c.getCli_rasaosocial() %> </td>
                                <td> 15/13/2018 <%//= //c.getCli_nomefantasia() %> </td>
                                <td> João Pedro<%//= //c.getCli_contato() %> </td>
                                <td> Tivit<%//= //c.getCli_telefone() %> </td>
                                <td> Instalação<%//= //c.getCli_email() %> </td>

                                <td> Normal<%//= //c.getCli_ramoatividade() %> </td>
                                <td> 15 horas<%//= //c.getCli_ramoatividade() %> </td>
                                <td> Cancelado<%//= //c.getCli_ramoatividade() %> </td>
                                <td> <button type="button" class="btn btn-default btn-circle" style="background-color: lightblue"><i class="glyphicon glyphicon-ok" style="color: white"></i></button><%//= //c.getCli_status() %> </td>
                                <td><a href="/podechamar_v1/chamados_atualizar.jsp" class="btn btn-default">Concluir/Cancelar</a> <td>
                                <td><a href="/podechamar_v1/chamados_atualizar.jsp" class="btn btn-default"><i class="glyphicon glyphicon-eye-open"></i></a> <td>
                            </tr>
                            --%>

                            <%  }//for
                                }//if
                            %>
                        </tbody>
                        <tfoot class="text-uppercase">
                            <tr><td>
                        <bold>

                        </bold>
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
