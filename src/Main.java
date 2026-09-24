import java.util.Scanner;

public class Main{
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);

        menu:
        while (true) {
            System.out.println("¿Que nivel quieres usar? (1,3 o 4) - Para salir usa otro número");
            System.out.print("> "); //En vez de println se usa un un print para que el scanner se haga en esa linea en vez de la de abajo.
            int entrada = scanner.nextInt();
            switch (entrada) {
                case 1: {
                    Interfaz interfaz = new Interfaz(1);
                    interfaz.iniciar();
                    break;
                }

                case 3: {
                    Interfaz interfaz = new Interfaz(3);
                    interfaz.iniciar();
                    break;
                }

                case 4: {
                    Interfaz interfaz = new Interfaz (4);
                    interfaz.iniciar();
                    break;
                }

                default:
                    System.out.println("Saliendo del programa");
                    break menu;
            }
        }
    }
}