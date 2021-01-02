public class InsertionSort {

    public static void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }


    static void swap(int[] array, int i, int j) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

    public static void main(String[] args) {
        int[] array = {10, 6, -3, 23, -1, 67, 9, 10, 34, 23};
        sort(array);
        for (int value : array) System.out.print(value + ", ");
        System.out.println();

    }
}
