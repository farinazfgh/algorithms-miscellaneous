public class ReverseWords {
    //in my solution I used a stack starting from array[n-1] stack push until you reach a space
    //then stack pop() until stack is empty continue to array[0]
    // it needs O(m) stack space where m is the longest word's length
    //also, although you traverse the whole array once backwards, you need to pop() characters from stack
    //so both time and space complexity can be improved

    /**
     * To reverse all words in the string, we will first reverse
     * the string. Now all the words are in the desired location, but
     * in reverse order: "Hello World" -> "dlroW olleH".
     */
    public static char[] reverseWords(char[] sentence) {
        char[] reversed = reverseString(sentence, 0, sentence.length - 1);
        int start = 0;
        for (int i = 0; i < reversed.length; i++) {
            if (sentence[i] == ' ' || i == sentence.length - 1) {
                reverseString(sentence, start, i - 1);
                start = i + 1;
            }
        }
        return reversed;
    }

    static char[] reverseString(char[] array, int start, int end) {
        int mid = (start + end) / 2;
        for (int i = start, j = end; i <= mid && i < j; i++, j--) {
            char temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        return array;
    }

    public static void main(String[] args) {
        String sentence = "“The quick brown fox jumped over the lazy dog.";
        System.out.println(new String(reverseWords(sentence.toCharArray())));
    }
}
