import java.util.ArrayList;
import java.util.Arrays;

public class AllCombinationsOfTargetSum {
    static String print(ArrayList<ArrayList<Integer>> arr) {
        String result = "";
        for (ArrayList<Integer> integers : arr) {
            result += "[";
            for (Integer integer : integers) {
                result += (integer) + ",";
            }
            result = result.replaceAll(",$", "");
            result += "]";
        }
        return result;
    }


    static void getAllPossibleSumRec(int targetSum
            , int currentSum
            , int index
            , ArrayList<ArrayList<Integer>> finalResult
            , ArrayList<Integer> levelResult) {
        System.out.println("current sum: " + currentSum + " index:" + index);

        if (targetSum == currentSum) {
            ArrayList<Integer> copyLevelResult = new ArrayList<>(levelResult);
            finalResult.add(copyLevelResult);
            System.out.println("-----------------");
        }

        for (int i = index; i < targetSum; ++i) {
            int tempSum = currentSum + i;
            if (tempSum <= targetSum) {
                levelResult.add(i);
                getAllPossibleSumRec(targetSum, tempSum, i, finalResult, levelResult);
                levelResult.remove(levelResult.size() - 1);
            } else {
                return;
            }
        }
    }

    static ArrayList<ArrayList<Integer>> allCombinationsOfSum(int targetSum) {
        ArrayList<ArrayList<Integer>> finalResult = new ArrayList<>();
        ArrayList<Integer> levelResult = new ArrayList<>();
        getAllPossibleSumRec(targetSum, 0, 1, finalResult, levelResult);
        return finalResult;
    }

    static void sum_up_recursive(ArrayList<Integer> numbers, int target, ArrayList<Integer> partial) {
        int s = 0;
        for (int x : partial) s += x;
        if (s == target)
            System.out.println("sum(" + Arrays.toString(partial.toArray()) + ")=" + target);
        if (s >= target)
            return;
        for (int i = 0; i < numbers.size(); i++) {
            ArrayList<Integer> remaining = new ArrayList<Integer>();
            int n = numbers.get(i);
            for (int j = i + 1; j < numbers.size(); j++) remaining.add(numbers.get(j));
            ArrayList<Integer> partial_rec = new ArrayList<Integer>(partial);
            partial_rec.add(n);
            sum_up_recursive(remaining, target, partial_rec);
        }
    }

    static void sum_up(ArrayList<Integer> numbers, int target) {
        sum_up_recursive(numbers, target, new ArrayList<Integer>());
    }
 /*
    public static void main(String args[]) {
        Integer[] numbers = {3, 9, 8, 4, 5, 7, 10};
        int target = 15;
        sum_up(new ArrayList<Integer>(Arrays.asList(numbers)), target);
    }*/

    public static void main(String[] args) {
        int n = 4;
        ArrayList<ArrayList<Integer>> result = allCombinationsOfSum(n);
        System.out.println("All sum combinations of " + n);
        System.out.println(print(result));
    }
}  