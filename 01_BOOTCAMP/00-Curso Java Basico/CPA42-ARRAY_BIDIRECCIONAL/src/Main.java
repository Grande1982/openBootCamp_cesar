public class Main {
    public static void main(String[] args) {

        int arrayBi[][] = new int[2][4];
        //FILA 1 COLUMNA 0-3
        arrayBi[0][0]=1;
        arrayBi[0][1]=2;
        arrayBi[0][2]=3;
        arrayBi[0][3]=4;
        //FILA 2 COLUMNA 0-3
        arrayBi[1][0]=10;
        arrayBi[1][1]=20;
        arrayBi[1][2]=30;
        arrayBi[1][3]=40;

        for (int i=0; i < arrayBi.length; i++){

            for(int j=0; j < arrayBi[i].length; j++){
                System.out.println("arrayBi["+i+"]["+j+"]"+arrayBi[i][j]);
            }
        }

    }
}