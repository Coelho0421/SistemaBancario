package src.dao;

import src.model.Conta;
import src.model.Usuario;
import src.service.UsuarioService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ContaDAO {

    private final Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    private UsuarioService service;

    public ContaDAO(Connection conn) {
        this.conn = conn;
    }

    public void criar(Conta conta, int id) throws Exception{
        ps = conn.prepareStatement("INSERT INTO contas (numero_conta, tipo_conta, saldo, limite_credito, usuario_id) VALUES (?, ?, ?, ?, ?)");
        ps.setString(1, conta.getNumeroConta());
        ps.setString(2, conta.getTipoConta());
        ps.setDouble(3, conta.getSaldo());
        ps.setDouble(4, conta.getLimiteCredito());
        ps.setInt(4, id);

        ps.executeUpdate();
    }

    public void atualizar(Conta conta) throws Exception{
        ps = conn.prepareStatement("UPDATE contas SET saldo = ?, limite_credito = ? WHERE id = ?");
        ps.setDouble(1, conta.getSaldo());
        ps.setDouble(2, conta.getLimiteCredito());
        ps.setInt(3, conta.getId());

        ps.executeUpdate();
    }

    public void deletar(int id) throws Exception{
        ps = conn.prepareStatement("DELETE FROM contas WHERE id = ?");
        ps.setInt(1, id);

        ps.executeUpdate();
    }
    
    public Conta buscarPorId(int id) throws Exception{
        ps = conn.prepareStatement("SELECT * FROM contas WHERE id = ?");
        ps.setInt(1, id);
        rs = ps.executeQuery();

        while (rs.next()) {
            Usuario usuario = service.buscarUsarioPorId(rs.getInt("usuario_id"));
            return new Conta(rs.getInt("id"), rs.getString("numero_conta"),
                    rs.getString("tipo_conta"),
                    rs.getDouble("saldo"),
                    rs.getDouble("limite_credito"),
                    usuario);
        }

        return null;
    }

    public List<Conta> buscarPorUsuario(int idUsuario) throws Exception{
        ps = conn.prepareStatement("SELECT * FROM usuarios WHERE usuario_id = ?");
        ps.setInt(1, idUsuario);
        rs = ps.executeQuery();
        List<Conta> contas = new ArrayList<>();

        Usuario usuario = service.buscarUsarioPorId(idUsuario);

        while(rs.next()) {
            contas.add(new Conta(rs.getInt("id"), rs.getString("numero_conta"),
                    rs.getString("tipo_conta"),
                    rs.getDouble("saldo"),
                    rs.getDouble("limite_credito"),
                    usuario));
        }

        return contas;
    }

    public List<Conta> listarTodos() throws Exception{
        ps = conn.prepareStatement("SELECT * FROM contas");
        rs = ps.executeQuery();
        List<Conta> contas = new ArrayList<>();

        while(rs.next()) {
            Usuario usuario = service.buscarUsarioPorId(rs.getInt("usuario_id"));
            contas.add(new Conta(rs.getInt("id"), rs.getString("numero_conta"),
                    rs.getString("tipo_conta"),
                    rs.getDouble("saldo"),
                    rs.getDouble("limite_credito"),
                    usuario));
        }

        return contas;
    }
}
