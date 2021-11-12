
/**
 * Write a description of class Usuario here.
 * 
 * @author Nombre del estudiante 
 * @version versión 0
 */
public class Usuario
{
    private String usuario;
    private String clave;
    private String nombreCompleto;
    
    public Usuario(String usuario, String clave, String nombreCompleto) {
        this.usuario = usuario;
        this.clave = clave;
        this.nombreCompleto = nombreCompleto;
    }
    
    public String getUsuario() {
        return usuario;
    }
    
    public String getClave() {
        return clave;
    }
    
    public String getNombreCompleto() {
        return nombreCompleto;
    }
}
