/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podechamar.negocio;

import br.com.podechamar.dao.*;
import br.com.podechamar.dominio.Chamado;
import br.com.podechamar.dominio.core.EntidadeDominio;
import br.com.podechamar.negocio.core.I_Strategy;

/**
 *
 * @author Julio Cesar Alves
 */
public class ChamadoVerificarAtividades implements I_Strategy{

    @Override
    public String executar(EntidadeDominio entidade) {
        Chamado cha = (Chamado) entidade;
        DaoChamado dao = new DaoChamado();
       if(cha.getCha_status()!= null){
           if(cha.getCha_status().equals("Concluido")){
               Chamado c = (Chamado) dao.consultar(cha).get(0);
               if(c.getAtividades().size() == 0)
                   return "Chamado nao pode ser concluido sem Atividades!#";
           }
       }
        return "";
    } 
}
