
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
                Funcionario f = (Funcionario) request.getAttribute("funcionario");
                String mensagem = (String) request.getAttribute("mensagem");
                HttpServletRequest httpRequest = (HttpServletRequest) request;
                List<Funcionario> funcionarios = (List<Funcionario>) httpRequest.getSession().getAttribute("funcionarios");
                List<Departamento> departamentos = (List<Departamento>) httpRequest.getSession().getAttribute("departamentos");
            %>

            <form role="form" class="form-horizontal" action="AlterarFuncionario" method="post">
                <div class="row">
                    <div class="form-group">
                        </br></br></br>
                        <h2>Atualizar Funcionário </h2>
                        <h3>Dados do Funcionário </h3>
                    </div>
                    <div class="col-md-6 mb-3" >
                        <input type="hidden" name="id" value="<%=f.getId()%>">
                        <label class="control-label">Nome: </label>
                        <input type="text" class="form-control" name="fun_nome" placeholder="Nome Funcionário" value=" <% if (f != null)%> <%= f.getFun_nome()%> " />
                    </div>
                    <div class="col-md-3 mb-3">
                        <label class=" control-label">Numero Funcional :</label>
                        <input type="text" class="form-control" name="fun_nf" placeholder="Numero Funcional" value=" <% if (f != null)%> <%= f.getFun_nf()%> " readonly="" />
                    </div>
                    <div class="col-md-3 mb-3">
                        <label class=" control-label">Responsável:</label>
                        <select class="form-control" name="fun_responsavel">
                            <option value="1">Selecione</option>
                            <%
              
                                for (Funcionario fun : funcionarios) {
                                    if (fun.getFun_nivel().equals("Administrador")) {
                            %>
                            <option value="<%=fun.getId()%>" <%if (fun.getId() == f.getFun_responsavel()) {%> selected=""<%}//%> ><%=fun.getFun_nome()%></option>
                            <%
                                    }//if
                                }//for
                            %>
                        </select>
                    </div>
                    <div class="col-md-3 mb-3">
                        <label class=" control-label">Nivel:</label>
                        <select class="form-control" name="fun_nivel">
                            <option value="">Selecione</option>
                            <option value="Operacional" <% if (f.getFun_nivel().equals("Operacional")) {%> selected="" <% } %>>Operacional</option>
                            <option value="Tecnico" <% if (f.getFun_nivel().equals("Tecnico")) {%> selected="" <% } %>>Tecnico</option>
                            <option value="Administrador" <% if (f.getFun_nivel().equals("Administrador")) {%> selected="" <% } %>>Administrador</option>
                        </select>
                    </div>
                    <div class="col-md-3 mb-3">
                        <label class=" control-label">Status:</label>
                        <select class="form-control" name="fun_status">
                            <option value="">Selecione</option>
                            <option value="Ativo" <% if (f.getFun_status().equals("Ativo")) {%> selected="" <% } %>>Ativo</option>
                            <option value="Inativo" <% if (f.getFun_status().equals("Inativo")) {%> selected="" <% } %>>Inativo</option>
                        </select>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label class=" control-label">Email :</label>
                        <input type="text" class="form-control" name="fun_email" placeholder="Email Funcionário" value=" <% if (f != null)%> <%= f.getFun_email()%> " />

                    </div>
                    <div class="col-md-6 mb-3">
                        <label class=" control-label">Telefone :</label>
                        <input type="text" class="form-control" name="fun_telefone" placeholder="Telefone Funcionário " value=" <% if (f != null)%> <%= f.getFun_telefone()%> " />

                    </div>
                    <div class="col-md-3 mb-3">
                        <label class=" control-label">CPF :</label>
                        <input type="text" class="form-control" name="fun_cpf" placeholder="CPF Funcionário" value=" <% if (f != null)%> <%= f.getFun_cpf()%> " readonly="" />

                    </div>
                    <div class="col-md-3 mb-3">
                        <label class=" control-label">Departamento:</label>
                        <select class="form-control" name="fun_dep">
                            <option value="1">Selecione</option>
                            <%
              
                                for (Departamento dep : departamentos) {

                            %>
                            <option value="<%=dep.getId()%>" <%if (f.getFun_dep() == dep.getId()) {%> selected="" <%}//%> ><%=dep.getDep_nome()%></option>
                            <%

                                }//for
                            %>
                        </select>
                    </div> 
                </div>
                <div class="row">
                    <div class="form-group">
                        <h3>Acesso </h3>
                    </div>
                    <div class="col-md-6 mb-3" >
                        <label class="control-label">Login: </label>
                        <input type="text" class="form-control" name="fun_login" placeholder="Login Funcionário" value=" <% if (f != null)%> <%= f.getFun_login()%> " readonly="" />
                    </div>
                    <div class="col-md-6 mb-3" >
                        <label class="control-label">Senha: </label>
                        <input type="password" class="form-control" name="fun_senha" placeholder="Senha Funcionário" value="<%= f.getFun_senha()%>"  readonly=""/>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-3 mb-3">
                        </br><button type="submit" class="btn btn-primary botao" name="btnOperacao" value="ALTERAR"> Gravar </button>
                    </div>
                </div>
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

        </div> 

    </form>

    <%-- 
    rodapé
    --%>                  
    <hr>
    <h5>@Pode Chamar 0.1 - 2018</h5>      
</div>  
</body>
</html>
