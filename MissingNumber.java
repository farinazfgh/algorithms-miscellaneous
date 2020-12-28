public class MissingNumber {
    static int missingNumberXOR(int[] array) {
        int result = 1;
        for (int value : array) {
            result ^= value;
        }
        return result;
    }

    static int missingNumber(int[] array, int n) {
        int sum = 0;
        for (int value : array) sum += value;
        return ((((n + 1) * n) / 2) - sum);
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 4, 5};
        System.out.println(missingNumberXOR(array));
        System.out.println(missingNumber(array, 5));
    }
}

