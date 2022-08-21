package Day1;

public class Maximum_Subarray {
    public static void main(String[] args) {
        int[] testCase1 = {-2,1,-3,4,-1,2,1,-5,4};      //Expected = 6
        int[] testCase2 = {1};                          //Expected = 1
        int[] testCase3 = {5,4,-1,7,8};                 //Expected = 23
        int[] testCase4 = {-1};                         //Expected = -1


        System.out.println(maxSubArray(testCase1));
        System.out.println(maxSubArray(testCase2));
        System.out.println(maxSubArray(testCase3));
        System.out.println(maxSubArray(testCase4));
    }
    public static int maxSubArray(int[] nums) {
        int total = Integer.MIN_VALUE, temp = 0;
        for (int i : nums) {
            temp = Math.max(i, i + temp);
            total = Math.max(total, temp);
        }
        return total;
    }
}
