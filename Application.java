import Conversor.ConversorClient;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        final String textoSolicitar = "Ingrese el valor que desees convertir: ";
        double resultado;
        String seguir = "S";
        ConversorClient c = new ConversorClient();

        while (seguir.equalsIgnoreCase("S")) {
            try {
                exibirMenu();
                int opcionElegida = sc.nextInt();
                double valorACambiar;

                switch (opcionElegida) {
                    case 1:
                        System.out.println(textoSolicitar);
                        valorACambiar = sc.nextDouble();
                        resultado = Double.parseDouble(c.findAll("USD", "ARS", valorACambiar));
                        System.out.format("El valor %.2f [USD] corresponde al valor final de ==> %.2f [ARS]", valorACambiar, resultado);
                        break;
                    case 2:
                        System.out.println(textoSolicitar);
                        valorACambiar = sc.nextDouble();
                        resultado = Double.parseDouble(c.findAll("ARS", "USD", valorACambiar));
                        System.out.format("El valor %.2f [ARS] corresponde al valor final de ==> %.2f [USD]", valorACambiar, resultado);
                        break;
                    case 3:
                        System.out.println(textoSolicitar);
                        valorACambiar = sc.nextDouble();
                        resultado = Double.parseDouble(c.findAll("USD", "BRL", valorACambiar));
                        System.out.format("El valor %.2f [USD] corresponde al valor final de ==> %.2f [BRL]", valorACambiar, resultado);
                        break;
                    case 4:
                        System.out.println(textoSolicitar);
                        valorACambiar = sc.nextDouble();
                        resultado = Double.parseDouble(c.findAll("BRL", "USD", valorACambiar));
                        System.out.format("El valor %.2f [BRL] corresponde al valor final de ==> %.2f [USD]", valorACambiar, resultado);
                        break;
                    case 5:
                        System.out.println(textoSolicitar);
                        valorACambiar = sc.nextDouble();
                        resultado = Double.parseDouble(c.findAll("USD", "COP", valorACambiar));
                        System.out.format("El valor %.2f [USD] corresponde al valor final de ==> %.2f [COP]", valorACambiar, resultado);
                        break;
                    case 6:
                        System.out.println(textoSolicitar);
                        valorACambiar = sc.nextDouble();
                        resultado = Double.parseDouble(c.findAll("COP", "USD", valorACambiar));
                        System.out.format("El valor %.2f [COP] corresponde al valor final de ==> %.2f [USD]", valorACambiar, resultado);
                        break;
                    case 7:
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
                **  7) Salir                              **
                **                                        **
                ********************************************
                
                Elija una opción válida:
                """);
    }
}
