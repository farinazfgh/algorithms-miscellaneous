public class Main {
    /*
    A code unit in US-ASCII consists of 7 bits; 128
    A code unit in UTF-8, consists of 8 bits; 256
    A code unit in UTF-16 consists of 16 bits; 65536
    A code unit in UTF-32 consists of 32 bits. 4294967296
         */
    public static void main(String[] args) {
        /*
        ********* Byte *********
        127
        -128
         */
        System.out.println("********* Byte *********");
        System.out.println(Byte.MAX_VALUE);
        System.out.println(Byte.MIN_VALUE);
        /*
        ********* Short *********
        32,767
        -32,768
         */
        System.out.println("********* Short *********");
        System.out.println(Short.MAX_VALUE);
        System.out.println(Short.MIN_VALUE);
        /*
        ********* Integer *********
        2,147,483,647
        -2,147,483,648
        */
        System.out.println("********* Integer *********");
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        /*
        ********* Long *********
        9,223,372,036,854,775,807
        -9,223,372,036,854,775,808
         */
        System.out.println("********* Long *********");
        System.out.println(Long.MAX_VALUE);
        System.out.println(Long.MIN_VALUE);
    }
}
