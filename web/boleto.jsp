<%-- 
    Document   : home
    Created on : 21/08/2018, 21:10:14
    Author     : Julio Cesar Alves
--%>

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


        <nav class="navbar navbar-default fixed">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="/podechamar_v1/ChamadoRelStatus">Pode Chamar</a>
                </div>
                <ul class="nav navbar-nav navbar-leftt">
                    <li><a href="/podechamar_v1/ListarChamado">Chamados</a></li>
                    <li><a href="/podechamar_v1/ListarCliente">Clientes</a></li>    
                    <li><a href="/podechamar_v1/contrato_lista.jsp">Contratos</a></li>
                    <li><a href="/podechamar_v1/ListarFuncionario">Funcionários</a></li>
                    <li><a href="/podechamar_v1/ListarProduto">Produtos</a></li>
                    <li><a href="/podechamar_v1/analise.jsp">Análise</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <div class="dropdown">
                        <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                            <span class="caret"></span></button>
                        <ul class="dropdown-menu">
                            <li><a href="/podechamar_v1/index.jsp">Logar</a></li>
                            <li><a href="/podechamar_v1/index.jsp">Sair</a></li>
                            <li><a href="/podechamar_v1/funcionario_alterarSenha.jsp">Alterar Senha</a></li>
                        </ul>
                    </div>
                </ul>
            </div>
        </nav>
        <div class="container">
            </br></br></br>
            <%-- 
      corpo
            --%>  
            <div class="row">
                <div class="form-group">

                    <h2>&nbsp;Boleto </h2>
                </div>
                <div class="col-md-6 mb-3" >
                    <label class="control-label">Cliente: </label>
                    <input type="text" class="form-control" name="" placeholder="" value="Empresa Tal" readonly="true" />
                </div>
                <div class="col-md-3 mb-3">
                    <label class=" control-label">Numero Contrato: </label>
                    <input type="text" class="form-control" name="" placeholder="" value="100345"readonly="true" />
                </div>
                <div class="col-md-3 mb-3">
                    <label class=" control-label">Vencimento: </label>
                    <input type="text" class="form-control" name="" placeholder="" value="05/05/2018"readonly="true" />
                </div>
                <div class="col-md-3 mb-3">
                    Valor mensalidade: <input type="text" class="form-control" name="" placeholder="" value="R$ 300,00"readonly="true" />

                </div>
                <div class="col-md-12 mb-3">
                    </br><h4>Valores Agregados:</h4>
                    <table class="table table-hover">
                        <thead>
                        <th>Serviço</th>
                        <th>Data</th>
                        <th>Produto</th>
                        <th>Valor</th>
                        </thead>
                        <tbody>
                            <tr>
                                <td>003</td>
                                <td>10/04/2018</td>
                                <td>Produto 1</td>
                                <td>R$ 80,00</td>
                            </tr>
                            <tr>
                                <td>003</td>
                                <td>10/04/2018</td>
                                <td>Produto 2</td>
                                <td>R$ 20,00</td>
                            </tr>
                            <tr>
                                <td>003</td>
                                <td>10/04/2018</td>
                                <td>Produto 3</td>
                                <td>R$ 50,00</td>
                            </tr>
                        </tbody>
                        <tfoot>
                            <tr>
                                <td>Total: R$ 150,00</td>
                            </tr>
                        </tfoot>
                    </table>
                    

                </div>
                </br>
                <div class="col-md-3 mb-3">
                    Valor Total: <input type="text" class="form-control" name="" placeholder="" value="R$ 450,00"readonly="true" />

                </div>
                <div class="col-md-3 mb-3">
                    Valor Desconto: <input type="text" class="form-control" name="" placeholder="" value="R$ 0,00"readonly="true" />

                </div>
                <div class="col-md-3 mb-3">
                    Valor Final: <input type="text" class="form-control" name="" placeholder="" value="R$ 450,00"readonly="true" />

                </div>

            </div>

            <%-- 
             rodapé
            --%>  
            <hr>
            <h5>@Pode Chamar 0.1 - 2018</h5>    
        </div>

    </body>
</html>
