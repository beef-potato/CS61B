package aoa.guessers;

import aoa.utils.FileUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import aoa.guessers.GuessHelper;

public class PAGALetterFreqGuesser implements Guesser {
    private final List<String> words;

    public PAGALetterFreqGuesser(String dictionaryFile) {
        words = FileUtils.readWords(dictionaryFile);
    }

    @Override
    /** Returns the most common letter in the set of valid words based on the current
     *  PATTERN and the GUESSES that have been made. */
    public char getGuess(String pattern, List<Character> guesses) {
        Map<Character, Integer> freqMap = getFrequencyMapMatchesPatternAndGuess(pattern, guesses);
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

    public Map<Character, Integer> getFrequencyMapMatchesPatternAndGuess(String pattern, List<Character> guesses) {
        Map<Character, Integer> freqMap = new TreeMap<>();
        List<String> PatternMatchWords = new ArrayList<>();
        List<Character> DisMatchChar = new ArrayList<>();
        int length = pattern.length();

        for (String word: words){
            if (word.length() != length){
                continue;
            }else {
                boolean flag = true;

                for (int i=0; i<length;i++){
                    if((pattern.charAt(i) != '-')&&(pattern.charAt(i)!=word.charAt(i))){
                        flag = false;
                        break;
                    } else if ((pattern.charAt(i) == '-')&&guesses.contains(word.charAt(i))) {
                        flag = false;
                        break;
                    }
                }
                if (flag){
                    PatternMatchWords.add(word);
                }
            }
        }

        for (String word : PatternMatchWords){
            for (Character c: word.toCharArray()){
                if (!freqMap.containsKey(c)){
                    freqMap.put(c, 1);
                }else {
                    freqMap.put(c, freqMap.get(c)+1);
                }
            }
        }

        return freqMap;
    }

    public static void main(String[] args) {
        PAGALetterFreqGuesser pagalfg = new PAGALetterFreqGuesser("data/example.txt");
        System.out.println(pagalfg.getGuess("----", List.of('e')));
    }
}
