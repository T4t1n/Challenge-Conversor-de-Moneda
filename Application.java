import Conversor.ConversorClient;
import Recursos.HistorialYRegistro;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {
    static Scanner sc = new Scanner(System.in);
    static ConversorClient c = new ConversorClient();
    public static void main(String[] args)  {

        final String textoSolicitar = "Ingrese el valor que desees convertir: ";
        String resultado;

        String seguir = "S";
        ConversorClient c = new ConversorClient();

        // Paso: Interactuando con el usuario.
        while (seguir.equalsIgnoreCase("S")) {
            try {
                exibirMenu();
                int opcionElegida = sc.nextInt();
                double valorACambiar;

                switch (opcionElegida) {
                    case 1:
                        monedas("USD", "ARS");
                        break;
                    case 2:
                        monedas("ARS", "USD");
                        break;
                    case 3:
                        monedas("USD", "BRL");
                        break;
                    case 4:
                        monedas("BRL", "USD");
                        break;
                    case 5:
                        monedas("USD","COP");
                        break;
                    case 6:
                        monedas("COP", "USD");
                        break;
                    case 7:
                        monedas("USD", "CRC");
                        break;
                    case 8:
                        monedas("CRC", "USD");
                        break;
                    case 9:
                        System.out.println("Historial de conversiones: ");
                        HistorialYRegistro.lecturaDeHistorial();
                        break;
                    case 10:
                        System.out.println("Registro con marcas de tiempo: ");
                        HistorialYRegistro.lecturaDeRegistro();
                        break;
                    case 11:
                        System.out.print("Finalizando...");
                        break;
                    default:
                        System.out.println("Opción no valida.");
                        break;

                }

                do {
                    System.out.println("\n\n¿Desea continuar ejecutando el programa? Digite S/N");
                    seguir = sc.next();
                    if (seguir.equalsIgnoreCase("n")) {
                        System.out.println("Finalizando programa...");
                        break;
                    }
                } while (!seguir.equalsIgnoreCase("s") && !seguir.equalsIgnoreCase("n"));
            }catch (InputMismatchException e) {
                System.out.println("No es un valor valido" + e);
                break;
            } catch (Exception e) {
                System.out.println("Error " + e);
                break;
            }

        }
    }

    public static void exibirMenu() {
        System.out.println();
        System.out.println("""
                ********************************************
                **                                        **
                **  Bienvenido/a al Conversor de Moneda.  **
                **                                        **
                **  1) Dólar =>> Peso argentino           **
                **  2) Peso argentino =>> Dólar           **
                **  3) Dólar =>> Real brasileño           **
                **  4) Real brasileño =>> Dólar           **
                **  5) Dólar ==> Peso colombiano          **
                **  6) Peso colombiano =>> Dólar          **
                **  7) Dólar =>> colon costarricense      **
                **  8) colon costarricense =>> Dólor      **
                **  9) Historial de conversiones          **
                **  10) Registros con marcas de tiempo    **
                **  11) Salir                             **
                **                                        **
                ********************************************
                
                Elija una opción válida:
                """);
    }

   //Metodo con el cual podremos agregar mas monedas eficientemente
    public static void monedas(String baseMoneda, String monedaObjetivo) throws IOException, InterruptedException {
        System.out.println("Ingrese el valor que desees convertir: ");
        double valorACambiar = sc.nextDouble();
        String resultado = String.valueOf(c.findAll(baseMoneda, monedaObjetivo, valorACambiar));
        String result = "El valor " + valorACambiar + " ["+baseMoneda+"]"+ " corresponde al valor final de ==> " +resultado +" ["+monedaObjetivo+"]";
        System.out.println(result);
        HistorialYRegistro.guardarEnArchivoHistorial(result);
        HistorialYRegistro.registroConMarcasDeTiempo(result);
    }
}
