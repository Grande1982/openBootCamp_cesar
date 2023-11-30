import java.io.*;

public class Main {
    public static void main(String[] args) {

        InputStream entrada = null;
        try {
            entrada = new FileInputStream("cesar.txt");


        } catch (FileNotFoundException e) {
            System.out.println("no existe el fichero: " + e.getMessage());
        }
        try {
            byte[] archivoLectura = entrada.readAllBytes();

            for (byte arc : archivoLectura) {
                System.out.print((char) arc);
            }


        } catch (IOException e) {
            System.out.println("no puede leer el ficheo: " + e.getMessage());
        }
        //BufferedInputStream ent = new BufferedInputStream(entrada);


    }
}