public class Main {
    public static void main(String[] args) {


        String cadena = "Hola Mundo";
        int cadenaLen = cadena.length();
        System.out.println(cadenaLen);

        for (int i = 0; i < cadena.length(); i++) {

            System.out.print(cadena.charAt(i));

        }

        int cad = cadenaLen -1;
        System.out.println();

        for (int j = 0; j < cadena.length(); j++) {

            System.out.print(cadena.charAt(cad-j));

        }


    }
}