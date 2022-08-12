package jalau.at18.katas.game2048.team1;
import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.Random;
import java.util.Scanner;

public class Main {
    //final int RANDOM_INITIAL_VALUES = 2;
    public static void main(String[] args) {

        int[] initialValues = randomValuesGrid();

        int[][] matrix = initialMatrix(initialValues[0], initialValues[1]);
        printMatrix(matrix);
        direcctions(matrix); // se envia la matriz
        //Integer [][] testMatrix = {{1,2,3,4},{5,6,7,8},{9,1,2,3},{4,5,9,7}};
        //gameOver(testMatrix);
        //System.out.println(verifySideUp(testMatrix));*/
        //wInteger [][] testMatrix = {{1,2,3,4},{5,2048,7,8},{9,0,2,3},{4,5,0,7}};
        //got2048(testMatrix );
    }

    public static void printMatrix(int[][] matrix) {
        System.out.println("\n-----------------------------------------------------------------");
        for (int row = 0; row < matrix.length; row++) {
            System.out.print("|\t");
            for (int column = 0; column < matrix.length; column++) {
                if (matrix[row][column] == 0) {
                    System.out.print(" " + "\t | \t");
                } else {
                    System.out.print(matrix[row][column] + "\t | \t");
                }
            }
            System.out.println("\n-----------------------------------------------------------------");
        }
    }

    public static int[] randomValuesGrid() {
        int[] numbers = { 2, 4 };
        Random random = new Random();
        int upperBound = 2; // utilizado para colocar el maximo valor, en nuestro caso la posicion de mi array
        int numberOne = random.nextInt(upperBound);
        int numberTwo = random.nextInt(upperBound);
        return new int[]{numbers[numberOne], numbers[numberTwo]};
    }
    public static int randomOneValueGrid() {
        int[] numbers = { 2, 4 };
        Random random = new Random();
        int upperBound = 2; // utilizado para colocar el maximo valor, en nuestro caso la posicion de mi array
        int numberOne = random.nextInt(upperBound);
        return numbers[numberOne];
    }

    public static int[] randomPositionGrid() {

        Random rand = new Random(); //instance of random class
        int upperbound = 4; //generate random values from 0-4
        int column = rand.nextInt(upperbound);
        int row = rand.nextInt(upperbound);
        return new int[]{row, column};
    }


    public static int[][] addTile(int[][] matrix) {
        int[] randomPosition = randomPositionGrid();

        while(matrix[randomPosition[0]][randomPosition[1]] != 0){
            randomPosition = randomPositionGrid();
        }
        int randomNumber = randomOneValueGrid();
        matrix[randomPosition[0]][randomPosition[1]] = randomNumber;
        return matrix;
    }


