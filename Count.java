
/*
 * This class contains the instance variables word and count.
 * It gathers information on those two variables to be used in Driver.
 */
public class Count {

    /*
     * Instance variables
     */
    private String word;
    private int count;

    /*
     * @param word
     * 
     * @param count
     */
    public Count(String word, int count) {
        this.word = word;
        this.count = count;
    }

    /*
     * Combines the two and puts them in a String.
     */
    public String toString() {
        return word + " " + count;
    }

    /*
     * Getter methods for word, count, and word count.
     */
    public String getWord() {
        return word;
    }

    public int getCount() {
        return count;
    }

    public String getWordCount() {
        return word + " " + count;
    }

    /*
     * A counter method.
     */
    public void addCount() {
        count++;
    }

}
