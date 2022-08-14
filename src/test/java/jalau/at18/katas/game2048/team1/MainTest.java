package jalau.at18.katas.game2048.team1;

import org.junit.Test;
import static org.junit.Assert.*;


public class MainTest {
    private final int[][] exampleMatrix = {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, 0}, {0, 0, 0, 0}};
    private final int[][] matrixGameOver = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 1, 2, 3}, {4, 5, 9, 7}};
    private final int[][] matrixGameNoOver = {{1, 2, 3, 4}, {5, 6, 7, 0}, {9, 1, 2, 4}, {4, 5, 9, 20}};

    public static final int RANDOM_VALUE_ONE = 2;
    public static final int RANDOM_VALUE2 = 4;
    public static final int MATRIX_LENGTH = 4;
    public static final int COUNT_ZEROS = 15;


    @Test
    public void mainCountZerosMatrix() {
        Main main = new Main();
        assertEquals(COUNT_ZEROS, main.countZerosMatrix(exampleMatrix));
    }
    @Test
    public void mainGameOver() {
        Main main = new Main();
        assertEquals(true, main.isGameOver(matrixGameOver));
    }
    @Test
    public void mainGameNoOver() {
        Main main = new Main();
        assertEquals(false, main.isGameOver(matrixGameNoOver));
    }

    @Test
    public void mainRandomValue() {
        Main main = new Main();
        int num = main.randomValueGrid();
        assertTrue(num == RANDOM_VALUE_ONE || num == RANDOM_VALUE2);
    }

    @Test
    public void mainRandomPositionGrid() {
        Main main = new Main();
        int[] valuesPosition = main.randomPositionGrid();
        assertTrue(valuesPosition[0] < MATRIX_LENGTH && valuesPosition[1] < MATRIX_LENGTH);
    }

    @Test
    public void mainAddTile() {
        Main main = new Main();
        int countTiles1 = 0;
        for (int row = 0; row < exampleMatrix.length; row++) {
            for (int column = 0; column < exampleMatrix.length; column++) {
                if (exampleMatrix[row][column] != 0) {
                    countTiles1++;
                }
            }
        }
        int[][] matrixPlusTile = main.addTile(exampleMatrix);
        int countTiles2 = 0;
        for (int row = 0; row < matrixPlusTile.length; row++) {
            for (int column = 0; column < matrixPlusTile.length; column++) {
                if (matrixPlusTile[row][column] != 0) {
                    countTiles2++;
                }
            }
        }
        assertEquals(countTiles1 + 1, countTiles2);
    }

    @Test
    public void mainInitialMatrix() {
        Main main = new Main();
        int countTiles1 = 0;
        int[][] matrixInitialTest = main.initialMatrix(2, 1);
        for (int row = 0; row < matrixInitialTest.length; row++) {
            for (int column = 0; column < matrixInitialTest.length; column++) {
                if (matrixInitialTest[row][column] != 0) {
                    countTiles1++;
                }
            }
        }
        assertEquals(2, countTiles1);
    }

    @Test
    public void mainMoveTop() {
        Main main = new Main();
        final int[][] matrixTest = {{0, 0, 0, 0}, {4, 0, 0, 0}, {0, 0, 2, 0}, {0, 0, 2, 0}};
        final int[][] matrixExpected = {{4, 0, 4, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
        assertEquals(matrixExpected, main.moveTop(matrixTest));
    }

    @Test
    public void mainMoveDown() {
        Main main = new Main();
        final int[][] matrixTest = {{0, 0, 0, 0}, {4, 0, 0, 0}, {0, 0, 2, 0}, {0, 0, 2, 0}};
        final int[][] matrixExpected = {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {4, 0, 4, 0}};
        assertEquals(matrixExpected, main.moveDown(matrixTest));
    }

    @Test
    public void mainMoveLeft() {
        Main main = new Main();
        final int[][] matrixTest = {{0, 0, 0, 0}, {4, 0, 0, 0}, {0, 0, 2, 2}, {0, 0, 2, 0}};
        final int[][] matrixExpected = {{0, 0, 0, 0}, {4, 0, 0, 0}, {4, 0, 0, 0}, {2, 0, 0, 0}};
        assertEquals(matrixExpected, main.moveLeft(matrixTest));
    }
    @Test
    public void mainMoveRight() {
        Main main = new Main();
        final int[][] matrixTest = {{0, 0, 0, 0}, {4, 0, 0, 0}, {4, 4, 0, 0}, {2, 0, 0, 0}};
        final int[][] matrixExpected = {{0, 0, 0, 0}, {0, 0, 0, 4}, {0, 0, 0, 8}, {0, 0, 0, 2}};
        assertEquals(matrixExpected, main.moveRight(matrixTest));
    }
    @Test
    public void mainVerifySideRow() {
        Main main = new Main();
        final int[][] matrixTest = {{1, 2, 3, 4}, {1, 5, 6, 7}, {2, 3, 5, 7}, {9, 0, 7, 5}};
        assertEquals(true, main.canRowSlide(matrixTest));
        final int[][] matrixTest1 = {{1, 2, 3, 4}, {3, 5, 6, 9}, {2, 3, 5, 7}, {9, 0, 7, 5}};
        assertEquals(false, main.canRowSlide(matrixTest1));
    }
    @Test
    public void mainVerifySideColumn() {
        Main main = new Main();
        final int[][] matrixTest = {{1, 1, 3, 4}, {1, 5, 6, 7}, {2, 3, 5, 7}, {9, 0, 7, 5}};
        assertEquals(true, main.canColumnSlide(matrixTest));
        final int[][] matrixTest1 = {{1, 2, 3, 4}, {3, 5, 6, 9}, {2, 3, 5, 7}, {9, 0, 7, 5}};
        assertEquals(false, main.canColumnSlide(matrixTest1));
    }
    @Test
    public void mainGot2048() {
        Main main = new Main();
        final int[][] matrixTest = {{0, 0, 0, 0}, {4, 0, 2048, 0}, {4, 4, 0, 0}, {2, 0, 0, 0}};
        assertEquals(true, main.got2048(matrixTest));
        final int[][] matrixTest1 = {{0, 0, 0, 0}, {4, 0, 0, 0}, {4, 4, 0, 0}, {2, 0, 0, 0}};
        assertEquals(false, main.got2048(matrixTest1));
    }

}
