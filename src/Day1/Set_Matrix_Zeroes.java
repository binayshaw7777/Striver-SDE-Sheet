package Day1;
//Leetcode: https://leetcode.com/problems/set-matrix-zeroes/

import java.util.Arrays;

public class Set_Matrix_Zeroes {
    public static void main(String[] args) {
        int[][] matrix1 = {{1,1,1},{1,0,1},{1,1,1}};            //Expected Output: [[1,0,1],[0,0,0],[1,0,1]]
        int[][] matrix2 = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};      //Expected Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]

        printMatrix(matrix1);
        printMatrix(matrix2);

        setZeroes(matrix1);
        setZeroes(matrix2);

        System.out.println();
        printMatrix(matrix1);
        printMatrix(matrix2);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] arr : matrix) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void setZeroes(int[][] matrix) {
        if (matrix[0].length == 0 || matrix == null) return;
        int row = matrix.length, col = matrix[0].length, col0 = 0;

        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) col0 = 1;
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j > 0; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (col0 == 1) matrix[i][0] = 0;
        }
    }
}
