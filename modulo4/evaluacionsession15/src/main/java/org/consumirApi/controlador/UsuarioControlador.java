package org.consumirApi.controlador;

import org.consumirApi.modelo.Usuario;
import org.consumirApi.servicio.ServicioGeolocalizacion;

import java.util.Scanner;

public class UsuarioControlador {

    private final ServicioGeolocalizacion servicioGeolocalizacion;

    public UsuarioControlador() {
        this.servicioGeolocalizacion = new ServicioGeolocalizacion();
    }

    public void crearUsuario(){
        Scanner sc = new Scanner(System.in);

        try{
            System.out.println("Bienvenido, para crear un usuario deberá rellenar los siguientes campos:");

            String nombre = validarEntrada(sc, "Nombre");
            String apellido = validarEntrada(sc, "Apellido");
            String correo = validarEntrada(sc, "Correo");
            String clave = validarEntrada(sc, "Contraseña");

            Usuario usuario = new Usuario();
            usuario.setNombre(nombre);
            usuario.setApellido(apellido);
            usuario.setCorreo(correo);
            usuario.setClave(clave);

            //Obtener datos geográficos
            var geolocal = servicioGeolocalizacion.obtenerDatosGeograficos();
            if(geolocal != null){
                usuario.setCiudad(geolocal.getCiudad());
                usuario.setRegion(geolocal.getRegion());
                usuario.setPais(geolocal.getPais());
                usuario.setContinente(geolocal.getContinente());
            } else {
                System.out.println("No se pudo obtener la geolocalización.");
            }

            System.out.println("Gracias, su usuario es:");
            System.out.println(usuario);

        }catch (Exception e){
            System.out.println("Error al crear el usuario: " + e.getMessage());
        }
    }

    private String validarEntrada(Scanner scanner, String campo) throws Exception{
        String input = "";
        while (input.trim().isEmpty()){
            System.out.print(campo + ": ");
            input = scanner.nextLine();
            if(input.trim().isEmpty()){
                System.err.println("El campo " + campo + " no puede estar vacío. Intente de nuevo.");
            }
        }
        return input;
    }


}
