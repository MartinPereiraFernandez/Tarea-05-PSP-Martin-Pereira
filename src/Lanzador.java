import java.io.File;
import java.io.IOException;

public class Lanzador{
    public int factor(String numero){
        int codigoSalida;
        try{
            ProcessBuilder pb = new ProcessBuilder("factor",numero);
            pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);  //Se redirecciona el la salida hacia la consola gracias al .INHERIT
            pb.redirectError(ProcessBuilder.Redirect.INHERIT);  //Dara fallo en caso de que el usuario en vez de meter un numero entero meta una caja de texto.
            Process proceso = pb.start(); //Inicializamos el proceso
            codigoSalida=proceso.waitFor(); //Al acabar el proceso se obtiene el codigo de salida, si todo sale bien, el codigo de salida el 0, en caso de que no será -1.
            //Se forman dos catch ya que se pueden dar dos tipos de errores, por eso daba fallo el .waitFor().
            //Dentro del try puede dar fallo al inicializar el proceso, lo que se corresponda al primer catch.
            //Tambien puede dar fallo el waitFor, lo que se complementa con el segundo catch. El waitFor daba fallo ya que el segundo catch no estaba creado
        } catch (IOException e){
            System.out.println("Error al calcular el factor: ");
            codigoSalida=-1;
        } catch (InterruptedException e){
            System.out.println("Se interrumpió el cálculo: ");
            Thread.currentThread().interrupt();
            codigoSalida=-1;
        }
        return codigoSalida;
    }


    public int factorAFichero(String numero){
        int codigoSalida;
        try{
            ProcessBuilder pb = new ProcessBuilder("factor",numero);
            pb.redirectOutput(ProcessBuilder.Redirect.appendTo(new File("factour_output.log")));  //Casi lo mismo solo que unicamente cambiamos el inherit por el fichero que se creará.
            pb.redirectError(ProcessBuilder.Redirect.appendTo(new File("factour_error.log")));
            Process proceso = pb.start(); //Inicializamos el proceso
            codigoSalida=proceso.waitFor(); //Al acabar el proceso se obtiene el codigo de salida, si todo sale bien, el codigo de salida el 0, en caso de que no será -1.
            //Se forman dos catch ya que se pueden dar dos tipos de errores, por eso daba fallo el .waitFor().
            //Dentro del try puede dar fallo al inicializar el proceso, lo que se corresponda al primer catch.
            //Tambien puede dar fallo el waitFor, lo que se complementa con el segundo catch. El waitFor daba fallo ya que el segundo catch no estaba creado
        } catch (IOException e){
            System.out.println("Error al calcular el factor: ");
            codigoSalida=-1;
        } catch (InterruptedException e){
            System.out.println("Se interrumpió el cálculo: ");
            Thread.currentThread().interrupt();
            codigoSalida=-1;
        }
        return codigoSalida;
    }

    public boolean esPrimo(int numero){
        for (int i = 2 ; i < numero ; i++){
            if (numero % i == 0){
                return false;
            }
        }
        return true;
    }
}