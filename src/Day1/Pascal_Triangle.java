package Day1;

import java.util.ArrayList;
import java.util.List;

public class Pascal_Triangle {
    public static void main(String[] args) {
        int testCase1 = 5; //Output - [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
        int testCase2 = 1; //Output - [[1]]

        List<List<Integer>> ans = generate(testCase1);
        System.out.println(ans);
        ans = generate(testCase2);
        System.out.println("\n" + ans);
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> row, prev = null;

        for (int i = 0; i < numRows; i++) {
            row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || i == j) {
                    row.add(1);
                } else {
                    row.add(prev.get(j - 1) + prev.get(j));
                }
            }
            prev = row;
            triangle.add(row);
        }

        return triangle;
    }
}
