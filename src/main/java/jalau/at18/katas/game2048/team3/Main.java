package jalau.at18.katas.game2048.team3;

public class Main {
    
    public static void main(String[] args) {
        // Scanner scan = new Scanner(System.in);
        int[][] matrix = {{2,0,2,0},
                          {0,0,2,2},
                          {2,2,2,2},
                          {2,0,2,2}};
        // double randomNumber = Math.random()*1;
        // double [] randomNumbers = {2, 4};
        // showMatrix(matrix);
        upMove(matrix);
    }

    public static void rightMove(int[][] matrix) {
        for (int i = 0; i < 4; i++) {
            for (int j = 3; j >= 0; j--) {
                if(matrix[i][j]!=0){
                    for (int j2 = j-1; j2 >=0; j2--) {
                        if(matrix[i][j2]!=0 && matrix[i][j]==matrix[i][j2]){
                            matrix[i][j]+=matrix[i][j2];
                            matrix[i][j2]=0;
                        } 
                    }
                }

                // System.out.print(matrix[i][j]);
            }
            // System.out.println();
            
        }
        arrangeRight(matrix);
        // {2,2,2,0}    // {0,0,4,0}   {0,0,2,4}    {4,2,0,0} 
        // {0,0,2,2}
        // {2,2,2,2}    // {0,4,0,4} // {0,0,4,4}
        // {2,0,2,2}    // {2,0,0,4} // {0,0,2,4}

        // {0,0,0,4}
        // {0,0,0,4}
        // {0,0,4,4}
        // {0,0,2,4}
    }
    public static void arrangeRight(int[][] matrix) {
        for(int i = 0; i < 4 ; i++) {
            for(int j =0; j < 4 ; j++) {
                if(matrix[i][j]==0){
                    for (int j2 = j-1; j2 >=0; j2--) {
                        if(matrix[i][j2]!=0){
                            matrix[i][j] = matrix[i][j2];
                            matrix[i][j2] = 0;
                        } 
                    }
                }
            }
        }
        showMatrix(matrix);
    }
    
    public static void downMove(int[][] matrix) {

    }
    public static void leftMove(int[][] matrix) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4 ; j++) {
                if(matrix[i][j]!=0){
                    for (int j2 = j+1; j2 <4; j2++) {
                        if(matrix[i][j2]!=0 && matrix[i][j]==matrix[i][j2]){
                            matrix[i][j]+=matrix[i][j2];
                            matrix[i][j2]=0;
                        } 
                    }
                }

                // System.out.print(matrix[i][j]);
            }
            // System.out.println();
            
        }
        arrangeLeft(matrix);
    }
    public static void arrangeLeft(int[][] matrix) {
        for(int i = 0; i < 4 ; i++) {
            for(int j =0; j < 4 ; j++) {
                if(matrix[i][j]==0){
                    for (int j2 = j+1; j2 < 4; j2++) {
                        if(matrix[i][j2]!=0){
                            matrix[i][j] = matrix[i][j2];
                            matrix[i][j2] = 0;
                        } 
                    }
                }
            }
        }
        showMatrix(matrix);
    }


    public static void upMove(int[][] matrix) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if(matrix[j][i]!=0) {
                    int j2 = j+1;
                    if (matrix[j2][i] != 0 && matrix[j][i] == matrix[j2][i]) {
                        matrix[j][i] += matrix[j2][i];
                        matrix[j2][i] = 0;
                    } else {
                        if (matrix[j2][i] == 0) {
                            matrix[j2][i] = matrix[j][i];
                            matrix[j][i] = 0;
                        }
                    }
                }
            }
        }
        orderUp(matrix);
    }

    public static void orderUp(int[][] matrix) {
        for(int i = 0; i < 4 ; i++) {
            for(int j =0; j < 4 ; j++) {
                if(matrix[j][i]==0){
                    for (int j2 = j+1; j2 < 4; j2++) {
                        if(matrix[j2][i]!=0){
                            matrix[j][i] = matrix[j2][i];
                            matrix[j2][i] = 0;
                            break;
                        }
                    }
                }
            }
        }
        showMatrix(matrix);
    }


    // public static int[][] showMatrix(int[][] matrix){
    public static void showMatrix(int[][] matrix) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
