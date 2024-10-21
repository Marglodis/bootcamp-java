package evaluacionS8.modelos;


public class Venta {
	 private Vendedor vendedor;
	    private double ganancia;

	    public Venta(Vendedor vendedor, double ganancia) {
	        this.vendedor = vendedor;
	        this.ganancia = ganancia;
	    }

	    public Vendedor getVendedor() {
	        return vendedor;
	    }

	    public double getGanancia() {
	        return ganancia;
	    }

	    @Override
	    public String toString() {
	        return "Venta [vendedor=" + vendedor + ", ganancia=" + ganancia + "]";
	    }
}
