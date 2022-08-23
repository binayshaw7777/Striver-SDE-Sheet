package Day2;

import java.util.Arrays;

public class MergeSortedArrays {
    public static void main(String[] args) {
        int[] testCase1_nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] testCase2_nums2 = {2, 5, 6};
        int n = 3;

//        merge1(testCase1_nums1, m, testCase2_nums2, n);
        merge2(testCase1_nums1, m, testCase2_nums2, n);
        System.out.println(Arrays.toString(testCase1_nums1));
    }

    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[i - m];
        }
        Arrays.sort(nums1);
    }

    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int mPoint = m - 1, nPoint = n - 1, i = m + n - 1;
        while (nPoint >= 0) {
            if (mPoint >= 0 && nums1[mPoint] > nums2[nPoint])
                nums1[i--] = nums1[mPoint--];
            else
                nums1[i--] = nums2[nPoint--];
        }
    }
}
