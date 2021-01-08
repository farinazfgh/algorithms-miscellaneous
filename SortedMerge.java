public class SortedMerge {
    static int[] biggerArray = {0, 2, 4, 6, 8, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    static int[] smallerArray = {1, 3, 5, 7, 9};

    static void mergeSorted() {
        int i = smallerArray.length - 1, j = biggerArray.length - 1;
        for (; biggerArray[j] == 0; j--) ;

        int k = biggerArray.length - 1;
        while (i >= 0) {
            if (biggerArray[j] >= smallerArray[i]) {
                biggerArray[k--] = biggerArray[j--];
            } else {
                biggerArray[k--] = smallerArray[i--];
            }
        }
        while (j >= 0) biggerArray[k--] = biggerArray[j--];

    }

    static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " , ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        mergeSorted();
        printArray(biggerArray);

    }
}
