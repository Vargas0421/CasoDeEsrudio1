
package casito;
import javax.swing.JOptionPane;
import java.util.ArrayList;// estas vienen pegadas a lo mismo que me encontre en redit para almacenar la infromacino 
import java.util.List;

public class Casito {

    public static void main(String[] args) { // aca preguntamso los datos solo una vez porque en teoria es el mismo cliente 
        String nombreCliente = JOptionPane.showInputDialog("Nombre del cliente: ");
        String cedulaCliente = JOptionPane.showInputDialog("Cedula del cliente: ");

        List<Factura> facturas = new ArrayList<>();//Esta linea se usa para crear una nueva lista de objetos
        // esta fue la manera en la que encontre almacenar la informacion me la encontre en un foro miedo de redit jajaja

        int cantidadFacturas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de facturas a registrar: "));

        for (int i = 0; i < cantidadFacturas; i++) { // aca creamos un for para preguintar lo mismo dependiendo de la cantidad de facturas selecionadas
            System.out.println("Factura #" + (i + 1)); //aca se pide por pantalla que se ingresen los datos necesarios 
            int numeroFactura = Integer.parseInt(JOptionPane.showInputDialog("Numero de factura: "));
            double montoFactura = Double.parseDouble(JOptionPane.showInputDialog("Monto de la factura: "));
            int mesFactura = Integer.parseInt(JOptionPane.showInputDialog("Mes de la factura (como número): "));
            int anoFactura = Integer.parseInt(JOptionPane.showInputDialog("Año de la factura: "));
            int estadoFactura = Integer.parseInt(JOptionPane.showInputDialog("Estado de la factura (1 - Pagada, 2 - No pagada): "));

            boolean pagada = (estadoFactura == 1); // esta variable se anade para que no se anadan cuentas que ya se pagaron 
            facturas.add(new Factura(nombreCliente, cedulaCliente, numeroFactura, montoFactura, mesFactura, anoFactura, pagada));
            //se anade una "factura"
        }

        System.out.println("\nResumen de facturas:");
        double totalDeuda = 0;

        for (Factura factura : facturas) {
            if (!factura.estaPagada()) {
                totalDeuda += factura.obtenerMontoFactura();
            }
            System.out.println("El cliente debe un total de $" + totalDeuda + " con un interés del 5%.");
        }

        if (totalDeuda > 0) { // aca es donde se calcula la deuda
            double debePagar = ((totalDeuda*0.05)+totalDeuda)/6;
            System.out.println("El total a pafar cada 6 meses es de $" + debePagar + " por mes, esto ya con el interes.");
            } 
    }
}
