/******************************************************************************
 for fixed length strings.
 it includes a method for sorting 32-bit integers,
 treating each integer as a 4-byte string.
 When N is large, this algorithm is 2-3x faster than the system sort.
 */
public class Leastsignificantdigitfirst {
    private static final int BITS_PER_BYTE = 8;

    // do not instantiate
    private Leastsignificantdigitfirst() {
    }

    /**
     * Rearranges the array of numberOfCharactersPerStr-character strings in ascending order.
     */
    public static void sort(String[] array, int numberOfCharactersPerStr) {
        int n = array.length;
        int Radix = 256;   // extend ASCII alphabet size
        String[] aux = new String[n]; //space complexity: O(n) a helper array

        for (int j = numberOfCharactersPerStr - 1; j >= 0; j--) {//-1 because arrays start with 0 and end with length - 1
            // we start with the right most character whic is the least significant one
            // compute frequency counts

            int[] count = new int[Radix + 1];
            for (String s : array) {
                count[s.charAt(j) + 1]++;
            }

           /*
            compute cumulates
            Now the next step is called
            computing cumulates,
            we go through the count array,
            we add the current one to the sum computed so far.
            we had two a's and three b's. So that means that there's five letters less than c,

            these cumulates tell us where the d's go in the output. There's 6 keys less than d,
            and 8 keys less than e, so the d's have to go in a[6] and a[7].

            the next step, access the cumulates, using the key as index to move items.
            So we're going to go to count[0], So when i is 0, we're looking at the d. The count array corresponding to d has 6,
            so it says, just put d in there, and "increment that". That means if you have another d,
            it's going to go into 7.
             */
            for (int r = 0; r < Radix; r++) {
                count[r + 1] += count[r];
            }
            printArray(count);

            // move data
            for (String str : array) {
                int temp = count[str.charAt(j)];
                aux[temp] = str;
                count[str.charAt(j)] = count[str.charAt(j)] + 1;
            }

            // copy back
            System.arraycopy(aux, 0, array, 0, n);
        }
    }

    public static void sortByFirstCharacter(String[] array) {
        int n = array.length;
        int Radix = 256;   // extend ASCII alphabet size
        String[] aux = new String[n]; //space complexity: O(n) a helper array

        // we start with the right most character whic is the least significant one
        // compute frequency counts

        int[] count = new int[Radix + 1];
        for (String s : array) {
            count[s.charAt(0) + 1]++;
        }

           /*
            compute cumulates
            Now the next step is called
            computing cumulates,
            we go through the count array,
            we add the current one to the sum computed so far.
            we had two a's and three b's. So that means that there's five letters less than c,

            these cumulates tell us where the d's go in the output. There's 6 keys less than d,
            and 8 keys less than e, so the d's have to go in a[6] and a[7].

            the next step, access the cumulates, using the key as index to move items.
            So we're going to go to count[0], So when i is 0, we're looking at the d. The count array corresponding to d has 6,
            so it says, just put d in there, and "increment that". That means if you have another d,
            it's going to go into 7.
             */
        for (int r = 0; r < Radix; r++) {
            count[r + 1] += count[r];
        }
        printArray(count);

        // move data
        for (String str : array) {
            int temp = count[str.charAt(0)];
            aux[temp] = str;
            count[str.charAt(0)] = count[str.charAt(0)] + 1;
        }

        // copy back
        System.arraycopy(aux, 0, array, 0, n);
    }

    static void printArray(int[] array) {
        for (int value : array)
            System.out.print(value + " , ");
        System.out.println();
    }

    /**
     * Rearranges the array of 32-bit integers in ascending order.
     * This is about 2-3x faster than Arrays.sort().
     */
    public static void sort(int[] a) {
        final int BITS = 32;                 // each int is 32 bits 
        final int R = 1 << BITS_PER_BYTE;    // each bytes is between 0 and 255
        final int MASK = R - 1;              // 0xFF
        final int w = BITS / BITS_PER_BYTE;  // each int is 4 bytes

        int n = a.length;
        int[] aux = new int[n];

        for (int d = 0; d < w; d++) {

            // compute frequency counts
            int[] count = new int[R + 1];
            for (int i = 0; i < n; i++) {
                int c = (a[i] >> BITS_PER_BYTE * d) & MASK;
                count[c + 1]++;
            }

            // compute cumulates
            for (int r = 0; r < R; r++)
                count[r + 1] += count[r];

            // for most significant byte, 0x80-0xFF comes before 0x00-0x7F
            if (d == w - 1) {
                int shift1 = count[R] - count[R / 2];
                int shift2 = count[R / 2];
                for (int r = 0; r < R / 2; r++)
                    count[r] += shift1;
                for (int r = R / 2; r < R; r++)
                    count[r] -= shift2;
            }

            // move data
            for (int i = 0; i < n; i++) {
                int c = (a[i] >> BITS_PER_BYTE * d) & MASK;
                aux[count[c]++] = a[i];
            }

            // copy back
            for (int i = 0; i < n; i++)
                a[i] = aux[i];
        }
    }

    /**
     * Reads in a sequence of fixed-length strings from standard input;
     * LessSignificantDigitFirst radix sorts them;
     * and prints them to standard output in ascending order.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        String[] a = {"bed", "all", "bad", "zoo", "yet", "bug", "dad", "yes", "mow", "fox"};
        int n = a.length;

        // check that strings have fixed length
        int numberofCharactersPerStr = a[0].length();
        for (String value : a) assert value.length() == numberofCharactersPerStr : "Strings must have fixed length";

        // sort the strings
        //  sort(a, numberofCharactersPerStr);
        sortByFirstCharacter(a);

        // print results
        for (String s : a) System.out.println(s);
    }
}