/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podechamar.view;

import br.com.podechamar.controle.Resultado;
import br.com.podechamar.dominio.Cliente;
import br.com.podechamar.dominio.Contrato;
import br.com.podechamar.dominio.Endereco;
import br.com.podechamar.dominio.core.EntidadeDominio;
import br.com.podechamar.view.core.DadosVisao;
import br.com.podechamar.view.core.ViewHelper;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Julio Cesar Alves
 */
public class ViewAlteraClientes extends ViewHelper {

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {
        Cliente cli = new Cliente();
        Contrato con = new Contrato();
        Endereco end = new Endereco();

        //preencher o objeto
        DadosVisao visao = new DadosVisao(request);
        cli = (Cliente)preencher(visao, cli.getClass());
        //dados do endereco
        String end_id = request.getParameter("end_id");
        String cep = request.getParameter("end_cep");
        String rua = request.getParameter("end_rua");
        String numero = request.getParameter("end_numero");
        String bairro = request.getParameter("end_bairro");
        String cidade = request.getParameter("end_cidade");
        String estado = request.getParameter("end_estado");
        String pais = request.getParameter("end_pais");
        
        end.setEnd_bairro(bairro);
        end.setEnd_cep(cep);
        end.setEnd_cidade(cidade);
        end.setEnd_estado(estado);
        try{
        end.setEnd_cli_id(Integer.valueOf(request.getParameter("id")));
        end.setId(Integer.valueOf(end_id));
        }catch(Exception ex){
            end.setEnd_cli_id(0);   
            end.setId(0);
        }
        end.setEnd_numero(numero);
        end.setEnd_pais(pais);
        end.setEnd_rua(rua);
        //dados co contrato
        String con_id = request.getParameter("con_id");
        String con_datainicio = request.getParameter("con_datainicio");
        String con_diavencimento = request.getParameter("con_diavencimento");
        String con_valormensalidade = request.getParameter("con_valormensalidade");
        String con_tempo = request.getParameter("con_tempo");
        
        try{
            con.setId(Integer.valueOf(con_id));
        con.setCon_cli_id(0); 
        }catch(Exception ex){
            con.setId(0);
        con.setCon_cli_id(0); 
        }
        try{
        con.setId(Integer.valueOf(con_id));
        con.setCon_cli_id(Integer.valueOf(request.getParameter("id")));    
        con.setCon_datainicio(con_datainicio);
        con.setCon_diavencimento(Integer.valueOf(con_diavencimento));
        con.setCon_valormensalidade(Double.valueOf(con_valormensalidade));
        con.setCon_tempo(Integer.valueOf(con_tempo));
        }catch(Exception ex){
        con.setCon_datainicio(null);
        con.setCon_diavencimento(0);
        con.setCon_valormensalidade(0);
        con.setCon_tempo(0);
        }
        //preencher o cliente
        cli.setCli_contrato(con);
        cli.setCli_endereco(end);
        //não esquecer o ID
        String id = request.getParameter("id");
        cli.setId(Integer.valueOf(id));
        
        return cli;
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("cliente", resultado.getListaResultado().get(0));
        request.setAttribute("mensagem", resultado.getMensagemResultado());
        request.getRequestDispatcher("/cliente_atualizar.jsp").forward(request, response);
    }
    
}
