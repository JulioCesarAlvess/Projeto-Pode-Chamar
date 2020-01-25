
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

            <form role="form" class="form-horizontal" action="SalvarFuncionario" method="post">
                <div class="row">
                     </br></br></br>
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
                    <div class="form-group">
                       
                        <h2>&nbsp;Atualizar Contrato </h2>
                        <h3>&nbsp;Dados do Contrato </h3>
                    </div>
                    <div class="col-md-6 mb-3" >
                        <label class="control-label">Cliente: </label>
                        <input type="text" class="form-control" name="" placeholder="" value="Empresa Tal" readonly="true" />
                    </div>
                    <div class="col-md-6 mb-3">
                        <label class=" control-label">Numero Contrato: </label>
                        <input type="text" class="form-control" name="" placeholder="" value="100345"readonly="true" />
                    </div>
                    <div class="col-md-6 mb-3">
                        <label class=" control-label">Data Inicio: </label>
                        <input type="text" class="form-control" name="" placeholder="" value="12/05/2018"/>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label class=" control-label">Data Termino: </label>
                        <input type="text" class="form-control" name="" placeholder="" value="12/05/2019"/>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label class=" control-label">Valor: </label>
                        <input type="text" class="form-control" name="" placeholder="" value="300.00" />
                    </div>
                    <div class="col-md-6 mb-3">
                        <label class=" control-label">Dia Vencimento: </label>
                        <input type="text" class="form-control" name="" placeholder="" value="15"/>
                    </div>
                </div>
                <div class="row" >
                    <div class="form-group">
                        <br/>
                        <hr>
                        <h3>&nbsp;Dados SLA </h3>

                        <div class="col-md-6 mb-3" >
                            <label class="control-label">&nbsp;&nbsp;Tempo Maximo Finalização Serviço </label>
                            <input type="text" class="form-control" name="" placeholder="" value=""/>
                        </div>
                        <div class="col-md-6 mb-3" >
                            <label class="control-label">Percentual de desconto em não cumprimento da SLA </label>
                            <input type="text" class="form-control" name="" placeholder="" value="" />
                        </div>

                        <div class="col-md-6 mb-3">
                            <label class=" control-label">&nbsp;&nbsp;Permissão Inclusão de Produtos: </label>
                            <select class="form-control" name="">
                                <option value="">Selecione</option>
                                <option value="Ativo" selected> Permitido </option>
                                <option value="Inativo" > Negado </option>
                            </select>
                        </div>
                        <div class="col-md-6 mb-3">
                            <label class=" control-label"> Permissão para Chamado Técnico: </label>
                            <select class="form-control" name="">
                                <option value="">Selecione</option>
                                <option value="Ativo" selected> Permitido </option>
                                <option value="Inativo" > Negado </option>
                            </select>
                        </div>
                        <div>
                            <label class=" control-label">&nbsp;&nbsp;&nbsp;&nbsp;Nova Regra: </label>
                        </div>
                        <div id="origem" >
                            <div class="col-md-6 mb-3" >
                                <label class="control-label">Regra: </label>
                                <input type="text" class="form-control" name="" placeholder="" value="Descrição"/>
                            </div>
                            <div class="col-md-6 mb-3" >
                                <label class="control-label">Descrição: </label>
                                <input type="text" class="form-control" name="" placeholder="" value="Descrição"/>
                            </div>
                        </div>
                        <div id="destino">
                        </div>
                        <div class="col-md-6 mb-3" >
                            </br>
                            &nbsp;&nbsp;<input  type="button" value ="Nova Regra"  class="btn btn-default" style="cursor: pointer;" onclick="duplicarCampos();">
                            <input  type="button" value ="Excluir Regra" class="btn btn-default" style="cursor: pointer;" onclick="removerCampos(this);"> 
                        </div>
                    </div>
                </div>



                <div class="row">
                    <div class="col-md-1 mb-3">
                        </br><button type="submit" class="btn btn-primary botao" name="btnOperacao" value="SALVAR"> Gravar </button>
                    </div>
                    <div class="col-md-1 mb-3">
                        </br><a href="/podechamar_v1/contrato_boleto.jsp" class="btn btn-primary botao" > Boletos</a> </button>
                    </div>
                </div>
            </form>
            <%-- 
            rodapé
            --%>                  
            <hr>
            <h5>@Pode Chamar 0.1 - 2018</h5>      
        </div>  
        <script>
            function duplicarCampos() {
                var clone = document.getElementById('origem').cloneNode(true);
                var destino = document.getElementById('destino');
                destino.appendChild(clone);
                var camposClonados = clone.getElementsByTagName('input');
                for (i = 0; i < camposClonados.length; i++) {
                    camposClonados[i].value = '';
                }
            }
            function removerCampos(id) {
                var node1 = document.getElementById('destino');
                node1.removeChild(node1.childNodes[0]);
            }
        </script>

    </body>
</html>
