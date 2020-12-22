public class BinarySearch {

    static int recursiveBinarySearch(int[] array, int low, int high, int key) {
        if (array.length == 0) return -1;
        if (low > high) return -1;

        int mid = (low + high) / 2;
        if (array[mid] == key) return mid;
        if (key < array[mid]) return recursiveBinarySearch(array, low, mid - 1, key);
        return recursiveBinarySearch(array, mid + 1, high, key);
    }

    static int iterativeBinarySearch(int[] array, int key) {
        if (array.length == 0) return -1;

        int low = 0;
        int high = array.length - 1;
        while (low <= high) {

            int mid = (low + high) / 2;

            if (array[mid] == key) return mid;
            if (key < array[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array1 = {};
        int[] array2 = {1};
        int[] array3 = {1, 2};
        int[] array4 = {1, 2, 3};
        System.out.println(recursiveBinarySearch(array1, 0, array1.length - 1, 1));
        System.out.println(recursiveBinarySearch(array2, 0, array2.length - 1, 1));
        System.out.println(recursiveBinarySearch(array2, 0, array2.length - 1, 2));
        System.out.println(recursiveBinarySearch(array3, 0, array3.length - 1, 1));
        System.out.println(recursiveBinarySearch(array3, 0, array3.length - 1, 3));
        System.out.println(recursiveBinarySearch(array4, 0, array4.length - 1, 3));
        System.out.println(recursiveBinarySearch(array4, 0, array4.length - 1, 0));

        System.out.println(iterativeBinarySearch(array1, 1));
        System.out.println(iterativeBinarySearch(array2, 1));
        System.out.println(iterativeBinarySearch(array2, 2));
        System.out.println(iterativeBinarySearch(array3, 1));
        System.out.println(iterativeBinarySearch(array3, 3));
        System.out.println(iterativeBinarySearch(array4, 3));
        System.out.println(iterativeBinarySearch(array4, 0));

    }

}