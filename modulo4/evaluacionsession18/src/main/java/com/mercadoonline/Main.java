package com.mercadoonline;

import com.mercadoonline.model.Producto;
import com.mercadoonline.service.MercadoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MercadoService mercado = new MercadoService();

        List<Producto> listaProductos = new ArrayList<>();

        System.out.println("Ingrese el nombre del producto: ");
        String nombre = sc.nextLine();

        System.out.println("Ingrese el ID del producto:");
        int idProducto = sc.nextInt();
        sc.nextLine();

        System.out.println("¿Cúal es la condición del producto?");
        String condicion = sc.nextLine();

        System.out.println("¿Cuál es el precio del producto?");
        String precio = sc.nextLine();

        Producto nuevoProducto = Producto.crearAviso(nombre, idProducto, condicion, precio);
        listaProductos = mercado.publicarAviso(listaProductos, nuevoProducto);

        mercado.verTodoAviso(listaProductos);
        sc.close();

    }
}