package aoa.guessers;

import java.util.List;
import java.util.Map;

public class GuessHelper {
    public static char getGuess(Map<Character, Integer> freqMap, List<Character> guesses) {
        int maxNum = 0;
        char maxChar = 'a';

        if (freqMap != null) {
            for (char c : freqMap.keySet()){
                if (guesses.contains(c)){
                }else {
                    if (freqMap.get(c) > maxNum){
                        maxNum = freqMap.get(c);
                        maxChar = c;
                    }
                }
            }
            return maxChar;
        }
        return '?';
    }
}
