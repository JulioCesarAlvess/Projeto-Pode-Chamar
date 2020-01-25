/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podechamar.view;

import br.com.podechamar.dominio.Funcionario;
import br.com.podechamar.controle.Resultado;
import br.com.podechamar.dao.*;
import br.com.podechamar.dao.core.I_DAO;
import br.com.podechamar.dominio.*;
import br.com.podechamar.dominio.core.EntidadeDominio;
import br.com.podechamar.util.Criptografa;
import br.com.podechamar.view.core.ViewHelper;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author leofa
 */
public class ViewLogar extends ViewHelper {

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {

        Usuario usu = new Usuario();
        String login = request.getParameter("usu_login");
        String senha = request.getParameter("usu_senha");

        //preencher o objeto
        usu.setUsu_login(login);
        if (login != null) {
            if (senha.length() > 1) {
                usu.setUsu_senha(Criptografa.criaHash(senha));
            } else {
                usu.setUsu_senha(senha);
            }
        }
        //dados do endereco
        return usu;
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        if (!resultado.getListaResultado().isEmpty()) {
            //funcionarios
            I_DAO dao = new DaoFuncionarios();
            Funcionario f = new Funcionario();
            HttpSession sessao = request.getSession();
            //usuario
            sessao.setAttribute("usuAutenticado", resultado.getListaResultado().get(0));
            sessao.setAttribute("funcionarios", dao.consultar(f));
            //departamentos
            dao = new DaoDepartamento();
            Departamento d = new Departamento();
            sessao.setAttribute("departamentos", dao.consultar(d));
            //tipos de chamado
            TipoChamado t = new TipoChamado();
            dao = new DaoTipoChamado();
            sessao.setAttribute("tiposchamado", dao.consultar(t));
            //produtos
            Produto p = new Produto();
            dao = new DaoProduto();
            sessao.setAttribute("produtos", dao.consultar(p));
            //atividades
            Atividade a = new Atividade();
            dao = new DaoAtividade();
            sessao.setAttribute("atividades", dao.consultar(a));
            //clientes
            Cliente c = new Cliente();
            dao = new DaoClientes();
            sessao.setAttribute("clientes", dao.consultar(c));
            //mandar para a tela de análise
            request.getRequestDispatcher("/ChamadoRelStatus").forward(request, response);
        } else {
            HttpSession sessao = request.getSession();
            sessao.invalidate();
            request.setAttribute("mensagem", "Login ou senha invalidos !");
            //alterado para não dar erro
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
}
