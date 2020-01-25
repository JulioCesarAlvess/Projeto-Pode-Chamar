<%-- 
    Document   : home
    Created on : 21/08/2018, 21:10:14
    Author     : Julio Cesar Alves
--%>

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
        <div class="container ">
            <%
                Cliente c = (Cliente) request.getAttribute("cliente");
                Contrato con = c.getCli_contrato();
                String mensagem = (String) request.getAttribute("mensagem");
            %>

            <form role="form" class="form-horizontal" action="AlterarCliente" method="post">
                <div class="row">
                    <div class="form-group">
                        </br></br></br>
                        <h2>&nbsp;Atualizar Cliente</h2>
                        <h3>&nbsp;Dados do Cliente</h3>
                    </div>
                    <div class="col-md-6 mb-3" >
                        <input type="hidden" name="id" value="<%=c.getCli_id()%>">
                        <label class="control-label">Razão Social:</label>
                        <input type="text" class="form-control" name="cli_rasaosocial" placeholder="Razao Social" value=" <% if (c != null)%> <%= c.getCli_rasaosocial()%> " readonly=""/>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label class=" control-label">CNPJ:</label>
                        <input type="text" class="form-control" name="cli_cnpj" placeholder="CNPJ" value=" <% if (c != null)%> <%= c.getCli_cnpj()%> " readonly="" />
                    </div>
                    <div class="col-md-6 mb-3">
                        <label class=" control-label">Contato:</label>
                        <input type="text" class="form-control" name="cli_contato" placeholder="Pessoa para contato" value=" <% if (c != null)%> <%= c.getCli_contato()%> "/>
                    </div>
                    <div class="col-md-3 mb-3">
                        <label class=" control-label">Status:</label>
                        <select class="form-control" name="cli_status">
                            <option value="">Selecione</option>
                            <option value="Ativo" <% if (c.getCli_status().equals("Ativo")) {%> selected="" <% } %>>Ativo</option>
                            <option value="Inativo" <% if (c.getCli_status().equals("Inativo")) {%> selected="" <% } %>>Inativo</option>
                            <option value="Bloqueado" <% if (c.getCli_status().equals("Bloqueado")) {%> selected="" <% } %>>Bloqueado</option>
                        </select>
                    </div>
                    <div class="col-md-3 mb-3">
                        <label class=" control-label">Telefone:</label>
                        <input type="text" class="form-control " name="cli_telefone" placeholder="Telefone para contato" value=" <% if (c != null)%> <%= c.getCli_telefone()%> " />
                    </div>
                    <div class="col-md-6 mb-3">
                        <label class=" control-label">Nome Fantasia:</label>
                        <input type="text" class="form-control" name="cli_nomefantasia" placeholder="Nome fantasia" value=" <% if (c != null)%> <%= c.getCli_nomefantasia()%> "/>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label class=" control-label">E-mail:</label>
                        <input type="text" class="form-control" name="cli_email" placeholder="E-mail" value=" <% if (c != null)%> <%= c.getCli_email()%> "/>
                    </div>
                    <div class="col-md-12 mb-3">
                        <label class=" control-label">Ramo de atividade:</label>
                        <input type="text" class="form-control" name="cli_ramoatividade" placeholder="Ramo de atividade" value=" <% if (c != null)%> <%= c.getCli_ramoatividade()%> " />
                    </div>
                </div> 
                <div class="row">
                    <div class="form-group">
                        <%-- 
                          end_rua character varying(255),
                          end_numero character varying(255),
                          end_bairro character varying(255),
                          end_cidade character varying(255),
                          end_estado character varying(255),
                          end_pais character varying(255),
                        --%>   
                        </br>
                        <hr>
                        <h3>&nbsp;Endereço</h3>
                    </div>
                    <div class="col-md-3 mb-3" >
                        <input type="hidden" name="end_id" value="<%=c.getCli_endereco().getId()%>">
                        <label class="control-label">Cep:</label>
                        <input type="text" class="form-control" name="end_cep" placeholder="Cep" value=" <% if (c != null)%> <%= c.getCli_endereco().getEnd_cep()%> "/>
                    </div>
                    <div class="col-md-7 mb-3" >
                        <label class="control-label">Rua:</label>
                        <input type="text" class="form-control" name="end_rua" placeholder="Rua" value=" <% if (c != null)%> <%= c.getCli_endereco().getEnd_rua()%> " />
                    </div>
                    <div class="col-md-2 mb-3" >
                        <label class="control-label">Número:</label>
                        <input type="text" class="form-control" name="end_numero" placeholder="Número" value=" <% if (c != null)%> <%= c.getCli_endereco().getEnd_numero()%> " />
                    </div>
                    <div class="col-md-5 mb-3" >
                        <label class="control-label">Bairro:</label>
                        <input type="text" class="form-control" name="end_bairro" placeholder="Bairro" value=" <% if (c != null)%> <%= c.getCli_endereco().getEnd_bairro()%> " />
                    </div>
                    <div class="col-md-4 mb-3" >
                        <label class="control-label">Cidade:</label>
                        <input type="text" class="form-control" name="end_cidade" placeholder="Cidade" value=" <% if (c != null)%> <%= c.getCli_endereco().getEnd_cidade()%> " />
                    </div>
                    <div class="col-md-1 mb-3" >
                        <label class="control-label">UF:</label>
                        <input type="text" class="form-control" name="end_estado" placeholder="Estado" value=" <% if (c != null)%> <%= c.getCli_endereco().getEnd_estado()%> " />
                    </div>
                    <div class="col-md-2 mb-3" >
                        <label class="control-label">País:</label>
                        <input type="text" class="form-control" name="end_pais" placeholder="País:" value=" <% if (c != null)%> <%= c.getCli_endereco().getEnd_pais()%> " />
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-3 mb-3">
                        </br><button type="submit" class="btn btn-primary botao" name="btnOperacao" value="ALTERAR">GRAVAR </button>
                    </div>
                </div>
            </form>
            <div>
                <%
                    if (mensagem != null) {
                %>
                </br>
                <div class="alert alert-info">
                    <strong>Mensagem do sistema:</strong> </br>  ${mensagem}
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
