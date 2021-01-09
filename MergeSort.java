public class MergeSort {


    static void mergeSort(int[] array, int[] aux, int leftStart, int rightEnd) {
        if (leftStart >= rightEnd) return;
        int middle = (rightEnd - leftStart) / 2 + leftStart;
        mergeSort(array, aux, leftStart, middle);
        mergeSort(array, aux, middle + 1, rightEnd);
        mergeHalves(array, leftStart, rightEnd, aux);
    }

    private static void mergeHalves(int[] array, int leftStart, int rightEnd, int[] aux) {
        int leftEnd = (rightEnd + leftStart) / 2;
        int rightStart = leftEnd + 1;
        int size = rightEnd - leftStart + 1;
        int left = leftStart;
        int right = rightStart;
        int index = leftStart;
        while (left <= leftEnd && right <= rightEnd) {
            if (array[left] <= array[right])
                aux[index++] = array[left++];
            else aux[index++] = array[right++];
        }
        System.arraycopy(array, left, aux, index, leftEnd - left + 1);
        System.arraycopy(array, right, aux, index, rightEnd - right + 1);
        System.arraycopy(aux, leftStart, array, leftStart, size);

    }

    public static void main(String[] args) {
        int[] array = {1, 10, 8, 6, 4, 3, 5, 2, 7, 9, 0};
        mergeSort(array, new int[array.length], 0, array.length - 1);
        printArray(array);

    }

    static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " , ");
        }
        System.out.println();
    }
}

