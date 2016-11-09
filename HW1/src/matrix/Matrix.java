package matrix;

/**
 * Operations with matrices
 */
public class Matrix {

    /** Принимает двумерный массив-матрицу и выполняет транспонирование этой матрицы с выводом результата */
    public static int[][] transpose(int[][] matrix) {
        int lengthMatrix = matrix.length;
        int heightMatrix = matrix[0].length;

        int[][] transposedMatrix = new int[heightMatrix][lengthMatrix];

        for (int i = 0; i < heightMatrix; i++) {
            for (int j = 0; j < lengthMatrix; j++) {
                transposedMatrix[i][j] = matrix[j][i];
            }
        }

        return transposedMatrix;
    }

    /** Принимает две матрицы, выводит на экран результат умножения первой матрицы на вторую */
    public static int[][] multiply(int[][] matrixOne, int[][] matrixTwo) throws Exception {
        int lengthMatrixOne = matrixOne.length;
        int heightMatrixOne = matrixOne[0].length;

        int lengthMatrixTwo = matrixTwo.length;
        int heightMatrixTwo = matrixTwo[0].length;

        if (lengthMatrixOne != heightMatrixTwo) {
            throw new Exception();
        }

        int[][] productMatrix = new int[lengthMatrixTwo][heightMatrixOne];

        for (int i = 0; i < lengthMatrixTwo; i++) {
            for (int j = 0; j < heightMatrixOne; j++) {
                productMatrix[i][j] = 0;
                for (int k = 0; k < lengthMatrixOne; k++) {
                    productMatrix[i][j] += matrixOne[k][i] * matrixTwo[j][k];
                }
            }
        }

        return productMatrix;
    }

    /** Выводит двумерную матрицу на экран */
    public static void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.format("%5d ", matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {

        int[][] matrix1 = new int[][]{{1, 3, 2, 5}, {2, 6, 4, 46}, {4, 5, 8, 43}};
        Matrix.print(matrix1);

        /**
         * int[][] matrix2 = Matrix.transpose(matrix1);
         * Matrix.print(matrix2);
        */

        int[][] matrix2 = new int[][]{{1, 5, 63}, {34, 3, 55}, {24, 66, 23}, {5, 7, 9}};
        int[][] matrix3 = Matrix.multiply(matrix1, matrix2);
        Matrix.print(matrix3);

    }

}
