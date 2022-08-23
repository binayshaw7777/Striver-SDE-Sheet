package Day2;

import java.util.Arrays;

//https://leetcode.com/problems/rotate-image/
public class RotateImage {
    public static void main(String[] args) {
        int[][] testCase1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};  //Output- [[7,4,1],[8,5,2],[9,6,3]]
        int[][] testCase2 = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}}; //Output - [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]

        rotate(testCase1);
        rotate(testCase2);

        printMatrix(testCase1);
        printMatrix(testCase2);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] arr : matrix)
            System.out.println(Arrays.toString(arr));
        System.out.println();
    }

    public static void rotate(int[][] matrix) {
        int size = matrix.length;
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][size - 1 - j];
                matrix[i][size - 1 - j] = temp;
            }
        }
    }
}
