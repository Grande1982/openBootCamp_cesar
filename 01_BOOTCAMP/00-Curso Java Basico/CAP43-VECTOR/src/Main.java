import java.util.Vector;

public class Main {
    public static void main(String[] args) {


        Vector<Integer>ve1 =new Vector<>();
        ve1.add(1);
        ve1.add(3);
        ve1.add(2);

        System.out.println("datos del vector son: "+ve1);

        Vector<Integer>ve2 =new Vector<>();
        ve2.add(1);
        ve2.add(30);
        ve2.add(2);

        boolean resultado = ve2.equals(ve1);
        System.out.println("iguales "+resultado);


        for (int valor : ve1){
            System.out.println("vector 1: "+valor);
        }

        for (int i= 0; i < ve2.size();i++){

            System.out.println("vector 2: "+ve2.get(i));
        }



        ;
    }
}