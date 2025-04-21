package teatromoro;

import java.util.Scanner;

public class Exp1_s6_Diego_Ulloa {
    static Scanner scanner = new Scanner(System.in);
    static final int TOTAL_ASIENTOS = 40;
    static boolean[] asientosReservados = new boolean[TOTAL_ASIENTOS];
    static boolean[] asientosComprados = new boolean[TOTAL_ASIENTOS];
    static int totalEntradasVendidas = 0;
    static int totalReservas = 0;
    static int ingresosTotales = 0;
    static final int PRECIO_ENTRADA = 5000;

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1 -> reservarAsiento();
                case 2 -> comprarEntrada();
                case 3 -> modificarVenta();
                case 4 -> imprimirBoleta();
                case 5 -> System.out.println("Muchas Gracias! nos vemos pronto!");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 5);
    }

    public static void mostrarMenu() {
        System.out.println("\n--- Menú Teatro Moro ---");
        System.out.println("1. Reservar asiento");
        System.out.println("2. Comprar entrada");
        System.out.println("3. Modificar venta");
        System.out.println("4. Imprimir boleta");
        System.out.println("5. Salir");
        System.out.print("Selecciona una opción: ");
    }
//sistema de reserva, falta confirmar compra de reserva
    public static void reservarAsiento() {
        System.out.print("Ingresa número de asiento (0-40) a reservar: ");
        int num = scanner.nextInt();
        if (num >= 0 && num < TOTAL_ASIENTOS && !asientosReservados[num] && !asientosComprados[num]) {
            asientosReservados[num] = true;
            totalReservas++;
            System.out.println("Asiento reservado exitosamente.");
        } else {
            System.out.println("Asiento no disponible.");
        }
    }
//Compraa de entrada del 0 al 40 (Asiento)
    public static void comprarEntrada() {
        System.out.print("Ingresa número de asiento (0-40) a comprar: ");
        int num = scanner.nextInt();
        if (num >= 0 && num < TOTAL_ASIENTOS && (!asientosComprados[num])) {
            asientosComprados[num] = true;
            asientosReservados[num] = false;
            totalEntradasVendidas++;
            ingresosTotales += PRECIO_ENTRADA;
            System.out.println("Entrada comprada correctamente.");
        } else {
            System.out.println("No se puede completar la compra.");
        }
    }
//seccion en donde el cliente puede devolver su entrada
    public static void modificarVenta() {
        System.out.print("Ingresa número de asiento a modificar (0-40): ");
        int num = scanner.nextInt();
        if (num >= 0 && num < TOTAL_ASIENTOS && asientosComprados[num]) {
            asientosComprados[num] = false;
            totalEntradasVendidas--;
            ingresosTotales -= PRECIO_ENTRADA;
            System.out.println("Venta modificada. El asiento ahora está disponible.");
        } else {
            System.out.println("Este asiento aun esta libre... Adquierelo AHORA!!");
        }
    }
//Boleta detallada a copmprador
    public static void imprimirBoleta() {
        System.out.print("Ingresar número de asiento para imprimir boleta (0-40): ");
        int num = scanner.nextInt();
        if (num >= 0 && num < TOTAL_ASIENTOS && asientosComprados[num]) {
            System.out.println("==== BOLETA TEATRO MORO ====");
            System.out.println("Este documento es valido por SII");
            System.out.println("      Detalle de compra:");
            System.out.println("          Asiento: " + num);
            System.out.println("         Cantidad: 1");
            System.out.println("     Precio total: $" + PRECIO_ENTRADA);
            System.out.println("*****Gracias por su compra*******");
            System.out.println("*****NOS VEMOS PRONTO*****");

        } else {
            System.out.println("Este asiento aun esta disponible");
        }
    }
}