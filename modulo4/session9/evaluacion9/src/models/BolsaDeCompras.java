package models;

import java.util.ArrayList;

public class BolsaDeCompras<T extends Articulo>{
    private int tamano;
    private ArrayList<T> articulos;

    public BolsaDeCompras(int tamano){
        this.tamano = tamano;
        this.articulos = new ArrayList<>();
    }

    public void agregarArticulo(T articulo){
        if(tamano > articulos.size()){
            articulos.add(articulo);
            System.out.println("Artículo agregado: " + articulo);
        }else {
            System.out.println("La bolsa está llena. No se puede agregar más productos.");
        }
    }

    public void mostrarArticulos(){
        if(articulos.isEmpty()){
            System.out.println("La bolsa está vacía.");
        } else {
            System.out.println("Artículos en la bolsa: ");
            for (T articulo: articulos){
                System.out.println(articulo);
            }
        }
    }
}
