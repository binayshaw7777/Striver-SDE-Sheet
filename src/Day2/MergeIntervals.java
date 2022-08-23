package Day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] testCase1 = {{1,3},{2,6},{8,10},{15,18}}; //Output - [[1,6],[8,10],[15,18]]
        int[][] testCase2 = {{1,4},{4,5}}; //Output - [[1,5]]

        testCase1 = merge(testCase1);
        testCase2 = merge(testCase2);

        printArray(testCase1);
        printArray(testCase2);
    }

    private static void printArray(int[][] arr) {
        System.out.print("[");
        for (int[] i : arr)
            System.out.print(Arrays.toString(i));
        System.out.print("]\n");
    }

    public static int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();

        if (intervals.length == 0 || intervals == null)
            return list.toArray(new int[0][]);

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int[] i : intervals) {
            if (i[0] <= end) {
                end = Math.max(end, i[1]);
            } else {
                list.add(new int[] {start, end});
                start = i[0];
                end = i[1];
            }
        }
        list.add(new int[]{start, end});
        return list.toArray(new int[0][]);
    }
}
