package src.dao;

import src.model.Conta;
import src.model.Transacao;
import src.model.Usuario;
import src.service.UsuarioService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TransacaoDAO {

    private final Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public TransacaoDAO(Connection conn) {
        this.conn = conn;
    }

    public void registrar(Transacao transacao, int idConta) throws Exception{
        ps = conn.prepareStatement("INSERT INTO transacoes (tipo, valor, data_transacao, descricao) VALUES (?, ?, ?, ?)");
        ps.setString(1, transacao.getTipo());
        ps.setDouble(2, transacao.getValor());
        ps.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
        ps.setString(4, transacao.getDescricao());

        ps.executeUpdate();
    }

    public void atualizar(Transacao transacao) throws Exception{
        ps = conn.prepareStatement("UPDATE transacoes SET tipo = ?, valor = ?, data_transacao = ?, descricao = ? WHERE id = ?");
        ps.setString(1, transacao.getTipo());
        ps.setDouble(2, transacao.getValor());
        ps.setTimestamp(3, Timestamp.valueOf(transacao.getDataTransacao()));
        ps.setString(4, transacao.getDescricao());
        ps.setInt(5, transacao.getId());

        ps.executeUpdate();
    }
    // ============================= PAREI AQUIIIIIII =========================
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
