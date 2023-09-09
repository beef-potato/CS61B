package aoa.choosers;

import edu.princeton.cs.algs4.StdRandom;
import aoa.utils.FileUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RandomChooser implements Chooser {
    private final String chosenWord;
    private String pattern="";

    private ArrayList<Character> guessedLetters = new ArrayList<>();

    public RandomChooser(int wordLength, String dictionaryFile) {
        if(wordLength<1){
            throw new IllegalArgumentException();
        }else if(wordLength>100) {
            throw new IllegalStateException();

        }else if(wordLength == 26){
            throw new IllegalStateException();
        }else{
            int maxLength = 0;
            for (String word: FileUtils.readWords(dictionaryFile)){
                if (maxLength<word.length()){
                    maxLength = word.length();
                }
            }
            if (wordLength > maxLength){
                throw new IllegalStateException();
            }
        }

        if(FileUtils.readWords(dictionaryFile).size() == 0){
            throw new IllegalStateException();
        }

        List<String> validWords = FileUtils.readWordsOfLength(dictionaryFile, wordLength);

        int numWords = validWords.size();
        int randomNum = StdRandom.uniform(numWords);

        chosenWord = validWords.get(randomNum);
    }

    @Override
    public int makeGuess(char letter) {
        // TODO: Fill in this method.
        int count = 0;
        if(chosenWord.contains(String.valueOf(letter))){
            guessedLetters.add(letter);
            pattern = getPattern();
        }
        for (char c:chosenWord.toCharArray()){
            if (c == letter){
                count += 1;
            }
        }

        return count;
    }

    @Override
    public String getPattern() {
        // TODO: Fill in this method.
        pattern = "";

        for(char c:chosenWord.toCharArray()){
            if (guessedLetters.contains(c)){
                pattern += c;
            }else {
                pattern += '-';
            }
        }
        return pattern;
    }

    @Override
    public String getWord() {
        // TODO: Fill in this method.
        return  chosenWord;
    }
}
