import java.util.ArrayList;
import java.util.List;

public class KthPermutation {
    static void findKthPermutation(List<Character> characters, int k, StringBuilder result) {
        if (characters.isEmpty()) return;

        int n = characters.size();

        int factorial = factorialIterative(n - 1);
        System.out.println("factorial:" + factorial);

        int toSelect = (k - 1) / factorial;
        System.out.println("toSelect:" + toSelect);

        result.append(characters.get(toSelect));
        System.out.println("result:" + result);
        characters.remove(toSelect);

        System.out.println("characters:" + characters);
        k = k - (factorial * toSelect);
        System.out.println("new k:" + k);
        findKthPermutation(characters, k, result);
    }

    static String getPermutation(int n, int k) {
        List<Character> characters = new ArrayList<>();
        char c = '1';
        for (int i = 1; i <= n; ++i) {
            characters.add(c);
            c++;
        }
        System.out.println("permutation" + characters);
        StringBuilder result = new StringBuilder();
        findKthPermutation(characters, k, result);
        return result.toString();
    }

    static int factorialIterative(int n) {
        if (n == 1) return 1;
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("8th permutation of 1234 = " + getPermutation(5, 17));
    }
}
