package Day3;

public class Search_In_A_2D_Matrix {
    public static void main(String[] args) {
        int[][] testCase1 = {{1, 3, 5, 7}, {10, 11, 16, 20}, {3, 30, 34, 60}};
        int target1 = 3;    //True
        int target2 = 13;   //False

        System.out.println(searchMatrix(testCase1, target1));
        System.out.println(searchMatrix(testCase1, target2));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix[0].length, col = matrix.length;
        int low = 0, high = row * col - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int current = matrix[mid / col][mid % col];
            if (current == target)
                return true;
            else if (current > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}
