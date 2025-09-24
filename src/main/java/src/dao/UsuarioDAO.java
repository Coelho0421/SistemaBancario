package src.dao;

import src.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class UsuarioDAO {

    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public UsuarioDAO(Connection conn) {
        this.conn = conn;
    }

    public void criar(Usuario usuario) throws Exception{
        ps = conn.prepareStatement("INSERT INTO usuarios (nome, email, senha, datacriacao) VALUES (?, ?, ?, ?)");
        ps.setString(1, usuario.getNome());
        ps.setString(2, usuario.getEmail());
        ps.setString(3, usuario.getSenha());
        ps.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));

        ps.executeUpdate();
    }
}
