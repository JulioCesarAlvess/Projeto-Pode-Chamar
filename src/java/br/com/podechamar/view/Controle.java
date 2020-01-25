/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podechamar.view;

import br.com.podechamar.controle.*;
import br.com.podechamar.controle.Resultado;
import br.com.podechamar.controle.core.I_Comando;
import br.com.podechamar.dominio.Cliente;
import br.com.podechamar.dominio.core.EntidadeDominio;
import br.com.podechamar.view.core.I_ViewHelper;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Julio Cesar Alves
 */
public class Controle extends HttpServlet {

    private Resultado r;
    private static Map<String, I_ViewHelper> vhs;
    //hasmap com os comandos
    private static Map<String, I_Comando> comandos;

    //construtor da controle 
    public Controle() {
        //monstar a lista de ViewHelpers
        vhs = new HashMap<String, I_ViewHelper>();
        vhs.put("/podechamar_v1/SalvarCliente", new ViewHelperClientes());
        vhs.put("/podechamar_v1/ListarCliente", new ViewListarClientes());
        vhs.put("/podechamar_v1/AlterarCliente", new ViewAlteraClientes());
        vhs.put("/podechamar_v1/SalvarProduto", new ViewSalvaProdutos());
        vhs.put("/podechamar_v1/ListarProduto", new ViewListarProdutos());
        vhs.put("/podechamar_v1/AlterarProduto", new ViewAlteraProdutos());
        vhs.put("/podechamar_v1/AlterarFuncionario", new ViewAlterarFuncionario());
        vhs.put("/podechamar_v1/ListarFuncionario", new ViewListarFuncionario());
        vhs.put("/podechamar_v1/SalvarFuncionario", new ViewSalvarFuncionario());
        vhs.put("/podechamar_v1/Logar", new ViewLogar());
        vhs.put("/podechamar_v1/Deslogar", new ViewDeslogarFuncionario());
        vhs.put("/podechamar_v1/AlterarSenha", new ViewAlterarSenha());
        vhs.put("/podechamar_v1/SalvarTipoChamado", new ViewSalvarTipoChamado());
        vhs.put("/podechamar_v1/ListarTipoChamado", new ViewListarTipoChamado());
        vhs.put("/podechamar_v1/AlterarTipoChamado" , new ViewAlterarTipoChamado());
        vhs.put("/podechamar_v1/SalvarAtividade", new ViewSalvarAtividade());
        vhs.put("/podechamar_v1/AlterarAtividade", new ViewAlterarAtividade());
        vhs.put("/podechamar_v1/ListarAtividade", new ViewListarAtividade());
        vhs.put("/podechamar_v1/SalvarDepartamento", new ViewSalvarDepartamento());
        vhs.put("/podechamar_v1/AlterarDepartamento", new ViewAlterarDepartamento());
        vhs.put("/podechamar_v1/ListarDepartamento", new ViewListarDepartamento());
        vhs.put("/podechamar_v1/SalvarChamado", new ViewSalvarChamado());
        vhs.put("/podechamar_v1/ListarChamado", new ViewListarChamado());
        vhs.put("/podechamar_v1/AlterarChamado", new ViewAlterarChamado());
        vhs.put("/podechamar_v1/VisualizaChamado", new ViewVisualizaChamado());
        vhs.put("/podechamar_v1/AtribuirFuncionario", new ViewChamadoAtribuirFuncionario());
        vhs.put("/podechamar_v1/ChamadoAdicionarProduto", new ViewChamadoAdicionaProdutos());
        vhs.put("/podechamar_v1/ChamadoAdicionarAtividade", new ViewChamadoAdicionarAtividade());
        vhs.put("/podechamar_v1/ConcluirChamado", new ViewConcluirChamado());
        vhs.put("/podechamar_v1/CancelarChamado", new ViewCancelarChamado());
        vhs.put("/podechamar_v1/Feedback", new ViewChamadoFeedback());
        vhs.put("/podechamar_v1/FeedbackFuncionario", new ViewChamadoFeedFun());
        vhs.put("/podechamar_v1/FeedbackCliente", new ViewChamadoFeedCli());
        vhs.put("/podechamar_v1/Justificativa", new ViewChamadoJustificativa());
        vhs.put("/podechamar_v1/Justificar", new ViewChamadoJustificar());
        vhs.put("/podechamar_v1/ChamadoExcluirAtividade", new ViewChamadoExcluirAtividade());
        vhs.put("/podechamar_v1/ChamadoExcluirItem", new ViewChamadoExcluirItem());
        vhs.put("/podechamar_v1/ChamadoRelStatus", new ViewChamadoRelStatus());
        vhs.put("/podechamar_v1/ChamadoRelTipos", new ViewChamadoRelTipos());
        vhs.put("/podechamar_v1/ListarHistorico", new ViewListarHistorico());
        vhs.put("/podechamar_v1/DadosHistorico", new ViewListarHistorico());
        //hasmap com as comandos
        comandos = new HashMap<String, I_Comando>();
        comandos.put("SALVAR", new ComandoSalvar());
        comandos.put("BUSCAR", new ComandoBuscar());
        comandos.put("ALTERAR", new ComandoAlterar());
        comandos.put("EXCLUIR", new ComandoExcluir());
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            EntidadeDominio e;
            //selecionar a view Helper
            String uri = request.getRequestURI();
            I_ViewHelper vh = vhs.get(uri);
            //selecionar o comando
            String operacao = request.getParameter("btnOperacao");
            if(operacao == null)
                operacao = "BUSCAR";
            I_Comando comando = comandos.get(operacao);
            //receber o produto da viewHelper
            e = vh.getEntidade(request, response);
            //executar o comando
            r = comando.executar(e);
            //exibir o resultado
            vh.setView(r, request, response);
        }
}

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
