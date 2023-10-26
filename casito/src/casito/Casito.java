
package casito;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class Casito {

    public static void main(String[] args) {
        String nombreCliente = JOptionPane.showInputDialog("Nombre del cliente: ");
        String cedulaCliente = JOptionPane.showInputDialog("Cedula del cliente: ");

        List<Factura> facturas = new ArrayList<Factura>();

        int cantidadFacturas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de facturas a registrar: "));

        for (int i = 0; i < cantidadFacturas; i++) {
            System.out.println("Factura #" + (i + 1));
            int numeroFactura = Integer.parseInt(JOptionPane.showInputDialog("Numero de factura: "));
            double montoFactura = Double.parseDouble(JOptionPane.showInputDialog("Monto de la factura: "));
            int mesFactura = Integer.parseInt(JOptionPane.showInputDialog("Mes de la factura (como número): "));
            int anoFactura = Integer.parseInt(JOptionPane.showInputDialog("Año de la factura: "));
            int estadoFactura = Integer.parseInt(JOptionPane.showInputDialog("Estado de la factura (1 - Pagada, 2 - No pagada): "));

            boolean pagada = (estadoFactura == 1);
            facturas.add(new Factura(nombreCliente, cedulaCliente, numeroFactura, montoFactura, mesFactura, anoFactura, pagada));
        }

        System.out.println("\nResumen de facturas:");
        double totalDeuda = 0;

        for (Factura factura : facturas) {
            if (!factura.estaPagada()) {
                totalDeuda += factura.obtenerMontoFactura();
            }
            System.out.println("Cliente: " + nombreCliente);
            System.out.println("Cedula: " + cedulaCliente);
            System.out.println("Numero de factura: " + factura.obtenerNumeroFactura());
            System.out.println("Monto de la factura: " + factura.obtenerMontoFactura());
            System.out.println("Mes de la factura: " + factura.obtenerMesFactura());
            System.out.println("Año de la factura: " + factura.obtenerAnoFactura());
            System.out.println("Estado de la factura: " + (factura.estaPagada() ? "Pagada" : "No pagada"));
            System.out.println();
        }

        if (totalDeuda > 0) {
            double interes = totalDeuda * 0.05;
            double cuotaMensual = (totalDeuda + interes) / 6;
            System.out.println("El cliente debe un total de $" + totalDeuda + " con un interés del 5%.");
            System.out.println("El plan de pago fraccionado a 6 meses es de $" + cuotaMensual + " por mes.");
        } else {
            System.out.println("El cliente no tiene deudas pendientes.");
        }
    }
}
