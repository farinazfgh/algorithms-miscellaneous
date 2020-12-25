public class BitwiseOperators {
    public static void main(String[] args) {
        int a = 12, b = 25;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        andd(a, b);
        System.out.println("************************");

        orr(a, b);
        System.out.println("************************");

        xorr(a, b);
        System.out.println("************************");

        complement(a, b);
        System.out.println("************************");

        logical_shift(a, b);
        System.out.println("************************");

        logical_left_shift();
        System.out.println("************************");

        logical_right_shift();
        System.out.println("************************");

        System.out.println(is_power_of_two1(1023));
        System.out.println("************************");

        System.out.println(is_power_of_two2(1024));
        System.out.println("************************");

        write_all_poweroftwos(1024);
        System.out.println("************************");

        System.out.println(count_one(1023));
        System.out.println("************************");

        System.out.println(count_one(8));
        System.out.println("************************");

        System.out.println(check_the_ith_bit_is_set(13, 2));
        System.out.println("************************");

        System.out.println(check_the_ith_bit_is_set(7, 3));
        System.out.println("************************");
    }

    static void complement(int a, int b) {
    /*
     * It is important to note that the bitwise complement of any integer N is equal to -(N + 1). For example,
     * 35 = 00100011 (In Binary)
     Using bitwise complement operator
        ~   00100011
            __________
            11011100
     */
        System.out.println(" ~a  = " + ~a);
        int num1 = 35;
        int num2 = -150;
        System.out.println("~(" + num1 + ") = " + (~num1));
        System.out.println("~(" + num2 + ") = " + (~num2));
    }

    static void andd(int a, int b) {
    /*
 00001100
&    00011001
 _________
 00001000  = 8 (In decimal)
*/
        System.out.println("a & b = " + (a & b));
    }

    static void logical_left_shift() {

/*
  Left shift is equivalent to multiplying the bit pattern with  2^k( if we are shifting k bits ).
*/
        System.out.println("logical left shift");
        System.out.println("1 << 1 = " + (1 << 1));
        System.out.println("1 << 2 = " + (1 << 2));
        System.out.println("1 << 4 = " + (1 << 4));
    }

    static void logical_right_shift() {

/*
  Right shift is equivalent to dividing the bit pattern with 2^k( if we are shifting k bits ).
*/
        System.out.println("logical right shift");
        System.out.println("4 >> 1 = " + (4 >> 1));
        System.out.println("6 >> 1 = " + (6 >> 1));
        System.out.println("16 >> 4 = " + (16 >> 4));
    }

    /*
     * O(logN)
     */
    static boolean is_power_of_two1(int x) {
        if (x == 0) return false;
        while ((x % 2 == 0)) x = x / 2;
        return x == 1;
    }

    /*
     * O(1)
     */
    static boolean is_power_of_two2(int i) {
        if ((i & i - 1) == 0) return true;
        return false;
    }

    static void write_all_poweroftwos(int x) {
        for (int i = 0; i <= 1024; i++) {
            if ((i & i - 1) == 0) System.out.println("i = " + i);
        }
    }

    static void orr(int a, int b) {
    /*
    00001100
|   00011001
    _________
    00011101  = 29 (In decimal)
     */
        System.out.println("a | b = " + (a | b));
    }

    static void xorr(int a, int b) {
/*
    00001100
^   00011001
    _________
    00010101  = 21 (In decimal)
 */
        System.out.println("a ^ b = " + (a ^ b));
    }

    static void logical_shift(int a, int b) {
//    N >> m = [ N >> (m-1) ] / 2
//    N << m = [ N << (m-1) ] * 2
        // declaring two integer variables
        int num = 212, i;

        // Shift Right Operation
        System.out.println("Shift Right:");

        // Using for loop for shifting num right from 0 bit to 3 bits
        for (i = 0; i < 4; i++) {
            System.out.println("212 >> " + i + " = " + (212 >> i));
        }

        // Shift Left Operation
        System.out.println("\nShift Left:");

        // Using for loop for shifting num left from 0 bit to 3 bits
        for (i = 0; i < 4; i++) {
            System.out.println("212 << " + i + " = " + (212 << i));
        }
    }

    //Complexity: O(K), where K is the number of ones present in the binary form of the given number. worst case O(logN)
    static int count_one(int n) {
        int count = 0;
        while (n > 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    static boolean check_the_ith_bit_is_set(int n, int i) {
        int _2poweri = 1 << i;
        System.out.println("2 power of i: " + _2poweri);
        if ((_2poweri & n) != 0) return true;
        return false;
    }

    /*
        0 = (000)2 = {}
        1 = (001)2 = {c}
        2 = (010)2 = {b}
        3 = (011)2 = {b, c}
        4 = (100)2 = {a}
        5 = (101)2 = {a, c}
        6 = (110)2 = {a, b}
        7 = (111)2 = {a, b, c}
        possibleSubsets(A, N):
            for i = 0 to 2^N:
                for j = 0 to N:
                    if jth bit is set in i:
                        print A[j]
                print ‘\n’
     there are 2^N possible subsets of any given set with N elements
     */
    static void possible_subsets(char A[], int N) {
        for (int i = 0; i < (i << N); i++) {
            for (int j = 0; i < N; j++) {
                if ((i & (1 << j)) != 0) {// if jth bit is set in i:
                    System.out.println(A[j] + ' ');
                }
                System.out.println();
            }

        }
    }

}
