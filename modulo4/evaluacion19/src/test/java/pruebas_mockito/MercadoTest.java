package pruebas_mockito;

import com.pruebas_unitarias.model.Producto;
import com.pruebas_unitarias.service.MercadoService;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class MercadoTest {

    @Test
    void testCrearAviso(){
        Producto producto = Producto.crearAviso("Laptop", 1, "Nuevo", "$1.000.000");
        assertNotNull(producto);
        assertEquals("Laptop", producto.getNombre());
        assertEquals(1, producto.getIdProducto());
    }

    @Test
    void testPublicarAviso(){
        List<Producto> productosMock = mock(List.class);


        Producto producto = new Producto("Smartphone", 2, "Usado", "$1.500.000");

        // Configurar el mock: Simular comportamiento al agregar el producto
        when(productosMock.add(producto)).thenReturn(true);

        MercadoService mercadoService = new MercadoService();

        // Llamar al método que se quiere probar
        List<Producto> resultado = mercadoService.publicarAviso(productosMock, producto);

        // Verificar interacciones
        verify(productosMock, times(1)).add(producto);

        // Verificar que el resultado no sea nulo
        assertNotNull(resultado);
    }

    @Test
    void testVerTodoAviso(){
        List<Producto> productosMock = new ArrayList<>();

        productosMock.add(new Producto("Tablet", 3, "Nuevo", "$200.000"));

        MercadoService mercadoService = new MercadoService();
        mercadoService.verTodoAviso(productosMock);
        assertEquals(1, productosMock.size());
        assertEquals("Tablet", productosMock.get(0).getNombre());
    }

    @Test
    void testOrdenInvocaciones() {
        // Usar una lista real en lugar de un mock
        List<Producto> productosReal = new ArrayList<>();
        Producto producto = new Producto("PC", 4, "Nuevo", "800 USD");
        MercadoService mercado = spy(new MercadoService());

        // Publicar y luego verificar
        mercado.publicarAviso(productosReal, producto);
        mercado.verTodoAviso(productosReal);

        // Verificar el orden de invocaciones
        InOrder inOrder = inOrder(mercado);
        inOrder.verify(mercado).publicarAviso(productosReal, producto);
        inOrder.verify(mercado).verTodoAviso(productosReal);
    }
}
