package Day2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Find_The_Duplicate_Number {
    public static void main(String[] args) {
        //Expected 2
        int[] testCase1 = {1, 3, 4, 2, 2};

        //Expected 3
        int[] testCase2 = {3, 1, 3, 4, 2};

        //Set - Hashing
        System.out.println(findDuplicate1(testCase1));
        System.out.println(findDuplicate1(testCase2));

        //Nested For-loop
        System.out.println("\n" + findDuplicate2(testCase1));
        System.out.println(findDuplicate2(testCase2));

        //Circular LL method
        System.out.println("\n" + findDuplicate3(testCase1));
        System.out.println(findDuplicate3(testCase2));

        //Sorting
        System.out.println("\n" + findDuplicate4(testCase1));
        System.out.println(findDuplicate4(testCase2));
    }

    private static int findDuplicate3(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        fast = nums[0];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    private static int findDuplicate4(int[] nums) {
        int size = nums.length;
        if (size < 2) return -1;
        Arrays.sort(nums);
        for (int i = 1; i < size; i++)
            if (nums[i] == nums[i - 1])
                return nums[i];

        return -1;
    }

    private static int findDuplicate2(int[] nums) {
        int size = nums.length;
        if (size < 2) return -1;
        for (int i = 0; i < size; i++)
            for (int j = i + 1; j < size; j++)
                if (nums[i] == nums[j])
                    return nums[i];

        return -1;
    }

    public static int findDuplicate1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.contains(i))
                return i;
            set.add(i);
        }
        return -1;
    }
}
