
/**
 * En esta clase se maneja la colección de los usuarios que se han
 * inscrito en la aplicación.
 * 
 * @author Nombre del estudiante
 * @version Versión 0
 */
import java.util.ArrayList;

public class ColeccionUsuarios
{
    /**
     * ArrayList donde se almacenan las referencias a los usuarios
     */
    private ArrayList<Usuario> usuarios;
    
    /**
     * Constructor
     * Se asigna memoria al nuevo ArrayList
     */
    public ColeccionUsuarios() {
        usuarios = new ArrayList<>();
    }

    /**
     * Se agrega un usuario. Se presume que ya se ha chequeado y no existe
     * @raram usuario Referencia al nuevo usuario que se trata de agregar
     * @return true si se pudo agregar el usuario, false de lo contrario
     */
    public boolean agregarUsuario(Usuario usuario) {
        return usuarios.add(usuario);
    }
    
    /**
     * Se busca si el usuario ya existe en la colección o no.
     * @param usuarioBuscado Usuario que se trata de agregar
     * @return Si el usuario existe, se returna la referencia, de lo contrario
     * se retorna null
     */
    public Usuario buscarUsuario(String usuarioBuscado) {
        for(Usuario u: usuarios) {
            if(u.getUsuario().equals(usuarioBuscado)) {
                return u;   
            }
        }
        return null;
    }
    
    /**
     * Buscar si el usuario y clave que digita el usuario son válidos
     * @param usuario usuario que ingresa el usuario
     * @param clave clave que ingresa el usuario
     * @return true si el usuario y la clave son válidos, false de lo contrario
     */
    public Usuario buscarUsuarioClave(String usuario, String clave) {
        for(Usuario u: usuarios) {
            if(u.getUsuario().equals(usuario) && u.getClave().equals(clave)) {
                return u;
            }
        }
        return null;
    }
}
