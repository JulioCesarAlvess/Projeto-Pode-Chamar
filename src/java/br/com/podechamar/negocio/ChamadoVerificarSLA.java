/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podechamar.negocio;

import br.com.podechamar.dao.DaoChamado;
import br.com.podechamar.dao.core.I_DAO;
import br.com.podechamar.dominio.*;
import br.com.podechamar.dominio.core.EntidadeDominio;
import br.com.podechamar.negocio.core.I_Strategy;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author Julio Cesar Alves
 */
public class ChamadoVerificarSLA implements I_Strategy {

    @Override
    public String executar(EntidadeDominio entidade) {
        Chamado cha = (Chamado) entidade;
        I_DAO dao = new DaoChamado();
        cha.setId(0);
        cha.setBusca(null);
        List<EntidadeDominio> lista = dao.consultar(cha);

        for (EntidadeDominio e : lista) {
            Chamado c = new Chamado();
            c = (Chamado) e;
            if (c.getCha_status().equals("Pendente")) {
                if (reter(c.getCha_databertura(), c.getCha_sla())) {
                    c.setCha_status("Retido");
                    return dao.alterar(c);
                }
                
            }
        }
        return null;
    }

    private boolean reter(String data_abertura, double sla) {
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date data = formato.parse(data_abertura);
            //somar a SLA
            GregorianCalendar gc = new GregorianCalendar();
            gc.setTime(data);
            int horas = (int) sla;
            int minutos = (int) ((sla - horas) * 60);
            gc.add(Calendar.HOUR, horas);
            gc.add(Calendar.MINUTE, minutos);
            //voltar para o formato data
            String string = formato.format(gc.getTime());
            data = formato.parse(string);
            //comparar com a data atual
            Date d = new Date();
            if (d.before(data)) {
                return false;
            }
            if (d.after(data)) {
                return true;
            }
        } catch (Exception ex) {
            return false;
        }
        return false;
    }

}
