import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.ArrayList;


public class MapExercises {
    /** Returns a map from every lower case letter to the number corresponding to that letter, where 'a' is
     * 1, 'b' is 2, 'c' is 3, ..., 'z' is 26.
     */
    public static Map<Character, Integer> letterToNum() {
        Map<Character, Integer> map = new TreeMap<>();
        int asciiValue = 97;
        for (int i = 1;i<=26;i++){
            char c = (char) (asciiValue+i-1);
            map.put(c, i);
        }
        return map;
    }

    /** Returns a map from the integers in the list to their squares. For example, if the input list
     *  is [1, 3, 6, 7], the returned map goes from 1 to 1, 3 to 9, 6 to 36, and 7 to 49.
     */
    public static Map<Integer, Integer> squares(List<Integer> nums) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int elem : nums) {
            int temp = elem * elem;
            map.put(elem, temp);
        }
        return map;
    }

    /** Returns a map of the counts of all words that appear in a list of words. */
    public static Map<String, Integer> countWords(List<String> words) {
        Map<String, Integer> map = new TreeMap<>();
//        List<String> uniqueWords = new ArrayList<>();

        //todo : fix the map method.
        for (String elem: words){
//            if the map has elem as key.
            if (map.containsKey(elem)){
                int value = map.get(elem);
                map.put(elem, value+1);
            } else {
                map.put(elem, 1);
            }
        }
        return map;
    }
}
