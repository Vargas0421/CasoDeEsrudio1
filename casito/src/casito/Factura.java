package casito;

public class Factura {
    private String nombreCliente;
    private String cedulaCliente;
    private int numeroFactura;
    private double montoFactura;
    private int mesFactura;
    private int anoFactura;
    private boolean pagada;

    public Factura(String nombreCliente, String cedulaCliente, int numeroFactura, double montoFactura, int mesFactura, int anoFactura, boolean pagada) {
        this.nombreCliente = nombreCliente;
        this.cedulaCliente = cedulaCliente;
        this.numeroFactura = numeroFactura;
        this.montoFactura = montoFactura;
        this.mesFactura = mesFactura;
        this.anoFactura = anoFactura;
        this.pagada = pagada;
    }

    public boolean estaPagada() {
        return pagada;
    }
    
    public int obtenerMesFactura() {
        return mesFactura;
    }
    public int obtenerAnoFactura(){
        return anoFactura;
    }
    
    
    public double obtenerMontoFactura() {
        return montoFactura;
    }
    
    public int obtenerNumeroFactura() {
        return numeroFactura;
    }

    public int getMesFactura() {
        return mesFactura;
    }

    public void setMontoFactura(double montoFactura) {
        this.montoFactura = montoFactura;
    }

    public void setMesFactura(int mesFactura) {
        this.mesFactura = mesFactura;
    }
}
