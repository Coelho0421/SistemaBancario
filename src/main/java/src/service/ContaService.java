/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.service;

import src.dao.ContaDAO;
import src.model.Conta;

import java.util.List;

/**
 *
 * @author felip
 */
public class ContaService {

    private ContaDAO contaDAO;

    public ContaService(ContaDAO contaDAO){
        this.contaDAO = contaDAO;
    }

    public void criarConta(Conta conta, int usuarioid)throws Exception{

        contaDAO.criar(conta, usuarioid);

    }

    public void atualizarConta(Conta conta) throws Exception {

        contaDAO.atualizar(conta);

    }

    public void excluirConta(int id) throws Exception {

        contaDAO.deletar(id);

    }

    public Conta buscarContaPorId(int id) throws Exception {

        return contaDAO.buscarPorId(id);

    }

    public List <Conta> buscarContasPorUsuario(int usuarioId) throws Exception {

        return contaDAO.listarTodos();

    }

}
