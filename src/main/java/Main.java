import src.dao.ConnectionFactory;
import src.dao.UsuarioDAO;
import src.model.Usuario;

import java.sql.Connection;

public class Main {

    public static void main(String[] args) throws Exception{

        Connection conexao = ConnectionFactory.getConnection();
        UsuarioDAO usuarioDAO = new UsuarioDAO(conexao);
        Usuario usuario = new Usuario(null, "Felipe", "felipe@gmail.com", "123", null);

        usuarioDAO.criar(usuario);
    }
}
