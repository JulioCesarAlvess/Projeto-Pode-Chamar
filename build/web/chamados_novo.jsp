<%-- 
    Document   : chamados_novo
    Created on : 30/08/2018, 16:46:18
    Author     : Julio Cesar Alves
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
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
            //usuario
            Usuario usuarioLogado = (Usuario) session.getAttribute("usuAutenticado");
            //tipos de chamados
            List<TipoChamado> tipos = (List<TipoChamado>) session.getAttribute("tiposchamado");
            //funcionarios
            List<Funcionario> funcionarios = (List<Funcionario>) session.getAttribute("funcionarios");
            //departamentos
            List<Departamento> departamentos = (List<Departamento>) session.getAttribute("departamentos");
            //data do sistema
            Date data = new Date();

// Create an instance of SimpleDateFormat used for formatting 
// the string representation of date (month/day/year)
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
// Get the date today using Calendar object.
            Date today = Calendar.getInstance().getTime();
// Using DateFormat format method we can create a string 
// representation of a date with the defined format.
            String reportDate = df.format(today);

// Print what date is today!
            //System.out.println("Report Date: " + reportDate);
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

            <form role="form" class="form-horizontal" action="SalvarChamado" method="post">

                <div class="row row-grupo" border="1">
                    </br></br></br>

                    <h2>Abertura de Chamado</h2>

                    <div class="col-md-6 mb-3" >
                        <label class="control-label">Cliente:</label>
                        <input value ="<%=usuarioLogado.getUsu_login()%>" type="text" class="form-control" name="cha_cli" readonly=""/>
                        <input type="hidden" value ="<%=usuarioLogado.getUsu_id_owner()%>" class="form-control" name="cha_cli_id" readonly=""/>
                    </div>
                    <div class="col-md-3 mb-3">
                        <label class=" control-label">Abertura:</label>
                        <input value ="<%=reportDate%>" type="text" class="form-control" name="cha_databertura" placeholder="data de abertura" readonly=""/>
                    </div>
                    <div class="col-md-3 mb-3">
                        <label class=" control-label">Tipo:</label>
                        <select class="form-control" name="cha_tipo_id">
                            <option value="0">Selecione</option>
                            <%

                                for (TipoChamado tip : tipos) {

                            %>
                            <option value="<%=tip.getId()%>" ><%=tip.getTch_nome()%></option>
                            <%

                                }//for
                            %>
                        </select>
                    </div>
                    <div class="col-md-6 mb-3" >
                        <label class="control-label">Solicitante</label>
                        <input type="text" class="form-control" name="cha_solicitante" placeholder="Solicitante" />
                    </div >
                    <div class="col-md-3 mb-3">
                        <label class=" control-label">Severidade:</label>
                        <select class="form-control" name="cha_severidade">
                            <option value="Normal" >Normal</option>
                            <option value="Urgente" >Grave</option>
                            <option value="Critico">Crítico</option>
                        </select>
                    </div>
                    <div class="col-md-3 mb-3">
                        <label class=" control-label">Departamento:</label>
                        <select class="form-control" name="cha_dep_id">
                            <option value="0">Selecione</option>
                            <%
                                for (Departamento dep : departamentos) {

                            %>
                            <option value="<%=dep.getId()%>" ><%=dep.getDep_nome()%></option>
                            <%

                                }//for
                            %>
                        </select>
                    </div>
                    <div class=" col-md-12 mb-3">
                        </br>
                        <label for="exampleFormControlTextarea6">Descritivo</label>
                        <input type="text" class="form-control" name="cha_descricao" placeholder="Solicitante" />
                    </div>
                </div>
                </br>
                <div class="row">
                    <div class="col-md-3 mb-3">
                        </br><button type="submit" class="btn btn-primary botao" name="btnOperacao" value="SALVAR">REGISTRAR CHAMADO </button>
                    </div>
                </div>


                <%
                    if (mensagem != null) {
                        if (mensagem.length() > 0) {
                %>
                </br>
                <div class="alert alert-info">
                    <strong>Mensagem do sistema:</strong></br>${mensagem}
                </div>
                <%
                        }
                    }
                %>
                <%-- 
           rodapé
                --%>                  
                </br>
                <hr>
                <h5>@Pode Chamar 0.1 - 2018</h5>     
        </div>

        <script>
            function inserirLinhaTabelaProduto() {

                // Captura a referência da tabela com id “minhaTabela”
                var table = document.getElementById("minhaTabelaProduto");
                // Captura a quantidade de linhas já existentes na tabela
                var numOfRows = table.rows.length;
                // Captura a quantidade de colunas da última linha da tabela
                var numOfCols = table.rows[numOfRows - 1].cells.length;

                // Insere uma linha no fim da tabela.
                var newRow = table.insertRow(numOfRows);

                // Faz um loop para criar as colunas
                var cont = 0;
                for (var j = 0; j < numOfCols; j++) {

                    // Insere uma coluna na nova linha 
                    newCell = newRow.insertCell(j);
                    // Insere um conteúdo na coluna
                    if (cont === 0) {
                        newCell.innerHTML = '<select class="form-control" name="produtos"> <option value="">Selecione...</option> <option value="visa"> Produto 1</option> <option value="mastercard">Produto 2</option> <option value="alelo">Produto 3</option> <option value="nubank">Produto 4</option></select>';
                    }
                    if (cont === 1) {
                        newCell.innerHTML = '<input class="form-control" min="1" type="number" name="pro_quantidade" value="" placeholder="Quantidade" size="12"/>';
                    }
                    if (cont === 2) {
                        newCell.innerHTML = '<input class="form-control" min="1" type="number" name="pro_quantidade" value="" placeholder="Preço Unitario" size="12" readonly="" />';
                    }
                    if (cont === 3) {
                        newCell.innerHTML = '<input class="form-control" min="1" type="number" name="pro_quantidade" value="" placeholder="Preço Total" size="12"readonly="" />';
                    }
                    cont++;
                }

            }
        </script>
    </div> 
</body>
</html>
