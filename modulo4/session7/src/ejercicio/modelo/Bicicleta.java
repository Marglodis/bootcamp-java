package ejercicio.modelo;

public class Bicicleta extends Vehiculo{
    private String tipoBicicleta;

    public Bicicleta(int numeroRuedas, int cantidadVentanas, String tipoBicicleta){
        super(numeroRuedas, cantidadVentanas);
        this.tipoBicicleta = tipoBicicleta;
    }

    @Override
    public void encender(){
        System.out.println("Bicicleta en movimiento.");
    }

    @Override
    public void apagar() {
        System.out.println("Bicicleta detenida.");
    }

    @Override
    public String toString(){
        return "Bicicleta{" +
                "tipoBicicleta='" + tipoBicicleta + '\'' +
                ", numeroRuedas=" + numeroRuedas +
                ", cantidadVentanas=" + cantidadVentanas +
                '}';
    }
}
