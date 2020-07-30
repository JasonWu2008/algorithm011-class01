package practise;

import java.util.ArrayList;
import java.util.List;

public class FibonacciNumber {
    public static void main(String[] args) {
        int[] results = new FibonacciNumber().calcFib2(50);
        for (Integer result : results) {
            System.out.println(result);
        }
    }


    private List<Integer> calcFib(int end) {
        ArrayList<Integer> results = new ArrayList<>();
        int[] memo = new int[end];
        for (int i = 0; i < end; i++) {
            results.add(fib(i, memo));
        }
        return results;
    }

    private int[] calcFib2(int n) {
        int[] memo = new int[n + 1];
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo;
    }

    private int fib(int n, int[] memo) {
        if (n <= 1) {
            return n;
        }
        if (memo[n] == 0) {
            memo[n] = fib(n - 1, memo) + fib(n - 2, memo);
        }
        return memo[n];
    }
}
