/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podechamar.controle;

import br.com.podechamar.controle.core.I_Fachada;
import br.com.podechamar.dao.*;
import br.com.podechamar.dao.core.I_DAO;
import br.com.podechamar.dominio.*;
import br.com.podechamar.dominio.core.EntidadeDominio;
import br.com.podechamar.negocio.*;
import br.com.podechamar.negocio.core.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Julio Cesar Alves
 */
public class Fachada implements I_Fachada {

    //variável de resultado
    private Resultado resultado;
    //lista de DAOS
    private Map<String, I_DAO> daos;
    //lista de Strategys
    private Map<String, List<I_Strategy>> rns;

    //construtor da fachada
    public Fachada() {
        resultado = new Resultado();
        //montar a lista de Daos
        daos = new HashMap<String, I_DAO>();
        daos.put(Cliente.class.getName(), new DaoClientes());
        daos.put(Produto.class.getName(), new DaoProduto());
        daos.put(Funcionario.class.getName(), new DaoFuncionarios());
        daos.put(Usuario.class.getName(), new DaoUsuario());
        daos.put(TipoChamado.class.getName(), new DaoTipoChamado());
        daos.put(Atividade.class.getName(), new DaoAtividade());
        daos.put(Departamento.class.getName(), new DaoDepartamento());
        daos.put(Chamado.class.getName(), new DaoChamado());
        daos.put(Historico.class.getName(), new DaoLog());
        //montar a lista das regras de negócio de clientes
        List<I_Strategy> regrasCliente = new ArrayList<I_Strategy>();
        List<I_Strategy> regrasProduto = new ArrayList<I_Strategy>();
        List<I_Strategy> regrasFuncionario = new ArrayList<I_Strategy>();
        List<I_Strategy> regrasAlterarFuncionario = new ArrayList<I_Strategy>();
        List<I_Strategy> regrasUsuario = new ArrayList<I_Strategy>();
        List<I_Strategy> regrasAlterarUsuario = new ArrayList<I_Strategy>();
        List<I_Strategy> regrasTipoChamado = new ArrayList<I_Strategy>();
        List<I_Strategy> regrasATividade = new ArrayList<I_Strategy>();
        List<I_Strategy> regrasDepartamento = new ArrayList<I_Strategy>();
        List<I_Strategy> regrasChamadoListar = new ArrayList<I_Strategy>();
        List<I_Strategy> regrasChamadoExcluir = new ArrayList<I_Strategy>();
        
        //instanciar as regras
        VerificarCNPJ vCNPJ = new VerificarCNPJ();
        VerificarCampos vCampos = new VerificarCampos();
        ClienteVerificaEndereco vEnd = new ClienteVerificaEndereco();
        VerificarContrato vContrato = new VerificarContrato();
        ClienteVerificarExistencia vExistencia = new ClienteVerificarExistencia();

        ProdutoVerificaCampos pVerificaCampos = new ProdutoVerificaCampos();
        ProdutoVerificaEAN pVerificaEan = new ProdutoVerificaEAN();
        ProdutoVerificaQuantidades pVQtde = new ProdutoVerificaQuantidades();
        ProdutoVerificarExistencia pVerE = new ProdutoVerificarExistencia();

        FuncionarioVerificarCampos fVcam = new FuncionarioVerificarCampos();
        FuncionarioVerificaCPF fVcpf = new FuncionarioVerificaCPF();
        FuncionarioVerificarTelefone fVtel = new FuncionarioVerificarTelefone();
        FuncionarioVerificarEmail fVmail = new FuncionarioVerificarEmail();
        FuncionarioVerificarExistencia fVExistencia = new FuncionarioVerificarExistencia();
        FuncionarioVerificarSenha fVSenha = new FuncionarioVerificarSenha();
        FuncionarioCriptografaSenha fCrip = new FuncionarioCriptografaSenha();

        FuncionarioAlteracaoSenha fAltSenha = new FuncionarioAlteracaoSenha();

        TipoChamadoVerificarCampos tcVerCam = new TipoChamadoVerificarCampos();
        TipoChamadoVerificarExistencia tVE = new TipoChamadoVerificarExistencia();

        AtividadeVerificarCampos atiVerCam = new AtividadeVerificarCampos();
        AtividadeVerificarExistencia aVE = new AtividadeVerificarExistencia();

        DepartamentoVerificarCampos depVerCam = new DepartamentoVerificarCampos();
        DepartamentoVerificarExistencia depVE = new DepartamentoVerificarExistencia();
        
        ChamadoVerificarSLA chaVSla = new ChamadoVerificarSLA();
        
        ChamadoMovimentaEstoque chaMovEst = new ChamadoMovimentaEstoque();
        ChamadoVerificarAtividades chaVerAti = new ChamadoVerificarAtividades();

        //adionar as regras na lista
        regrasCliente.add(vCNPJ);
        regrasCliente.add(vCampos);
        regrasCliente.add(vEnd);
        regrasCliente.add(vContrato);
        regrasCliente.add(vExistencia);

        regrasProduto.add(pVerificaCampos);
        regrasProduto.add(pVerificaEan);
        regrasProduto.add(pVQtde);
        regrasProduto.add(pVerE);

        regrasFuncionario.add(fVcam);
        regrasFuncionario.add(fVcpf);
        regrasFuncionario.add(fVtel);
        regrasFuncionario.add(fVmail);
        regrasFuncionario.add(fVExistencia);
        regrasFuncionario.add(fVSenha);
        regrasFuncionario.add(fCrip);

        regrasAlterarUsuario.add(fAltSenha);

        regrasTipoChamado.add(tcVerCam);
        regrasTipoChamado.add(tVE);

        regrasATividade.add(atiVerCam);
        regrasATividade.add(aVE);

        regrasDepartamento.add(depVerCam);
        regrasDepartamento.add(depVE);
        
        regrasChamadoListar.add(chaVSla);
        
        regrasChamadoExcluir.add(chaMovEst);
        regrasChamadoExcluir.add(chaVerAti);

        //montar o hashmap
        rns = new HashMap<String, List<I_Strategy>>();
        rns.put(Cliente.class.getName(), regrasCliente);
        rns.put(Produto.class.getName(), regrasProduto);
        rns.put(Funcionario.class.getName(), regrasFuncionario);
        rns.put(Funcionario.class.getName() + " ALTERAR", regrasAlterarFuncionario);
        rns.put(TipoChamado.class.getName(), regrasTipoChamado);
        rns.put(Atividade.class.getName(), regrasATividade);
        rns.put(Departamento.class.getName(), regrasDepartamento);
        rns.put(Usuario.class.getName() + " ALTERAR", regrasAlterarUsuario);
        rns.put(Chamado.class.getName() + " CONSULTAR", regrasChamadoListar);
        rns.put(Chamado.class.getName() + " EXCLUIR", regrasChamadoExcluir);
    }

