
/**
 * Clase principal del programa. Desde aquí se le pregunta al usuario lo que
 * quiere hacer.
 * 
 * @author Nombre del estudiante 
 * @version versión 0
 */
import java.util.Scanner;
import java.util.ArrayList;

public class Principal
{
    static ColeccionUsuarios coleccionUsuarios;
    static ColeccionPublicaciones coleccionPublicaciones;
    static ColeccionAmistades coleccionAmistades;
    static Usuario usuarioActivo;

    static Scanner in = new Scanner(System.in);

    public static void inicializarColecciones() {
        coleccionUsuarios = new ColeccionUsuarios();
        coleccionPublicaciones = new ColeccionPublicaciones();
        coleccionAmistades = new ColeccionAmistades();
    }

    public static void menuPrincipal() {
        int opcion;
        do {
            in = new Scanner(System.in);
            System.out.println("========================");
            System.out.println("1. Crear usuario");
            System.out.println("2. Ingresar al sistema");
            System.out.println("9. Salir del sistema");
            System.out.println("Por favor digite su opción");
            opcion = in.nextInt();
            switch (opcion) {
                case 1:
                    menuCrearUsuario();
                    break;
                case 2:
                    menuIngresar();
                    break;
            }
        } while (opcion != 9);
    }

    public static void menuCrearUsuario() {
        boolean exito = false;
        String usuario;
        String clave;
        String nombreCompleto;
        do {
            in = new Scanner(System.in);
            System.out.println("========================");
            System.out.println("Favor ingresar el nuevo usuario: (o fin para terminar)");
            usuario = in.nextLine();
            if (usuario.equals("fin")) return;
            if(coleccionUsuarios.buscarUsuario(usuario) != null) {
                System.out.println("Ese usuario ya existe");
            } else {
                exito = true;
            }
        } while (!exito);
        System.out.println("Favor ingresar la clave: ");
        clave = in.nextLine();
        System.out.println("Favor ingresar el nombre completo: ");
        nombreCompleto = in.nextLine();
        Usuario nuevoUsuario = new Usuario(usuario, clave, nombreCompleto);
        coleccionUsuarios.agregarUsuario(nuevoUsuario);
        System.out.println("Bienvenido(a) al sistema");
        return;
    }

    public static void menuIngresar() {
        boolean exito = false;
        String usuario;
        String clave;
        do {
            in = new Scanner(System.in);
            System.out.println("========================");
            System.out.println("Favor ingresar su usuario: (fin para terminar)");
            usuario = in.nextLine();
            if(usuario.equals("fin")) return;
            System.out.println("Favor ingresar su clave: ");
            clave = in.nextLine();
            Principal.usuarioActivo = coleccionUsuarios.buscarUsuarioClave(usuario, clave);
            if(usuario == null) {
                System.out.println("Combinación usuario y clave inválida");
            } else {
                exito = true;
            }
        } while (!exito);
        System.out.println("Hola, " + Principal.usuarioActivo.getNombreCompleto());
        System.out.println("Estás en el sistema");
        menuUsuarioActivo();
    }

    public static void menuUsuarioActivo() {
        int opcion;
        do {
            in = new Scanner(System.in);
            System.out.println("========================");
            System.out.println("1. Crear una publicación");
            System.out.println("2. Pedir una amistad");
            System.out.println("3. Ver las publicaciones de un(a) amigo(a)");
            System.out.println("4. Ver mis publicaciones");
            System.out.println("9. Regresar");
            System.out.println("Por favor digite su opción");
            opcion = in.nextInt();
            switch (opcion) {
                case 1:
                    menuCrearPublicacion();
                    break;
                case 2:
                    menuPedirAmistad();
                    break;
                case 3:
                    menuVerPublicacionesAmigo();
                    break;
                case 4:
                    menuVerPublicacionesPropias();
                    break;
            }
        } while (opcion != 9);
    }

    public static void menuCrearPublicacion() {
        String texto;
        in = new Scanner(System.in);
        System.out.println("========================");
        System.out.println("Favor ingresar el texto de su publicación: ");
        texto = in.nextLine();
        Publicacion publicacion = 
            new Publicacion(Principal.usuarioActivo.getUsuario(), texto);
        Principal.coleccionPublicaciones.agregarPublicacion(publicacion);
        System.out.println("La publicación ha sido agregada");
    }

    public static void menuPedirAmistad() {
        boolean exito = false;
        String usuario;
        Usuario amigo;
        do {
            in = new Scanner(System.in);
            System.out.println("========================");
            System.out.println("Favor ingresar el(la) amigo(a): (fin para terminar)");
            usuario = in.nextLine();
            if(usuario.equals("fin")) return;
            amigo = coleccionUsuarios.buscarUsuario(usuario);
            if(amigo == null) {
                System.out.println("Usuario(a) no existe en el sistema");
                continue;
            }
            if(Principal.coleccionAmistades.buscarAmistad(Principal.usuarioActivo.getUsuario(), usuario)) {
                System.out.println("La amistad ya existe");
                continue;
            }
            if(usuario.equals(Principal.usuarioActivo.getUsuario())) {
                System.out.println("No tiene sentido que te pidas amistad a tí mismo(a)");
                continue;
            }
            Amistad amistad = new Amistad(Principal.usuarioActivo.getUsuario(), amigo.getUsuario());
            System.out.print(Principal.usuarioActivo.getNombreCompleto() + ", ");
            System.out.println("la amistad ha sido creada");
            exito = true;
        } while (!exito);
    }

    public static void menuVerPublicacionesAmigo() {

    }

    public static void menuVerPublicacionesPropias() {
        String usuario = Principal.usuarioActivo.getUsuario();
        ArrayList<Publicacion> seleccionadas = Principal.coleccionPublicaciones.getPublicacionesDeUnUsuario(usuario);
        System.out.println("Las publicaciones de " + Principal.usuarioActivo.getNombreCompleto() + ": ");
        for(Publicacion p: seleccionadas) {
            System.out.println(p.getTexto());
        }
    }

    public static void main(String [] args) {
        inicializarColecciones();
        menuPrincipal();

    }
}
