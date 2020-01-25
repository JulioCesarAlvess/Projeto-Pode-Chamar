<%-- 
    Document   : chamados_novo
    Created on : 30/08/2018, 16:46:18
    Author     : Julio Cesar Alves
--%>

<%@page import="br.com.podechamar.util.Converter"%>
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

                <h2>Dados do Chamado : &nbsp; <%= c.getCha_status()%></h2>
                <%  //atribuir chamado para o funcionário
                    if (usuarioLogado.getUsu_papel().equals("Administrador") && c.getCha_fun().equals("Nao Atribuido") && c.getCha_status().equals("Aberto")) {%>
                <form action="AtribuirFuncionario">

                    <div class="col-md-8 mb-3" >
                        <input type="hidden" value ="<%=c.getId()%>" class="form-control" name="id"/>
                        <label class=" control-label">Atribuir Funcionário:</label>
                        <select class="form-control" name="funcionario_id">
                            <option value="0">Selecione</option>
                            <%
                                for (Funcionario f : funcionarios) {
                                    if (f.getFun_dep() == usuarioLogado.getUsu_dep() && f.getFun_nivel().equals("Operacional")) {
                            %>
                            <option value="<%=f.getId()%>" ><%=f.getFun_nome()%></option>
                            <%
                                    }//if
                                }//for
                            %>
                        </select>
                    </div>
                    <div class="col-md-4 mb-3" >
                        </br><button type="submit" class="btn btn-primary botao" name="btnOperacao" value="EXCLUIR">ATRIBUIR</button>
                    </div>
                </form>
                <%}%>

                <div class="col-md-6 mb-3" >
                    <label class="control-label">Cliente:</label>
                    <input value ="<%=c.getCha_cli()%>" type="text" class="form-control" name="cha_cli" readonly=""/>
                    <input type="hidden" value ="<%=c.getCha_cli_id()%>" class="form-control" name="cha_cli_id" readonly=""/>
                    <input type="hidden" value ="<%=c.getId()%>" class="form-control" name="id" readonly=""/>
                </div>
                <div class="col-md-3 mb-3">
                    <label class=" control-label">Abertura:</label>
                    <input value ="<%=c.getCha_databertura()%>" type="text" class="form-control" name="cha_databertura" placeholder="data de abertura" readonly=""/>
                    <input type="hidden" value ="<%=c.getCha_datafechamento()%>" class="form-control" name="cha_datafechamento" readonly=""/>
                    <input type="hidden" value ="<%=c.getCha_feedback_cli()%>"  class="form-control" name="cha_feedback_cli" readonly=""/>
                    <input type="hidden" value ="<%=c.getCha_feedback_fun()%>"  class="form-control" name="cha_feedback_fun" readonly=""/>
                    <input type="hidden" value ="<%=c.getCha_nota_fun()%>"  class="form-control" name="cha_nota_fun" readonly=""/>
                    <input type="hidden" value ="<%=c.getCha_nota_cli()%>"  class="form-control" name="cha_nota_cli" readonly=""/>
                    <input type="hidden" value ="<%=c.getCha_sla()%>"  class="form-control" name="cha_sla" readonly=""/>

                </div>
                <div class="col-md-2 mb-3">
                    <label class=" control-label">Tipo:</label>
                    <input value ="<%=c.getCha_tipo()%>" type="text" class="form-control" name="cha_tipo" placeholder="data de abertura" readonly=""/>
                    <input value ="<%=c.getCha_tipo_id()%>" type="hidden" class="form-control" name="cha_tipo_id" placeholder="data de abertura" readonly=""/>
                </div>
                <div class="col-md-1 mb-3">
                    <label class=" control-label">Chamado:</label>
                    <input value ="<%=c.getId()%>" type="text" class="form-control" name="id" placeholder="data de abertura" readonly=""/>
                </div>
                <div class="col-md-6 mb-3" >
                    <label class="control-label">Solicitante</label>
                    <input type="text" class="form-control" name="cha_solicitante" placeholder="Solicitante" value ="<%=c.getCha_solicitante()%>" readonly=""/>
                </div >
                <div class="col-md-3 mb-3">
                    <label class=" control-label">Severidade:</label>
                    <input type="text" class="form-control" name="cha_severidade" placeholder="Severidade" value ="<%=c.getCha_severidade()%>" readonly=""/>
                </div>
                <div class="col-md-3 mb-3">
                    <label class=" control-label">Departamento:</label>
                    <input type="text" class="form-control" name="cha_dep" placeholder="Severidade" value ="<%=c.getCha_dep()%>" readonly=""/>
                    <input type="hidden" class="form-control" name="cha_dep_id" placeholder="Severidade" value ="<%=c.getCha_dep_id()%>" readonly=""/>
                </div>
                <div class=" col-md-12 mb-3">
                    </br>
                    <label for="exampleFormControlTextarea6">Descritivo</label>
                    <input type="text" class="form-control" name="cha_descricao" placeholder="Solicitante" value ="<%=c.getCha_descricao()%>" readonly=""/>
                </div>
                <div class=" col-md-12 mb-3">
                    </br>
                    <label for="exampleFormControlTextarea6">Funcionário:</label>
                    <input type="text" class="form-control" name="cha_fun" value ="<%=c.getCha_fun()%>" readonly=""/>
                </div>
            </div>
            </br>
            <div class="row">
                <hr>
                <h3>Produtos</h3>

                <%if (usuarioLogado.getUsu_papel().equals("Operacional") && c.getCha_status().equals("Pendente")) {%>
                <form action="ChamadoAdicionarProduto">
                    <div class="col-md-4 mb-3">
                        <input type="hidden" value ="<%=c.getId()%>" class="form-control" name="id"/>
                        <label class=" control-label">Produto:</label>
                        <select class="form-control" name="id_produto">
                            <option value="0">Selecione</option>
                            <%
                                for (Produto p : produtos) {

                            %>
                            <option value="<%=p.getId()%>" ><%=p.getPro_nome() + " " + Converter.criaDinheiro(p.getPro_preco_venda()) %></option>
                            <%
                                }//for
                            %>
                        </select>

                    </div >
                    <div class="col-md-4 mb-3">
                        <label class=" control-label">Quantidade:</label>
                        <input type="text" class="form-control" name="quantidade" placeholder="Quantidade" />
                    </div >
                    <div class="col-md-4 mb-3">

                        </br><button type="submit" class="btn btn-primary botao" name="btnOperacao" value="EXCLUIR" >ADICIONAR PRODUTO </button>
                    </div >
                </form>
                <%}//if
                %>

                <%
                    if (c.getItens() != null) {
                %>    
                <div class="row">
                    <table class="table table-hover table-condensed" >
                        <thead >
                            <tr>
                                <th>Nome: </th>
                                <th>Quantidade: </th>
                                <th>Valor Unitario: </th>
                                <th>Valor do Item: </th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                for (Item i : c.getItens()) {
                                    total += i.getP().getPro_preco_venda() * i.getQuantidade();
                            %>
                            <tr>
                                <td> <%= i.getP().getPro_nome()%> </td>
                                <td> <%= i.getQuantidade()%> </td>
                                <td> <%= Converter.criaDinheiro(i.getP().getPro_preco_venda())%> </td>
                                <td> <%= Converter.criaDinheiro(i.getP().getPro_preco_venda() * i.getQuantidade()) %> </td>
                                <td> <a href="/podechamar_v1/ChamadoExcluirItem?btnOperacao=EXCLUIR&pro_id=<%= i.getP().getId()%>&cha_id=<%= c.getId()%>&quantidade=<%=i.getQuantidade()%> " class="btn btn-default" >Excluir</a> </td>
                            </tr>
                            <%  }//for
%>
                        </tbody>
                        <tfoot class="text-uppercase">
                            <tr><td>
                        <bold>Valor Total dos Produtos: <%= Converter.criaDinheiro(total) %> </bold>
                        </td></tr>
                        </tfoot>
                    </table>
                </div>
                <%
                    } //if
                %>

            </div>
            <div class="row">
                <hr>
                <h3>Atividades</h3>

                <%if (usuarioLogado.getUsu_papel().equals("Operacional") && c.getCha_status().equals("Pendente")) {%>
                <form action="ChamadoAdicionarAtividade">
                    <div class="col-md-4 mb-3">
                        <input type="hidden" value ="<%=c.getId()%>" class="form-control" name="id"/>
                        <label class=" control-label">Atividade:</label>
                        <select class="form-control" name="id_atividade">
                            <option value="0">Selecione</option>
                            <%
                                for (Atividade a : atividades) {

                            %>
                            <option value="<%=a.getId()%>" ><%=a.getAti_nome()%></option>
                            <%
                                }//for
                            %>
                        </select>

                    </div >
                    <div class="col-md-4 mb-3">

                        </br><button type="submit" class="btn btn-primary botao" name="btnOperacao" value="EXCLUIR" >ADICIONAR ATIVIDADE </button>
                    </div >
                </form>
                <%}//if
                %>

                <%
                    if (c.getAtividades() != null) {
                %>    
                <div class="row">
                    <table class="table table-hover table-condensed" >
                        <thead >
                            <tr>
                                <th>Atividade: </th>
                                <th>Descrição: </th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                for (Atividade a : c.getAtividades()) {
                                    cont++;
                            %>
                            <tr>
                                <td> <%= a.getAti_nome()%> </td>
                                <td> <%= a.getAti_descricao()%> </td>
                                <td> <a href="/podechamar_v1/ChamadoExcluirAtividade?btnOperacao=EXCLUIR&ati_id=<%= a.getId()%>&cha_id=<%= c.getId()%> " class="btn btn-default" >Excluir</a> </td>
                            </tr>
                            <%  }//for
%>
                        </tbody>
                        <tfoot class="text-uppercase">
                            <tr>
                                <td>
                        <bold>
                            Número de Atividades : <%=cont%>
                        </bold>
                        </td>
                        </tr>
                        </tfoot>
                    </table>
                </div>
                <%
                    } //if
                %>

                <%if (usuarioLogado.getUsu_papel().equals("Operacional") && c.getCha_status().equals("Pendente")) {%>
                <div class="row">
                    <form action="ConcluirChamado">
                        </br>
                        <input type="hidden" value ="<%=c.getId()%>" class="form-control" name="id"/>
                        <button type="submit" class="btn btn-success botao" name="btnOperacao" value="EXCLUIR" style="position:absolute; right:100px"> CONCLUIR CHAMADO </button>
                    </form>
                </div>
                <%}%>
                <%if (usuarioLogado.getUsu_papel().equals("Cliente") && (c.getCha_status().equals("Pendente") || c.getCha_status().equals("Aberto"))) {%>
                <div class="row">
                    <form action="CancelarChamado">
                        </br>
                        <input type="hidden" value ="<%=c.getId()%>" class="form-control" name="id"/>
                        <button type="submit" class="btn btn-success botao" name="btnOperacao" value="EXCLUIR" style="position:absolute; right:100px"> CANCELAR CHAMADO </button>
                    </form>
                </div>
                <%}%>
            </div>



            <div style="width: 700px">
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
            </br>
            <hr>
            <h5>@Pode Chamar 0.1 - 2018</h5>     

        </div> 
    </body>
</html>
