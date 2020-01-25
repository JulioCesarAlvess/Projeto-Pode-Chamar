<%-- 
    Document   : home
    Created on : 21/08/2018, 21:10:14
    Author     : Julio Cesar Alves
--%>

<%@page import="java.util.Calendar"%>
<%@page import="br.com.podechamar.analise.Linha"%>
<%@page import="br.com.podechamar.analise.Grafico"%>
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

        <style type="text/css">
            #container {
                min-width: 610px;
                max-width: 1000px;
                height: 400px;
                margin: 0 auto
            }
        </style>

    </head>
    <body>
        <%
            Usuario usuarioLogado = (Usuario) session.getAttribute("usuAutenticado");
            List<Chamado> chamados = (List<Chamado>) session.getAttribute("chamados");
            
            String meses[] = new String[12];
            meses[0] = "Janeiro";
            meses[1] = "Fevereiro";
            meses[2] = "Março";
            meses[3] = "Abril";
            meses[4] = "Maio";
            meses[5] = "Junho";
            meses[6] = "Julho";
            meses[7] = "Agosto";
            meses[8] = "Setembro";
            meses[9] = "Outubro";
            meses[10] = "Novembro";
            meses[11] = "Dezembro";

            String strMesInicio = request.getParameter("mesInicio");
            String strMesFinal = request.getParameter("mesFinal");
            String strAno = request.getParameter("ano");

            int mesInicio = 0;
            int mesFinal = 11;
            int ano = 2018;

            if (strMesInicio != null) {
                if (strMesInicio.length() > 0) {
                    mesInicio = Integer.valueOf(strMesInicio);
                }
                if (strMesFinal.length() > 0) {
                    mesFinal = Integer.valueOf(strMesFinal);
                }
                if (strAno.length() > 0) {
                    ano = Integer.valueOf(strAno);
                }
            }
            List<Linha> linhas = Grafico.ChamadosPorStatus(chamados, ano);
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
                           
        <div class="container">

            <script src="code/highcharts.js"></script>
            <script src="code/modules/series-label.js"></script>
            <script src="code/modules/exporting.js"></script>
            <script src="code/modules/export-data.js"></script>  


            </br>
           
            <form name="formFIltro" action="home.jsp" >
                </br></br><h4>Filtros:</h4>
                
                <div class="row">
                    
                    <div class="col-md-2 mb-3" >
                         Mês Início : <select name="mesInicio" class="form-control">
                    <option value="0">Janeiro</option>
                    <option value="1">Fevereiro</option>
                    <option value="2">Março</option>
                    <option value="3">Abril</option>
                    <option value="4">Maio</option>
                    <option value="5">Junho</option>
                    <option value="6">Julho</option>
                    <option value="7">agosto</option>
                    <option value="8">Setembro</option>
                    <option value="9">Outubro</option>
                    <option value="10">Novembro</option>
                    <option value="11">Dezembro</option>
                </select>
                    </div>
                    <div class="col-md-2 mb-3" >
                        Mês Final : <select name="mesFinal" class="form-control">
                    <option value="">Dezembro</option>
                    <option value="0">Janeiro</option>
                    <option value="1">Fevereiro</option>
                    <option value="2">Março</option>
                    <option value="3">Abril</option>
                    <option value="4">Maio</option>
                    <option value="5">Junho</option>
                    <option value="6">Julho</option>
                    <option value="7">agosto</option>
                    <option value="8">Setembro</option>
                    <option value="9">Outubro</option>
                    <option value="10">Novembro</option>
                    <option value="11">Dezembro</option>
                </select>
                    </div>
                    <div class="col-md-2 mb-3">
                       Ano: <select name="ano" class="form-control">
                           <%
                               Calendar c = Calendar.getInstance();
                               int a  = c.get(Calendar.YEAR);
                               for (int i = 0; i < 11; i++){
                           %>
                           <option value="<%=a-i%>"><%=a-i%></option>
                           <%}%>
                </select>
                        </div>
                    <div class="col-md-1 mb-3">
                          Filtrar: <input type="submit" value="Consultar" name="filtro" class="btn btn-primary">
                        </div>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <div class="col-md-4 mb-3" style="position:absolute; right: 30px;">
                          <a href="/podechamar_v1/ChamadoRelStatus">Chamados por Status</a></br>
                          <a href="/podechamar_v1/ChamadoRelTipos">Chamados por Tipos</a>
                        </div>
                </div>
            </form>
            
            </br>
            <div id="container"></div>
            </br>

            <script type="text/javascript">

                Highcharts.chart('container', {

                title: {
                text: 'Chamados por Status no ano de <%=ano%>'
                },
                        subtitle: {
                        text: 'PodeChamar Serviços de Atendimento'
                        },
                        xAxis: {
                        categories: [
                <%
                    for (int i = mesInicio; i < mesFinal + 1; i++) {
                %>
                        '<%=meses[i]%>'
                <%
                    if (i < mesFinal) {
                %>
                        ,
                <%
                        }//if
                    }//for
                %>
                        ]
                        },
                        yAxis: {
                        title: {
                        text: 'Número de Chamados'
                        }
                        },
                        legend: {
                        layout: 'vertical',
                                align: 'right',
                                verticalAlign: 'middle'
                        },
                        plotOptions: {
                        series: {
                        label: {
                        connectorAllowed: false
                        },
                                pointStart: 0
                        }
                        },
                        series: [
                        {
                        name: 'Aberto ',
                                color: '#32CD32',
                                dashStyle: 'ShortDash',
                                data: [

                <%
                    //for para os valores
                    for (int i = mesInicio; i < mesFinal + 1; i++) {
                %>
                <%=linhas.get(0).valores[i]%>
                <%
                    if (i < mesFinal) {
                %>
                                ,
                <%
                        }//if
                    }//fim do for
                %>
                                ]
                        }, {
                        name: 'Pendente',
                                color: '#F0E68C',
                                dashStyle: 'ShortDash',
                                data: [
                <%
                    //for para os valores
                    for (int i = mesInicio; i < mesFinal + 1; i++) {
                %>
                <%=linhas.get(1).valores[i]%>
                <%
                    if (i < mesFinal) {
                %>
                                ,
                <%
                        }//if
                    }//fim do for
                %>
                                ]
                        }, {
                        name: 'Concluído',
                                color: '#00008B',
                                dashStyle: 'ShortDash',
                                data: [
               <%
                    //for para os valores
                    for (int i = mesInicio; i < mesFinal + 1; i++) {
                %>
                <%=linhas.get(2).valores[i]%>
                <%
                    if (i < mesFinal) {
                %>
                                ,
                <%
                        }//if
                    }//fim do for
                %>
                                ]
                        },
                        {
                        name: 'Cancelado',
                                color: '#ADD8E6',
                                dashStyle: 'ShortDash',
                                data: [
               <%
                    //for para os valores
                    for (int i = mesInicio; i < mesFinal + 1; i++) {
                %>
                <%=linhas.get(3).valores[i]%>
                <%
                    if (i < mesFinal) {
                %>
                                ,
                <%
                        }//if
                    }//fim do for
                %>
                                ]
                        },
                        {
                        name: 'Retido',
                                color: '#FF0000',
                                dashStyle: 'ShortDash',
                                data: [
                <%
                    //for para os valores
                    for (int i = mesInicio; i < mesFinal + 1; i++) {
                %>
                <%=linhas.get(4).valores[i]%>
                <%
                    if (i < mesFinal) {
                %>
                                ,
                <%
                        }//if
                    }//fim do for
                %>
                                ]
                        }
                        ],
                        responsive: {
                        rules: [{
                        condition: {
                        maxWidth: 900
                        },
                                chartOptions: {
                                legend: {
                                layout: 'horizontal',
                                        align: 'center',
                                        verticalAlign: 'bottom'
                                }
                                }
                        }]
                        }


                });
            </script>
            <%-- 
             rodapé
            --%>  
            <hr>
            <h5>@Pode Chamar 0.1 - 2018</h5>    
        </div>

    </body>
</html>
