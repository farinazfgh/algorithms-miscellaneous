public class Knapsack01Tabulation {
    /*
    we want to calculate the maximum profit for every possible capacity
    dp[i][c] will represent the maximum knapsack profit for capacity ‘c’ calculated from the first ‘i’ items.
    dp[3][3] means we have included three items so far, and the capacity is 3
    decision making:
    to exclude item i:
    if we dont include i profit= dp[i-1][c]
    to include i:
    we get profits of plus what profit we will get from remaining items and remaining capacity:
    profits[i]+dp[i-1][c-weights[i]]
    dp[i][c] = max (dp[i-1][c], profits[i] + dp[i-1][c-weights[i]])
     */
    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        if (capacity <= 0 || profits.length == 0 || weights.length != profits.length)
            return 0;

        int n = profits.length;
        int[][] dp = new int[n][capacity + 1];

        // populate the capacity=0 columns, with '0' capacity we have '0' profit
        for (int i = 0; i < n; i++)
            dp[i][0] = 0;

        // if we have only one weight, we will take it if it is not more than the capacity
        for (int c = 0; c <= capacity; c++) {
            if (weights[0] <= c)
                dp[0][c] = profits[0];
        }

        // process all sub-arrays for all the capacities
        for (int i = 1; i < n; i++) {
            for (int c = 1; c <= capacity; c++) {
                int profit1 = 0, profit2 = 0;
                // include the item, if it is not more than the capacity
                if (weights[i] <= c)
                    profit1 = profits[i] + dp[i - 1][c - weights[i]];
                // exclude the item
                profit2 = dp[i - 1][c];
                // take maximum
                dp[i][c] = Math.max(profit1, profit2);
            }
        }

        // maximum profit will be at the bottom-right corner.
        printSelectedElements(dp, weights, profits, capacity);
        return dp[n - 1][capacity];
    }

    private void printSelectedElements(int dp[][], int[] weights, int[] profits, int capacity) {
        System.out.print("Selected weights:");
        int totalProfit = dp[weights.length - 1][capacity];
        for (int i = weights.length - 1; i > 0; i--) {
            if (totalProfit != dp[i - 1][capacity]) {
                System.out.print(" " + weights[i]);
                capacity -= weights[i];
                totalProfit -= profits[i];
            }
        }

        if (totalProfit != 0)
            System.out.print(" " + weights[0]);
        System.out.println("");
    }

    public static void main(String[] args) {
        Knapsack01Tabulation ks = new Knapsack01Tabulation();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = ks.solveKnapsack(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsack(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }
}
