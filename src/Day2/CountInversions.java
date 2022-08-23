package Day2;

import java.util.Arrays;

public class CountInversions {
    public static void main(String[] args) {
        int[] testCase1 = {2, 4, 1, 3, 5};  //3
        int[] testCase2 = {2, 3, 4, 5, 6};  //0
        int[] testCase3 = {10, 10, 10};     //0
        int[] testCase4 = {1, 2, 3, 4, 5};  //0
        int[] testCase5 = {5, 4, 3, 2, 1};  //10
        int[] testCase6 = {5, 3, 2, 1, 4};  //7


        System.out.println(countInverse(testCase1));
        System.out.println(countInverse(testCase2));
        System.out.println(countInverse(testCase3));
        System.out.println(countInverse(testCase4));
        System.out.println(countInverse(testCase5));
        System.out.println(countInverse(testCase6));
    }

//    private static int countInverse(int[] nums) {
//        int counter = 0, size = nums.length;
//        if (size < 2) return 0;
//
//        for (int i = 0; i < size; i++) {
//            for (int j = i + 1; j < size; j++) {
//                if (nums[i] > nums[j])
//                    counter++;
//            }
//        }
//
//        return counter;
//    }

    private static int countInverse(int a[]) {
        return dividint(0, a.length - 1, a);
    }

    private static int dividint(int x, int y, int a[]) {
        int c = 0;
        if (x < y) {
            int m = (x + y) / 2;
            c += dividint(x, m, a);
            c += dividint(m + 1, y, a);
            c += mergint(x, m, y, a);
        }
        return c;
    }

    static int mergint(int x, int m, int y, int a[]) {
        int c = 0;
        int[] L = Arrays.copyOfRange(a, x, m + 1);
        int[] R = Arrays.copyOfRange(a, m + 1, y + 1);
        int i = 0, j = 0, k = x;
        while (i < L.length && j < R.length) {
            if (L[i] <= R[j]) a[k++] = L[i++];
            else {
                a[k++] = R[j++];
                c += m + 1 - (x + i);
            }
        }
        while (i < L.length) a[k++] = L[i++];
        while (j < R.length) a[k++] = R[j++];
        return c;
    }
}
