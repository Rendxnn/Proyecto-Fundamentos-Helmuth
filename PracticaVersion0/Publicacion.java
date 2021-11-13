

/**
 * En esta clase se manejan los datos referentes a una publicación individual.
 * 
 * @author Nombre del estudiante 
 * @version versión 0
 */
import java.util.Date;

public class Publicacion
{
    public static int secuencialPublicaciones = 0;
    
    private int numeroPublicacion;
    private String usuario;
    private Date fechaHora;
    private String texto;
    
    /**
     * Constructor de una nueva publicación
     * @param usuario usuario que realiza la publicación
     * @param texto texto de la publicación
     */
    public Publicacion(String usuario, String texto) {
        this.numeroPublicacion = secuencialPublicaciones;
        Publicacion.secuencialPublicaciones++;
        this.usuario = usuario;
        this.fechaHora = new Date();
        this.texto = texto;
    }
    
    /**
     * Se retorna el número de la publicación
     */
    public int getNumeroPublicacion() {
        return numeroPublicacion;
    }
    
    /**
     * Se retorna el "usuario" del usuario que realiza la publicación
     */
    public String getUsuario() {
        return usuario;
    }
    
    /**
     * Se retorna la fecha (y hora) de la publicación
     */
    public Date getFechaHora() {
        return fechaHora;
    }
    
    /**
     * Se retorna el texto de la publicación
     */
    public String getTexto() {
        return  this.texto;
    }
    
    
}
