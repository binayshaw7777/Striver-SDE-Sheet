package Day4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/two-sum/
public class TwoSum {
    public static void main(String[] args) {
        int[] testCase1 = {2, 7, 11, 15};  //Expected [0, 1]
        int target1 = 9;
        int[] testCase2 = {3, 2, 4};      //Expected [1, 2]
        int target2 = 6;

        System.out.println(Arrays.toString(twoSum1(testCase1, target1)));
        System.out.println(Arrays.toString(twoSum1(testCase2, target2)) + "\n");

        System.out.println(Arrays.toString(twoSum2(testCase1, target1)));
        System.out.println(Arrays.toString(twoSum2(testCase2, target2)));

    }

    private static int[] twoSum1(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target)
                    return new int[]{i, j};
            }
        }

        return new int[]{};
    }

    private static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int remaining = target - nums[i];
            if (map.containsKey(remaining))
                return new int[]{map.get(remaining), i};
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
