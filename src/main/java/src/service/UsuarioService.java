/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.service;

import src.dao.UsuarioDAO;
import src.model.Usuario;
import src.util.Criptografia;

import java.util.List;

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

    public void atualizarUsuario(Usuario usuario) throws Exception {

        usuarioDAO.atualizar(usuario);

    }

    public void excluirUsuario(int id) throws Exception {

        usuarioDAO.deletar(id);

    }

    public Usuario buscarUsarioPorId(int id) throws Exception {

        return usuarioDAO.buscarPorId(id);

    }

    public List <Usuario> listarUsuarios() throws Exception {

        return usuarioDAO.listarTodos();

    }

}
