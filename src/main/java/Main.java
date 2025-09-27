import src.dao.ConnectionFactory;
import src.dao.UsuarioDAO;
import src.model.Usuario;
import src.service.UsuarioService;

import java.sql.Connection;

public class Main {

    public static void main(String[] args) throws Exception{

        Connection conn = ConnectionFactory.getConnection();
        UsuarioDAO usuarioDAO = new UsuarioDAO(conn);
        UsuarioService usuarioService = new UsuarioService(usuarioDAO);
        Usuario usuario = new Usuario(null, "Nilson", "Nilson@gmail.com", "234", null);

        System.out.println(usuarioDAO.buscarPorId(1));

    }
}
