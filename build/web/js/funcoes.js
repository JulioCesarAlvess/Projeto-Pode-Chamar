/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function inserirLinhaTabelaCartao() {

                // Captura a referência da tabela com id “minhaTabela”
                var table = document.getElementById("minhaTabelaCartao");
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
                    if (cont  === 0) {
                        newCell.innerHTML = '<input type="text" name="cardescricao" value="" size="12" placeholder="Apelido"/>';
                    }
                    if (cont  === 1) {
                        newCell.innerHTML = '<input type="text" name="carnumero" value="" placeholder="Número" size="12"/>';
                    }
                    if (cont  === 2) {
                        newCell.innerHTML = '<input type="text" name="carnometitular" value="" size="20" placeholder="Nome impresso no cartao"/>';
                    }
                    if (cont  === 3) {
                        newCell.innerHTML = '<select name="carbandeira"><option value="">Selecione...</option><option value="visa"> Visa</option><option value="mastercard">Mastercard</option><option value="alelo">Alelo</option><option value="nubank">NuBank</option></select>';
                    }
                    if (cont  === 4) {
                        newCell.innerHTML = '<input type="text" name="carcodigo" value="" size="5" placeholder="Cod. Seguranca"/>';
                    }
                    if (cont  === 5) {
                        newCell.innerHTML = '<input type="radio" name="cartipo" value="preferencial" />';
                    }
                   
                    cont++;
                }

            }
            
            function inserirLinhaTabelaEnd() {

                // Captura a referência da tabela com id “minhaTabela”
                var table = document.getElementById("minhaTabelaEnd");
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
                    if (cont  === 0) {
                        newCell.innerHTML = '<input type="text" name="enddescricao" value="" size="6" placeholder="Apelido"/>';
                    }
                    if (cont  === 1) {
                        newCell.innerHTML = '<select name="endtiporesidencia"><option value="">Selecione...</option><option value="casa">Casa</option><option value="apartamento">Apartamento</option><option value="condominio">Condomínio</option></select>';

                    }
                    if (cont  === 2) {
                        newCell.innerHTML = '<select name="endtipologradouro"><option value="">Selecione...</option><option value="rua">Rua</option><option value="avenida">Avenida</option><option value="praca">Praça</option><option value="travessa">Travessa</option><option value="viela">Viela</option></select>';
                    }
                    if (cont  === 3) {
                        newCell.innerHTML = '<input type="text" name="endlogradouro" value="" placeholder="Logradouro" size="9"/>';
                    }
                    if (cont  === 4) {
                        newCell.innerHTML = '<input type="text" name="endnumero" value="" placeholder="Numero" size="5"/>';
                    }
                    if (cont  === 5) {
                        newCell.innerHTML = '<input type="text" name="endbairro" value="" placeholder="Bairro" size="6"/>';
                    }
                    if (cont  === 6) {
                        newCell.innerHTML = '<input type="text" name="endcep" value="" placeholder="CEP" size="6"/>';
                    }
                    if (cont  === 7) {
                        newCell.innerHTML = '<input type="text" name="endcidade" value="" placeholder="Cidade" size="6"/>';
                    }
                    if (cont  === 8) {
                        newCell.innerHTML = '<input type="text" name="enduf" value="" placeholder="UF" size="1"/>';
                    }
                    if (cont  === 9) {
                        newCell.innerHTML = '<input type="text" name="endpais" value="" placeholder="País" size="9"/>';
                    }
                    if (cont  === 10) {
                        newCell.innerHTML = '<input type="checkbox" name="endtipo" value="cobranca" />';
                    }
                    if (cont  === 11) {
                        newCell.innerHTML = '<input type="checkbox" name="endtipo" value="entrega" />';
                    }
                   
                    cont++;
                }

            }
            	//Quando a página for carregada:
	
	$(document).ready(function(){
	
});



	//codigo do gustavo para abrir a modal
	//modal-sm  pequeno (dentro da div class dialog)
	//modal-lg grande
	$('#btn1').click(function(){
	$('#modal1').modal('show');
});
	$('#btn2').click(function(){
	$('#modal2').modal('show');
});
	$('#btn3').click(function(){
	$('#modal3').modal('show');
});
	$('#btn4').click(function(){
	$('#modal4').modal('show');
});
	//modelo para enviar um formulário usando jQuery

	$('#BotaoEnviar').click(function(){
	$('#IdForm').submit();
});


