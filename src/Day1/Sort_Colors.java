package Day1;

import java.util.Arrays;

public class Sort_Colors {
    public static void main(String[] args) {
        int[] testCase1 = {2, 0, 2, 1, 1, 0};      //Expected: [0,0,1,1,2,2]
        int[] testCase2 = {2, 0, 1};            //Expected: [0,1,2]
        int[] testCase1_Copy = testCase1.clone();
        int[] testCase2_Copy = testCase2.clone();

        sortColors1(testCase1_Copy);
        sortColors1(testCase2_Copy);

        System.out.println(Arrays.toString(testCase1_Copy));
        System.out.println(Arrays.toString(testCase2_Copy));

        sortColors2(testCase1);
        sortColors2(testCase2);

        System.out.println();
        System.out.println(Arrays.toString(testCase1));
        System.out.println(Arrays.toString(testCase2));
    }

    //TC: O(N logN)     SC: O(N)
    public static void sortColors1(int[] nums) {       //Uses Internal Sorting method
        Arrays.sort(nums);
    }

    //TC: O(N)      SC: O(1)
    public static void sortColors2(int[] nums) {
        int zero = 0, one = 0, two = nums.length - 1, temp;

        while (one <= two) {
            switch (nums[one]) {
                case 0 -> {
                    temp = nums[one];
                    nums[one] = nums[zero];
                    nums[zero] = temp;
                    zero++;
                    one++;
                }
                case 1 -> {
                    one++;
                }
                case 2 -> {
                    temp = nums[one];
                    nums[one] = nums[two];
                    nums[two] = temp;
                    two--;
                }
            }
        }
    }
}
