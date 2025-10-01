/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.service;

import src.dao.UsuarioDAO;
import src.model.Conta;

/**
 *
 * @author felip
 */
public class ContaService {

    private ContaDAO contaDAO;

    public ContaService(UsuarioDAO usuarioDAO){
        this.contaDAO = usuarioDAO;
    }

    public void criarConta(Conta conta){



    }

}
