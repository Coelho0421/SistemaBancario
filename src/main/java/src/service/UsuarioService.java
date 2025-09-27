/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.service;

import src.dao.UsuarioDAO;
import src.model.Usuario;
import src.util.Criptografia;

/**
 *
 * @author felip
 */
public class UsuarioService {

    private UsuarioDAO usuarioDAO;

    public UsuarioService(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public void cadastrarUsuario(Usuario usuario) throws Exception {

        Criptografia criptografia = new Criptografia();
        String hashSenha = criptografia.gerarHash(usuario.getSenha());
        usuario.setSenha(hashSenha);

        usuarioDAO.criar(usuario);
    }
}
