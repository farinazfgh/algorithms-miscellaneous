import java.util.*;

public class GroupAnagrams {
    static String[] array = {
            "Tar", "Rat", "Arc", "Inch", "State"
            , "Cider", "Cried", "Dusty", "Study", "Night"
            , "Cat", "Bored", "Robed", "Save", "Elbow", "Grab"
            , "Desserts", "Conversation", "Car", "Angel"
            , "Listen", "Silent", "Below", "Taste"
            , "Vase", "Glean", "Stressed", "Act"
            , "Thing", "Chin", "Brag"
    };

    static String[] groupAnagrams(String[] array) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : array) {
            char[] temp = str.toLowerCase().toCharArray();
            Arrays.sort(temp);
            String key = new String(temp);
            List<String> anagramLsit = map.get(key);
            if (anagramLsit == null) anagramLsit = new ArrayList<>();
            anagramLsit.add(str);
            map.put(key, anagramLsit);
        }
        int i = 0;
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            List<String> list = entry.getValue();
            for (String str : list) {
                array[i++] = str;
            }
        }
        return array;

    }

    public static void main(String[] args) {
        printArray(groupAnagrams(array));
    }

    static void printArray(String[] array) {
        for (String str : array) {
            System.out.print(str + " , ");
        }
        System.out.println();
    }
}

