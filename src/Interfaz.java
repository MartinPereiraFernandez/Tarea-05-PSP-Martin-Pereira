import java.util.Scanner;

public class Interfaz{
    public Lanzador lanzador = new Lanzador();  //Clase lanzador creada antes.
    public Scanner scanner = new Scanner(System.in);

    public void iniciar(){
        while (true){ //Bucle para que no rompa despues de calcular un número o dar fallo con un texto, este se romperá si se pone 'salir' en el scanner.
            System.out.println("Introduce numero (o 'salir' para terminar):");
            System.out.print("> "); //En vez de println se usa un un print para que el scanner se haga en esa linea en vez de la de abajo.
            String entrada = scanner.nextLine();

            if (entrada.equals("salir")){  //Rompe el bucle finalizando el programa.
                System.out.println("Saliendo...");
                break;
            }
            int codigoSalida = lanzador.factor(entrada);  //Usa el lanzador para obtener el codigo de salida, este dependera si se usa el try o el catch.
            System.out.println("Operación cpmpletada. Codigo de salida: "+codigoSalida);
        }
    }

}