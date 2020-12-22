import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class RemoveDuplicates {
    //time O(n)
    //space O(n)

    static String removeDuplicates(char[] str) {
        Set<Character> set = new HashSet<>();
        //     def acb
        for (char c : str) {
            set.add(c);
        }
        StringBuilder sb = new StringBuilder();

        for (Character character : set) {
            sb.append(character);
        }
        return sb.toString();
    }

    /*
    time: O(n2)
    space: O(1)
     */
    static String removeDuplicatesOn2(char[] str) {

        StringBuilder sb = new StringBuilder();
        int repeatedCharacter = 0;
        for (int i = 0; i < str.length; i++) {
            repeatedCharacter = 0;//what you were doing wrong. you were not resetting the counter at the beginning of next round
            for (int j = i + 1; j < str.length; j++) {
                if (str[i] == str[j]) {
                    repeatedCharacter++;
                }
            }
            if (repeatedCharacter == 0) sb.append(str[i]);
        }
        return sb.toString();
    }

    static String removeDuplicatesUsingSort(String str) {
        StringBuilder sb = new StringBuilder();
        char[] array = str.toCharArray();

        Arrays.sort(array);//O(n*logn)
        sb.append(array[0]);

        for (int i = 1; i < array.length; i++) {
            if (array[i] != array[i - 1]) sb.append(array[i]);
        }
        return sb.toString();
    }

    static String removeDuplicatesUsingDistinct(String str) {
        StringBuilder sb = new StringBuilder();

        str.chars().distinct().forEach(c -> sb.append((char) c));
        return sb.toString();
    }

    public static void main(String[] args) {
        char[] input = "dabbac".toCharArray();
        System.out.println(removeDuplicates(input));
        System.out.println(removeDuplicatesOn2(input));
        System.out.println(removeDuplicatesUsingDistinct(new String(input)));
        System.out.println(removeDuplicatesUsingSort(new String(input)));
    }
}