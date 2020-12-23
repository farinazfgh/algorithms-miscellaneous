public class KnapsackUnbounded {

    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        return this.knapsackRecursive(profits, weights, capacity, 0);
    }

    private int knapsackRecursive(int[] profits, int[] weights, int capacity, int currentIndex) {
        if (capacity <= 0 || profits.length == 0 || weights.length != profits.length ||
                currentIndex >= profits.length)
            return 0;

        // recursive call after choosing the items at the currentIndex, note that we recursive call on all
        // items as we did not increment currentIndex
        int profit1 = 0;
        //only include is changed instead of index+1, we use index, it means that we include it again in the next round
        if (weights[currentIndex] <= capacity)
            profit1 = profits[currentIndex]
                    + knapsackRecursive(profits, weights, capacity - weights[currentIndex], currentIndex);

        // recursive call after excluding the element at the currentIndex; exclude stays the same, since it is excluding the current item
        //anyway, (index+1)
        int profit2 = knapsackRecursive(profits, weights, capacity, currentIndex + 1);

        return Math.max(profit1, profit2);
    }

    public static void main(String[] args) {
        KnapsackUnbounded ks = new KnapsackUnbounded();
        int[] profits = {15, 50, 60, 90};
        int[] weights = {1, 3, 4, 5};
        int maxProfit = ks.solveKnapsack(profits, weights, 8);
        System.out.println(maxProfit);
    }
}