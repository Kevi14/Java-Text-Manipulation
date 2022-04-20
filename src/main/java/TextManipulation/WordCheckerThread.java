/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TextManipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import javax.print.DocFlavor;

/**
 *
 * @author User
 */
public class WordCheckerThread implements Runnable{

    private volatile TreeSet<Word> wordSet = new TreeSet<Word>();
    
    private List<String> wordList = new ArrayList<>();
    private String currentWord;

    public WordCheckerThread(String currentWord,List<String> wordList) {
        this.currentWord = currentWord;
        this.wordList=wordList;
    }
    
    
//    run method needed for thread to work.
    public void run(){
    for(String word:wordList){
      Integer cost = calculate(currentWord, word);
      wordSet.add(new Word(word, cost));
    }
    }
//    The cost of substitution a letter with another one
    private int costOfSubstitution(char a, char b) {
        return a == b ? 0 : 1;
    }

    private int min(int... numbers) {
        return Arrays.stream(numbers)
                .min().orElse(Integer.MAX_VALUE);
    }

//    Iterate through each letter and determine if it needs to be swapped. If so increase the cost by 1.
   private int calculate(String x, String y) {
        int[][] dp = new int[x.length() + 1][y.length() + 1];

        for (int i = 0; i <= x.length(); i++) {
            for (int j = 0; j <= y.length(); j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    dp[i][j] = min(dp[i - 1][j - 1]
                            + costOfSubstitution(x.charAt(i - 1), y.charAt(j - 1)),
                            dp[i - 1][j] + 1,
                            dp[i][j - 1] + 1);
                }
            }
        }

        return dp[x.length()][y.length()];
    }

    public TreeSet<Word> getWordSet() {
        return wordSet;
    }

    public void setWordSet(TreeSet<Word> wordSet) {
        this.wordSet = wordSet;
    }

    public List<String> getWordList() {
        return wordList;
    }

    public void setWordList(ArrayList<String> wordList) {
        this.wordList = wordList;
    }

    public String getCurrentWord() {
        return currentWord;
    }

    public void setCurrentWord(String currentWord) {
        this.currentWord = currentWord;
    }

    
}
