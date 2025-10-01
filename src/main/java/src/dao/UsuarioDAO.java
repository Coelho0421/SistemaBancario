package src.dao;

import src.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    private final Connection conn;
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

    public void atualizar(Usuario usuario) throws Exception{
        ps = conn.prepareStatement("UPDATE usuarios SET nome = ?, email = ?, senha = ? WHERE id = ?");
        ps.setString(1, usuario.getNome());
        ps.setString(2, usuario.getSenha());
        ps.setString(3, usuario.getSenha());
        ps.setInt(4, usuario.getId());

        ps.executeUpdate();
    }

    public void deletar(int id) throws Exception{
        ps = conn.prepareStatement("DELETE FROM usuario WHERE id = ?");
        ps.setInt(1, id);

        ps.executeUpdate();
    }
    
    public Usuario buscarPorId(int id) throws Exception{
        ps = conn.prepareStatement("SELECT * FROM usuarios WHERE id = ?");
        ps.setInt(1, id);
        rs = ps.executeQuery();

        while (rs.next()) {
            return new Usuario(rs.getInt("id"), rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("senha"),
                    rs.getTimestamp("datacriacao").toLocalDateTime());
        }

        return null;
    }

    public Usuario buscarPorEmail(String email) throws Exception{
        ps = conn.prepareStatement("SELECT * FROM usuarios WHERE email = ?");
        ps.setString(1, email);
        rs = ps.executeQuery();

        while(rs.next()) {
            return new Usuario(rs.getInt("id"), rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("senha"),
                    rs.getTimestamp("datacriacao").toLocalDateTime());
        }

        return null;
    }

    public List<Usuario> listarTodos() throws Exception{
        ps = conn.prepareStatement("SELECT * FROM usuarios");
        rs = ps.executeQuery();
        List<Usuario> usuarioList = new ArrayList<>();

        while(rs.next()) {
            usuarioList.add(new Usuario(rs.getInt("id"), rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("senha"),
                    rs.getTimestamp("datacriacao").toLocalDateTime()));
        }

        return usuarioList;
    }
}
