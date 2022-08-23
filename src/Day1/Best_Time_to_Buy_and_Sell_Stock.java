package Day1;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/best-time-to-buyBest%20Time%20to%20Buy%20and%20Sell%20Stockand-sell-stock/
public class Best_Time_to_Buy_and_Sell_Stock {
    public static void main(String[] args) {
        int[] testCase1 = {7, 1, 5, 3, 6, 4};    //Expected - 5
        int[] testCase2 = {7, 6, 4, 3, 1};      //Expected - 0

        System.out.println(bruteForce(testCase1));
        System.out.println(bruteForce(testCase2));
        System.out.println();
        System.out.println(singlePass(testCase1));
        System.out.println(singlePass(testCase2));
        System.out.println();
        System.out.println(recursiveTLE(testCase1, 0, testCase1.length-1));
        System.out.println(recursiveTLE(testCase2, 0, testCase2.length-1));
        System.out.println();

        Map<String,Integer> map = new HashMap<>();
        System.out.println(memo(testCase1,0,testCase1.length-1,map));
        map.clear();
        System.out.println(memo(testCase2,0,testCase2.length-1,map));
    }

    public static int bruteForce(int[] prices) {
        int maxProfit = 0;
        int n = prices.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (prices[j] > prices[i]) {
                    maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
                }
            }
        }
        return maxProfit;
    }

    public static int singlePass(int[] prices) {
        int maxProfit = 0;
        int n = prices.length;
        if (n <= 1)
            return maxProfit;

        int sell = prices[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            if (prices[i] < sell) {
                maxProfit = Math.max(maxProfit, sell - prices[i]);
            } else
                sell = prices[i];
        }

        return maxProfit;

    }

    public static int recursiveTLE(int[] prices, int buy, int sell) {
        //only 1 element left or no elements left
        if (buy >= sell)
            return 0;

        int profit = prices[sell] - prices[buy];

        return Math.max(Math.max(profit, 0), Math.max(recursiveTLE(prices, buy + 1, sell), recursiveTLE(prices, buy, sell - 1)));
    }

    public static int memo(int[] prices, int buy, int sell, Map<String, Integer> map) {
        //only 1 element left or no elements left
        String state = buy + "-" + sell;
        if (map.containsKey(state)) {
            return map.get(state);
        }

        if (buy >= sell)
            return 0;

        int profit = prices[sell] - prices[buy];

        int result = Math.max(Math.max(profit, 0), Math.max(memo(prices, buy + 1, sell, map), memo(prices, buy, sell - 1, map)));
        map.put(state, result);
        return result;
    }
}

