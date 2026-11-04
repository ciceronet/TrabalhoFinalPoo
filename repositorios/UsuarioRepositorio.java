package repositorios;
import java.util.List;
import java.util.ArrayList;
import modelo.Usuario;
import exceptions.UsuarioDuplicadoException;
public class UsuarioRepositorio {
    private final List<Usuario> usuarios = new ArrayList<>();
    public void adicionarUsuario (Usuario usuario) throws UsuarioDuplicadoException {
        if(buscarEmail(usuario.getEmail()) != null) {
            throw new UsuarioDuplicadoException("Email:" + usuario.getEmail() + " já foi cadastrado no sistema");
        }
        usuarios.add(usuario);
    }
    public Usuario buscarEmail(String email) {
        for (Usuario u : usuarios) {
            if(u.getEmail().equalsIgnoreCase(email)) {
                return u;
            }
        }
        return null;
    }
    public void listarUsuarios() {
        for ( Usuario u : usuarios) {
            System.out.println("Nome: " + u.getNome() + " Email: " + u.getEmail());
        }
    }
    public void removerUsuario(Usuario usuario) {
        usuarios.remove(usuario);
    }
}
