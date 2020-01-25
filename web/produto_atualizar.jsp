
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
                Produto p = (Produto) request.getAttribute("produto");
                String mensagem = (String) request.getAttribute("mensagem");
            %>

            <form role="form" class="form-horizontal" action="AlterarProduto" method="post">
                <div class="row">
                    <div class="form-group">
                        </br></br></br>
                        <h2>Atualizar Produto </h2>
                        <h3>Dados do Produto </h3>
                    </div>

                    <div class="col-md-6 mb-3" >
                        <input type="hidden" name="pro_disponivel" value="<%=p.getPro_disponivel()%>">
                        <input type="hidden" name="pro_fisico" value="<%=p.getPro_fisico()%>">
                        <input type="hidden" name="pro_reservado" value="<%=p.getPro_reservado()%>">
                        <input type="hidden" name="pro_quantidade"  value="<%=p.getPro_quantidade()%>"/>
                        <input type="hidden" name="id" value="<%=p.getId()%>">
                        <label class="control-label">Nome: </label>
                        <input type="text" class="form-control" name="pro_nome" placeholder="Nome Produto" value="<%=p.getPro_nome()%>"/>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label class=" control-label">cod. EAN</label>
                        <input type="text" class="form-control" name="pro_ean" placeholder="Código de Barras" value="<%=p.getPro_ean()%>"/>
                    </div>
                    <div class="col-md-12 mb-3">
                        <label class=" control-label">Descrição</label>
                        <input type="text" class="form-control" name="pro_descricao" placeholder="Descrição do Produto" value="<%=p.getPro_descricao()%>"/>
                    </div>

                </div> 
                <div class="row">
                    <div class="form-group">


                    </div>
                    <div class="col-md-3 mb-3" >
                        <label class="control-label">Preço de Compra:</label>
                        <input type="text" class="form-control" name="pro_preco_compra" placeholder="Preço compra Produto" value="<%=p.getPro_preco_compra()%>" />
                    </div>

                    

                    <div class="col-md-3 mb-3" >
                        <label class="control-label">Margem Lucro: </label>
                        <input type="text" class="form-control" name="pro_margem_lucro" placeholder="Margem de Lucro Produto"  value="<%=p.getPro_margem_lucro()%>"/>
                    </div>
                    <div class="col-md-3 mb-3">
                        <label class=" control-label">Tipo:</label>
                        <select class="form-control" name="pro_tipo">
                            <option value="">Selecione</option>
                            <option value="Material" <% if (p.getPro_tipo().equals("Material")) {%>selected="" <% } %>  >Material</option>
                            <option value="Consumível" <% if (p.getPro_tipo().equals("Consumível")) {%>selected="" <% } %> >Consumível</option>
                            <option value="Software" <% if (p.getPro_tipo().equals("Software")) {%>selected="" <% } %> >Software</option>
                        </select>
                    </div>
                    <div class="col-md-3 mb-3">
                        <label class=" control-label">Status:</label>
                        <select class="form-control" name="pro_status">
                            <option value="">Selecione</option>
                            <option value="Ativo" <% if (p.getPro_status().equals("Ativo")) {%>selected="" <% } %> >Ativo</option>
                            <option value="Inativo"  <% if (p.getPro_status().equals("Inativo")) {%>selected="" <% } %> >Inativo</option>
                        </select>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-3 mb-3">
                        </br><button type="submit" class="btn btn-primary botao" name="btnOperacao" value="ALTERAR"> GRAVAR </button>
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
