
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
            %>

            <form role="form" class="form-horizontal" action="" method="post">
                <div class="row">
                    <div class="form-group">
                        <h3>Dados do Contrato </h3>
                    </div>
                    <div class="col-md-6 mb-3" >
                        <label class="control-label">Cliente: </label>
                        <input type="text" class="form-control" name="" placeholder="Nome Empresa Contratante" readonly="true" />
                    </div>
                    <div class="col-md-6 mb-3">
                        <label class=" control-label">Numero Contrato: </label>
                        <input type="text" class="form-control" name="" placeholder="Numero do Contrato" readonly="true" />
                    </div>
                    <div class="col-md-6 mb-3">
                        <label class=" control-label">Data Inicio: </label>
                        <input type="text" class="form-control" name="" placeholder="Data de Inicio do Contrato"/>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label class=" control-label">Data Termino: </label>
                        <input type="text" class="form-control" name="" placeholder="Data de Termino do Contrato"/>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label class=" control-label">Valor: </label>
                        <input type="text" class="form-control" name="" placeholder=" Valor mensalidade do Contrato" />
                    </div>
                    <div class="col-md-6 mb-3">
                        <label class=" control-label">Dia Vencimento: </label>
                        <input type="text" class="form-control" name="" placeholder="Dia de vencimento Boleto" />
                    </div>
                   </div>
                
                   <div class="row">
                    <div class="form-group">
                        <h3>Dados SLA </h3>
                    
                    <div class="col-md-6 mb-3" >
                        <label class="control-label">Tempo Maximo Finalização Serviço </label>
                        <input type="text" class="form-control" name="" placeholder="Tempo maximo para Finalização Servico" />
                    </div>
                    <div class="col-md-6 mb-3" >
                        <label class="control-label">Percentual de desconto em não cumprimento da SLA </label>
                        <input type="text" class="form-control" name="" placeholder="Senha Funcionário"  />
                    </div>
               
                    <div class="col-md-6 mb-3">
                        <label class=" control-label">Permissão Inclusão de Produtos: </label>
                        <select class="form-control" name="">
                            <option value="">Selecione</option>
                            <option value="Ativo"> Permitido </option>
                            <option value="Inativo" > Negado </option>
                        </select>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label class=" control-label"> Permissão para Chamado Técnico: </label>
                        <select class="form-control" name="">
                            <option value="">Selecione</option>
                            <option value="Ativo"> Permitido </option>
                            <option value="Inativo" > Negado </option>
                        </select>
                    </div>
                   </div>
                
                <div class="row">
                    <div class="col-md-3 mb-3">
                        </br><button type="submit" class="btn btn-primary botao" name="btnOperacao" value="SALVAR"> Gravar </button>
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
