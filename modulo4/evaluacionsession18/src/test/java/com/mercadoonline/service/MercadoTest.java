package com.mercadoonline.service;

import com.mercadoonline.model.Producto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MercadoTest {

    @Test
    public void testCrearAviso() {
        Producto producto = Producto.crearAviso("Computadora X", 111, "Nuevo","$500.000");
        assertNotNull(producto);
        assertEquals("Computadora X", producto.getNombre());
        assertEquals(111, producto.getIdProducto());
        assertEquals("Nuevo", producto.getCondicion());
        assertEquals("$500.000",producto.getPrecio());
    }

    @Test
    public void testPublicarAviso() {
        MercadoService mercadoService = new MercadoService();
        List<Producto> productos = new ArrayList<>();
        Producto producto = new Producto("Computadora X", 111, "Nuevo","$5000.000");
        productos = mercadoService.publicarAviso(productos, producto);

        assertNotNull(productos);
        assertEquals(1, productos.size());
        assertEquals(producto, productos.get(0));
    }
}
