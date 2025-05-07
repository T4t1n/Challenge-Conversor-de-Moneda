package Recursos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.Scanner;

public class HistorialYRegistro {

    static LocalDate fechaDeResgistro = LocalDate.now();

    public static void guardarEnArchivoHistorial(String conversionRealizada) {

        try {
            File file = new File("Historial de Conversiones.txt");
            FileWriter writer = new FileWriter(file, true);
            writer.write(conversionRealizada + '\n');
            writer.close();
            System.out.println("Se logro");
        }catch (Exception e) {
            e.getStackTrace();
            System.out.println("No se logro");
        }
    }

    public static void lecturaDeHistorial() {
        try {
            File archivo = new File("Historial de Conversiones.txt");
            Scanner scanner = new Scanner(archivo);

            while(scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                System.out.println(linea);
            }
        } catch(FileNotFoundException e) {
            System.out.println("Archivo no encontrado!");
        }
    }

    public static void registroConMarcasDeTiempo(String conversionRealizada) {

        try {
            File file = new File("Registro con marcas de tiempo.txt");
            FileWriter writer = new FileWriter(file, true);
            writer.write(conversionRealizada + " Fecha: " + fechaDeResgistro + '\n');
            writer.close();
        }catch (Exception e) {
            e.getStackTrace();
            System.out.println("No se logro");
        }

    }

    public static void lecturaDeRegistro() {
        try {
            File archivo = new File("Registro con marcas de tiempo.txt");
            Scanner scanner = new Scanner(archivo);

            while(scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                System.out.println(linea);
            }
        } catch(FileNotFoundException e) {
            System.out.println("Archivo no encontrado!");
        }
    }








}
