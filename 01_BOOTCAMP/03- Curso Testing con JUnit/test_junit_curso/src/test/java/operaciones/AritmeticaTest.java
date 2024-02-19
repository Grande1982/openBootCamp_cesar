package operaciones;

import org.junit.jupiter.api.Test;

class AritmeticaTest {
    @Test
    void comprobarSuma(){
        Aritmetica art = new Aritmetica();
        art.suma(5,5);


    }

    @Test
    void comprobarResta(){
        Aritmetica art = new Aritmetica();
        art.resta(5,3);

    }


}