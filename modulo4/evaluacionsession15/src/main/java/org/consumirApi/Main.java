package org.consumirApi;

import org.consumirApi.controlador.UsuarioControlador;

public class Main {
    public static void main(String[] args) {
            UsuarioControlador controlador = new UsuarioControlador();
            controlador.crearUsuario();
    }
}