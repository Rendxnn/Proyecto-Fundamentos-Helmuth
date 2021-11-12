
/**
 * Write a description of class ColeccionAmistades here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;

public class ColeccionAmistades
{
    ArrayList<Amistad> amistades;
    
    public ColeccionAmistades() {
        amistades = new ArrayList<>();
    }
    
    public boolean agregarAmistad(Amistad amistad) {
        return amistades.add(amistad);
    }
    
    public boolean buscarAmistad(String usuario1, String usuario2) {
        for(Amistad a: amistades) {
            if(a.getUsuario1().equals(usuario1) && a.getUsuario2().equals(usuario2)) {
                return true;
            }
            if(a.getUsuario1().equals(usuario2) && a.getUsuario2().equals(usuario1)) {
                return true;
            }
        }
        return false;
    }
}
