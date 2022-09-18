package Day3;

import java.util.Scanner;

public class Pow_XN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x = sc.nextDouble();
        int n = sc.nextInt();
        System.out.println(myPow(x, n));
    }

    public static double myPow(double x, int n) {
        if(n==1) return x;
        else if(n==0) return 1.0;

        double ans = 1.0;
        long copyN = n;
        if (copyN < 0) copyN = -1 * copyN;

        while (copyN > 0) {
            if (copyN % 2 != 0) {
                ans *= x;
                --copyN;
            } else {
                x *= x;
                copyN /= 2;
            }
        }
        if (n < 0)
            return 1.0 / ans;
        return ans;
    }
}
