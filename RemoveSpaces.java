public class RemoveSpaces {
    /*
    if read_ptr points to any other character, write that to write_ptr and increment the write_pt
    if read_ptr points to a white space, skip
     */
    static String removeWhiteSpace(String str) {
        char[] charStr = str.toCharArray();
        int readPointer = 0;
        int writePointer = 0;
        //" this is a test"
        //"this is a test"
        //"this is a test "
        for (readPointer = 0; readPointer < charStr.length; readPointer++) {
            if (charStr[readPointer] != ' ') {
                charStr[writePointer] = charStr[readPointer];
                writePointer++;
            }
        }
        return new String(charStr).substring(0, writePointer);
    }

    public static void main(String[] args) {
        System.out.println(removeWhiteSpace("  this is a test "));
        System.out.println(removeWhiteSpace(" this is a test "));
        System.out.println(removeWhiteSpace(" this is a test"));
    }
}
