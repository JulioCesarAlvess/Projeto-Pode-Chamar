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
                String mensagem = (String) request.getAttribute("mensagem");
            %>

            <form role="form" class="form-horizontal" action="SalvarCliente" method="post">
                <div class="row">
                    <div class="form-group">
                        </br></br></br>
                        <h2>&nbsp;Novo Cliente</h2>
                        <h3>&nbsp;Dados do Cliente</h3>
                    </div>
                    <div class="col-md-6 mb-3" >
                        <label class="control-label">Razão Social:</label>
                        <input type="text" class="form-control" name="cli_rasaosocial" placeholder="Razao Social" />
                    </div>
                    <div class="col-md-6 mb-3">
                        <label class=" control-label">Nome Fantasia:</label>
                        <input type="text" class="form-control" name="cli_nomefantasia" placeholder="Nome fantasia" />
                    </div>
                    <div class="col-md-6 mb-3">
                        <label class=" control-label">Contato:</label>
                        <input type="text" class="form-control" name="cli_contato" placeholder="Pessoa para contato" />
                    </div>
                    <div class="col-md-3 mb-3">
                        <label class=" control-label">Status:</label>
                        <select class="form-control" name="cli_status">
                            <option value="">Selecione</option>
                            <option value="Ativo" >Ativo</option>
                            <option value="Inativo" >Inativo</option>
                            <option value="Bloqueado">Bloqueado</option>
                        </select>
                    </div>
                    <div class="col-md-3 mb-3">
                        <label class=" control-label">Telefone:</label>
                        <input type="text" class="form-control " name="cli_telefone" placeholder="Telefone para contato"  />
                    </div>
                    <div class="col-md-6 mb-3">
                        <label class=" control-label">CNPJ:</label>
                        <input type="text" class="form-control" name="cli_cnpj" placeholder="CNPJ sem traços ou pontos"  />
                    </div>
                    <div class="col-md-6 mb-3">
                        <label class=" control-label">E-mail:</label>
                        <input type="text" class="form-control" name="cli_email" placeholder="E-mail" />
                    </div>
                    <div class="col-md-6 mb-3">
                        <label class=" control-label">Login:</label>
                        <input type="text" class="form-control" name="cli_login" placeholder="Login"  />
                    </div>
                    <div class="col-md-6 mb-3">
                        <label class=" control-label">Senha:</label>
                        <input type="text" class="form-control" name="cli_senha" placeholder="Senha" />
                    </div>
                    <div class="col-md-12 mb-3">
                        <label class=" control-label">Ramo de atividade:</label>
                        <input type="text" class="form-control" name="cli_ramoatividade" placeholder="Ramo de atividade"  />
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
                        <label class="control-label">Cep:</label>
                        <input type="text" class="form-control" name="end_cep" placeholder="Cep" />
                    </div>
                    <div class="col-md-7 mb-3" >
                        <label class="control-label">Rua:</label>
                        <input type="text" class="form-control" name="end_rua" placeholder="Rua"  />
                    </div>
                    <div class="col-md-2 mb-3" >
                        <label class="control-label">Número:</label>
                        <input type="text" class="form-control" name="end_numero" placeholder="Número" />
                    </div>
                    <div class="col-md-5 mb-3" >
                        <label class="control-label">Bairro:</label>
                        <input type="text" class="form-control" name="end_bairro" placeholder="Bairro"  />
                    </div>
                    <div class="col-md-4 mb-3" >
                        <label class="control-label">Cidade:</label>
                        <input type="text" class="form-control" name="end_cidade" placeholder="Cidade"/>
                    </div>
                    <div class="col-md-1 mb-3" >
                        <label class="control-label">UF:</label>
                        <input type="text" class="form-control" name="end_estado" placeholder="UF:"/>
                    </div>
                    <div class="col-md-2 mb-3" >
                        <label class="control-label">País:</label>
                        <input type="text" class="form-control" name="end_pais" placeholder="País:"/>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group">
                        <%-- 
  con_datainicio timestamp without time zone,
  con_diavencimento integer,
  con_valormensalidade numeric(10,2),
  con_valortotal numeric(10,2),
  con_tempo integer,
                        --%>  
                        </br>
                        <hr>
                        <h3>&nbsp;Contrato</h3>
                    </div>
                    <div class="col-md-3 mb-3" >
                        <label class="control-label">Data Início:</label>
                        <input type="text" class="form-control" name="con_datainicio" placeholder="Data de Inicio do Contrato"/>
                    </div>
                    <div class="col-md-3 mb-3" >
                        <label class="control-label">Dia para Vencimento:</label>
                        <input type="text" class="form-control" name="con_diavencimento" placeholder="vencimento"/>
                    </div>
                    <div class="col-md-3 mb-3" >
                        <label class="control-label">Valor Mensalidade:</label>
                        <input type="text"  class="form-control" name="con_valormensalidade" placeholder="Mensalidade"/>
                    </div>
                    <div class="col-md-3 mb-3" >
                        <label class="control-label">Tempo de Contrato em meses:</label>
                        <input type="text" class="form-control" name="con_tempo" placeholder="Contrato"/>
                    </div>
                </div>
                <div class="row">


                    <div class="col-md-2 mb-3">
                        </br><button type="submit" class="btn btn-primary botao" name="btnOperacao" value="SALVAR">SALVAR </button>
                    </div>  


                    <%--  <div class="col-md-2 mb-3">
                          </br><a href="/podechamar_v1/contrato_atualizar.jsp" class="btn btn-primary">SALVAR</a>
                      </div>--%>
                     
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
            </br>
            <hr>
            <h5>@Pode Chamar 0.1 - 2018</h5>      
        </div>  


    </body>
</html>
