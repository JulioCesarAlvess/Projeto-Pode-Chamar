package br.com.podechamar.view;

import br.com.podechamar.controle.Resultado;
import br.com.podechamar.dao.DaoChamado;
import br.com.podechamar.dao.core.I_DAO;
import br.com.podechamar.dominio.*;
import br.com.podechamar.dominio.core.EntidadeDominio;
import br.com.podechamar.view.core.DadosVisao;
import br.com.podechamar.view.core.ViewHelper;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Julio Cesar Alves id serial NOT NULL, cha_databertura character
 * varying(255), cha_datafechamento character varying(255), cha_feedback_cli
 * character varying(255), cha_feedback_fun character varying(255), cha_nota_fun
 * integer, cha_nota_cli integer, cha_cli_id integer, cha_fun_id integer,
 * cha_severidade character varying(255), cha_dep_id integer, cha_tipo_id
 * integer, cha_solicitante character varying(255), cha_sla numeric(8,2),
 * cha_status character varying(255), cha_fun character varying(255), cha_cli
 * character varying(255), cha_dep character varying(255), cha_tipo character
 * varying(255), cha_descricao character varying(255),
 */
public class ViewSalvarChamado extends ViewHelper {

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {
        //variaveis
        Chamado cha = new Chamado();
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        List<TipoChamado> tipos = (List<TipoChamado>) httpRequest.getSession().getAttribute("tiposchamado");
        List<Departamento> departamentos = (List<Departamento>) httpRequest.getSession().getAttribute("departamentos");
        DadosVisao visao = new DadosVisao(request);
        HttpSession sessao = request.getSession();

        cha = (Chamado) preencher(visao, cha.getClass());
        cha.setCha_datafechamento("Nao concluido");
        cha.setCha_feedback_cli("Sem feedback");
        cha.setCha_feedback_fun("Sem feedback");
        cha.setCha_nota_fun(0);
        cha.setCha_nota_cli(0);
        cha.setCha_fun_id(36);
        
        String dep_id = request.getParameter("cha_dep_id");

        cha.setCha_status("Aberto");
        cha.setCha_fun("Nao Atribuido");
          for (TipoChamado t : tipos) {
            if (t.getId() == cha.getCha_tipo_id()) {
                if (cha.getCha_severidade().equals("Normal")) {
                    cha.setCha_sla(t.getTch_normal());
                }
                if (cha.getCha_severidade().equals("Urgente")) {
                    cha.setCha_sla(t.getTch_urgente());
                }
                if (cha.getCha_severidade().equals("Critico")) {
                    cha.setCha_sla(t.getTch_critico());
                }
                cha.setCha_tipo(t.getTch_nome());
            }
        }
        for (Departamento d : departamentos) {
            if (d.getId() == cha.getCha_dep_id()) {
                cha.setCha_dep(d.getDep_nome());
            }
        }
        cha.setCha_justificativa("Sem Justificativa");
        //inserir chamado na sessão
        sessao.setAttribute("chamado", cha);
        return cha;
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        resultado.setMensagemResultado(resultado.getMensagemResultado().replace("#", "</br>"));
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession sessao = request.getSession();
        Chamado cha = (Chamado) httpRequest.getSession().getAttribute("chamado");
        DaoChamado dao = new DaoChamado();
        cha.setId(dao.idUltimoChamado());
        sessao.setAttribute("chamado", cha);
        request.getRequestDispatcher("/chamadosProdutoCliente.jsp").forward(request, response);
    }

}
