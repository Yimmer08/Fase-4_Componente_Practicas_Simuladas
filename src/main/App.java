package main;

import modelos.Cliente;
import excepciones.ClienteInvalidoException;

public class App {
    public static void main(String[] args) {
        System.out.println("=== INICIO DE PRUEBA CORTA ===");

        try {
            // Caso 1: Todo bien
            Cliente c1 = new Cliente(1, "Yimme", "yimme@correo.com");
            System.out.println("EXITO: " + c1.getDetalles());

            // Caso 2: Forzar el error para ver si el Log funciona
            System.out.println("\nProbando validación de email...");
            Cliente c2 = new Cliente(2, "Test Error", "correo-sin-arroba");
            
        } catch (ClienteInvalidoException e) {
            System.err.println("CAPTURA CORRECTA: " + e.getMessage());
        }
    }
}