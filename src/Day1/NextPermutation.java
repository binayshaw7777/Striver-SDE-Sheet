package Day1;
//  https://leetcode.com/problems/next-permutation/
import java.util.Scanner;

public class NextPermutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   //Size of the array
        int[] permutation = new int[n]; //Permutation array

        for (int i = 0; i < n; i++) {
            permutation[i] = sc.nextInt();
        }

        System.out.println(printArray(nextPermutation(permutation)));
    }

    private static String printArray(int[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int i : nums) {
            sb.append(i);
        }
        return sb.toString();
    }

    private static int[] nextPermutation(int[] nums) {
        int size = nums.length;
        if (nums == null || size <= 1) return nums;

        int i = size - 2;

        while (i >= 0 && nums[i] >= nums[i+1])
            i--;

        if (i > 0) {
            int j = size - 1;
            while (nums[j] < nums[i])
                j--;
            swap(nums, i, j);
        }
        reverse(nums, i+1, size-1);

        return nums;
    }

    private static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