    @Override
    public Resultado salvar(EntidadeDominio entidade) {
        String nomeClasse = entidade.getClass().getName();
        //selecionar a Dao
        I_DAO dao = daos.get(nomeClasse);
        //selecionar a lista de regras de negocio
        List<I_Strategy> regras = rns.get(nomeClasse);
        //fazer as verificações executando as regras de negocio
        resultado.setMensagemResultado(percorrerRegras(regras, entidade));
        //se der erro a lista não será nula
        if (resultado.getMensagemResultado().length() > 0) {
            resultado.setListaResultado(null);
        } //se não será salvo com sucesso
        else {
            //salvar no banco de dados
            resultado.setMensagemResultado(dao.salvar(entidade));
        }
        return resultado;
    }//fim do salvar

    @Override
    public Resultado alterar(EntidadeDominio entidade) {
        // String nomeClasse
        //B5GUzzzXPP7Xzz6zWVzzzY8E6zO5IO Antonio123@
        String nomeClasse = entidade.getClass().getName();
        //selecionba as regras de negocio
        List<I_Strategy> regras = rns.get(nomeClasse + " ALTERAR");
        //seleciona a Dao
        I_DAO dao = daos.get(nomeClasse);

        resultado.setMensagemResultado(percorrerRegras(regras, entidade));
        if (resultado.getMensagemResultado().length() > 0) {
            return resultado;
        }
        resultado.setListaResultado(new ArrayList<>());
        resultado.getListaResultado().add(entidade);
        resultado.setMensagemResultado(dao.alterar(entidade));
        //retorna o resultado
        return resultado;
    }//fim do alterar

    @Override
    public Resultado excluir(EntidadeDominio entidade) {
        String nomeClasse = entidade.getClass().getName();
        List<I_Strategy> regras = rns.get(nomeClasse + " EXCLUIR");
        //fazer as verificações executando as regras de negocio
        resultado.setMensagemResultado(percorrerRegras(regras, entidade));
        //ir até o banco de dados
        I_DAO dao = daos.get(nomeClasse);
        resultado.setListaResultado(dao.excluir(entidade));
        return resultado;
    }

    @Override
    public Resultado consultar(EntidadeDominio entidade) {
        String nomeClasse = entidade.getClass().getName();
        I_DAO dao = daos.get(nomeClasse);
        List entidades = dao.consultar(entidade);
        resultado.setListaResultado(entidades);
        //resultado.setMensagemResultado("Produtos Encontrados");
        List<I_Strategy> regras = rns.get(nomeClasse + " CONSULTAR");
        percorrerRegras(regras, entidade);
        return resultado;
    }//fim do buscar

    private String percorrerRegras(List<I_Strategy> regras, EntidadeDominio entidade) {
        if (regras == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (I_Strategy r : regras) {
            String msg = r.executar(entidade);
            if (msg != null) {
                sb.append(msg);
            }//if
        }//for
        return sb.toString();
    }
}
