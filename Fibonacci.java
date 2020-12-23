public class Fibonacci {

    public int CalculateFibonacciMemoization(int n) {
        int memoize[] = new int[n + 1];
        return CalculateFibonacciRecursive(memoize, n);
    }

    public int CalculateFibonacciRecursive(int[] memoize, int n) {
        if (n < 2)
            return n;

        // if we have already solved this subproblem, simply return the result from the cache
        if (memoize[n] != 0)
            return memoize[n];
        //notice there is no global variable the recursive function is self contained it means that we rely on arguments and return values
        //arguments: data that should be shared
        //return value data that must be added up
        memoize[n] = CalculateFibonacciRecursive(memoize, n - 1) + CalculateFibonacciRecursive(memoize, n - 2);
        return memoize[n];
    }

    public int CalculateFibonacciTabulation(int n) {
        if (n == 0) return 0;
        int dp[] = new int[n + 1];

        //base cases
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++)
            dp[i] = dp[i - 1] + dp[i - 2];

        return dp[n];
    }

    public static void main(String[] args) {
        Fibonacci fib = new Fibonacci();
        System.out.println("5th Fibonacci is ---> " + fib.CalculateFibonacciMemoization(5));
        System.out.println("6th Fibonacci is ---> " + fib.CalculateFibonacciMemoization(6));
        System.out.println("7th Fibonacci is ---> " + fib.CalculateFibonacciMemoization(7));
    }
}
