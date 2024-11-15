package com.mercadoonline.service;

import com.mercadoonline.model.Producto;

import java.util.ArrayList;
import java.util.List;

public class MercadoService {
    private List<Producto> productos;

    public MercadoService() {
        this.productos = new ArrayList<>();
    }

    public List<Producto> publicarAviso(List<Producto> productos, Producto producto) {
        productos.add(producto);
        System.out.println("Su producto ha sido subido a mercado online");
        return productos;
    }

    public void verTodoAviso(List<Producto> productos) {
        System.out.println("Productos disponibles: ");
        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }
}
