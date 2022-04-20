/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TextManipulation;

/**
 *
 * @author User
 */
public class Word implements Comparable<Word> {
    private String word;
    private int cost;

    public Word(String word, int cost) {
        this.word = word;
        this.cost = cost;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Word{" + "word=" + word + ", cost=" + cost + '}';
    }

    
    
    
    @Override
    public int compareTo(Word o) {
    return this.getCost()-o.getCost();
    }
    
    
}
