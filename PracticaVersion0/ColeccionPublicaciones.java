
/**
 * Write a description of class ColeccionPublicaciones here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;

public class ColeccionPublicaciones
{
    ArrayList<Publicacion> publicaciones;
    
    public ColeccionPublicaciones() {
        publicaciones = new ArrayList<>();
    }
    
    public boolean agregarPublicacion(Publicacion p) {
        return publicaciones.add(p);
    }
    
    public ArrayList<Publicacion> getPublicacionesDeUnUsuario(String usuario) {
        ArrayList<Publicacion> seleccionadas = new ArrayList<>();
        for(Publicacion p: publicaciones) {
            if(p.getUsuario().equals(usuario)) {
                seleccionadas.add(p);
            }
        }
        return seleccionadas;
    }
}