    public static int[][] initialMatrix (int firstNumber, int secondNumber) {
        int[][] matrix = {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
        int[] firstPositionRowColum = randomPositionGrid();
        int[] secondPositionRowColum = randomPositionGrid();
        //System.out.println(firstPositionRowColum + ""+secondPositionRowColum);

        while (firstPositionRowColum[0]  == secondPositionRowColum[0] && firstPositionRowColum[1]  == secondPositionRowColum[1]){
            secondPositionRowColum = randomPositionGrid();
        }
        matrix[firstPositionRowColum[0]][firstPositionRowColum[1]] = firstNumber;
        matrix[secondPositionRowColum[0] ][secondPositionRowColum[1]] = secondNumber;
        return matrix;
    }

    // w = arriba, a = izquierda, d = derecha, s = abajo

    public static void direcctions(int[][] matrix) { // el metodo pide la matriz
    	int [][] newMatrix= new int [4][4]; // nueva matriz
        System.out.println("Instrucciones del juego");
        System.out.println("Top: w");
        System.out.println("Left: a");
        System.out.println("Right: d");
        System.out.println("Down: s");

        Scanner scan = new Scanner(System.in);
        String directionValue = scan.nextLine();

        if(directionValue.equals("w")){
            System.out.println("metodo para mover arriba");
            newMatrix = moveTop(matrix);// guarda la matriz en una nueva
            newMatrix = addTile(newMatrix);
            printMatrix(newMatrix); // imprime la nueva matriz
            gameOver(newMatrix);
            got2048(newMatrix);
            direcctions(newMatrix); // recursividad (funcion se llama a si misma)
        }
        if(directionValue.equals("s")){
            System.out.println("Move down");
            newMatrix=moveDown(matrix);// guarda la matriz en una nueva
            newMatrix = addTile(newMatrix);
            printMatrix(newMatrix); // imprime la nueva matriz
            gameOver(newMatrix);
            got2048(newMatrix);
            direcctions(newMatrix); // recursividad (funcion se llama a si misma)


        }
        if(directionValue.equals("a")){
            System.out.println("Move left");
            newMatrix=moveLeft(matrix);// guarda la matriz en una nueva
            newMatrix = addTile(newMatrix);
            printMatrix(newMatrix); // imprime la nueva matriz
            gameOver(newMatrix);
            got2048(newMatrix);
            direcctions(newMatrix); // recursividad (funcion se llama a si misma)
        }
        if(directionValue.equals("d")){
            System.out.println("Move Rigth");
            newMatrix=moveRigth(matrix);// guarda la matriz en una nueva
            newMatrix = addTile(newMatrix);
            printMatrix(newMatrix); // imprime la nueva matriz
            gameOver(newMatrix);
            got2048(newMatrix);
            direcctions(newMatrix); // recursividad (funcion se llama a si misma)
        }

    }

    public static int [][] moveTop(int[][] matrix){
    	for(int moves = 0; moves < 3; moves++) { // en cada ciclo se mueven todas las lineas una vez
    		for (int row = 1; row < matrix.length; row++) {
                for (int column = 0; column < matrix.length; column++) {
                    if(matrix[row][column] != 0 && matrix[row-1][column] == 0) {
                        matrix[row-1][column] = matrix[row][column];
                        matrix[row][column] = 0;
                    }
                    else if (matrix[row][column] != 0 && matrix[row-1][column] == matrix[row][column]){
                        matrix[row-1][column] = 2 * (matrix[row][column]);
                        matrix[row][column] = 0;
                    }
                }
            }
    	}
    	return matrix;
    }

    public static int [][] moveDown(int[][] matrix){
        for(int moves = 0; moves < 3; moves++) { // en cada ciclo se mueven todas las lineas una vez
            for (int row = 2; row >= 0; row--) {
                for (int column = 0; column < matrix.length; column++) {
                    if(matrix[row][column] != 0 && matrix[row+1][column] == 0) {
                        matrix[row+1][column] = matrix[row][column];
                        matrix[row][column] = 0;
                    }
                    else if (matrix[row][column] != 0 && matrix[row+1][column] == matrix[row][column]){
                        matrix[row+1][column] = 2 * (matrix[row][column]);
                        matrix[row][column] = 0;
                    }
                }
            }
        }
        return matrix;
    }

    public static int [][] moveLeft(int[][] matrix){
        for(int moves = 0; moves < 3; moves++) { // en cada ciclo se mueven todas las lineas una vez
            for (int column = 1; column < matrix.length; column++) {
                for (int row = 0; row < matrix.length; row++) {
                    if(matrix[row][column] != 0 && matrix[row][column-1] == 0) {
                        matrix[row][column-1] = matrix[row][column];
                        matrix[row][column] = 0;
                    }
                    else if (matrix[row][column] != 0 && matrix[row][column-1] == matrix[row][column]){
                        matrix[row][column-1] = 2 * (matrix[row][column]);
                        matrix[row][column] = 0;
                    }
                }
            }
        }
        return matrix;
    }

    public static int [][] moveRigth(int[][] matrix){
        for(int moves = 0; moves < 3; moves++) { // en cada ciclo se mueven todas las lineas una vez
            for (int column = 2; column >= 0; column--) {
                for (int row = 0; row < matrix.length; row++) {
                    if(matrix[row][column] != 0 && matrix[row][column+1] == 0) {
                        matrix[row][column+1] = matrix[row][column];
                        matrix[row][column] = 0;
                    }
                    else if (matrix[row][column] != 0 && matrix[row][column+1] == matrix[row][column]){
                        matrix[row][column+1] = 2 * (matrix[row][column]);
                        matrix[row][column] = 0;
                    }
                }
            }
        }
        return matrix;
    }

    public static void gameOver(int[][] matrix) {
        Integer countZeros = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix.length; column++) {
                if (matrix[row][column] == 0){
                    countZeros++;
                }
            }
        }
        Boolean verifySideUp = verifySideUp(matrix);
        Boolean verifySideLeft = verifySideLeft(matrix);

        if (countZeros == 0 && !(verifySideUp) && !(verifySideLeft) ){
            System.out.println("Game Over");
            System.exit(0);
        }
    }

    public static Boolean verifySideUp(int[][] matrix) {
        boolean check = false;
        for (int row = 1; row < matrix.length; row++) {
            for (int column = 0; column < matrix.length; column++) {
                if (matrix[row][column] == matrix[row-1][column]){
                    check = true;
                }
            }
        }
        return check;
    }

    public static Boolean verifySideLeft(int[][] matrix) {
        boolean check = false;
        for (int column = 1; column < matrix.length; column++) {
            for (int row = 0; row < matrix.length; row++) {
                if (matrix[row][column] == matrix[row][column-1]){
                    check = true;
                }
            }
        }
        return check;
    }

    public static void got2048(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix.length; column++) {
                if (matrix[row][column] == 2048) {
                    System.out.println("Congratulations");
                }
            }
        }
    }
}
