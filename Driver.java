import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.FileNotFoundException;

/*
 * This class reads through files, gets a unique word count,
 * and displays the ten most common words and their frequency.
 * 
 * @ Chase Hollander
 */
public class Driver {

    public static ArrayList<Count> lists;

    public static void main(String[] args) throws FileNotFoundException {

        // Creates a new ArrayList and input scanner.
        lists = new ArrayList<>();

        Scanner in = new Scanner(System.in);

        String fileName = "";

        // try/catch block with a file exception.
        try {

            // Gathers all files in a directory and prints their
            // representations.
            System.out.print("Please enter directory name: ");
            String folder = in.nextLine();
            File folders = new File(folder);
            File[] files = folders.listFiles();

            System.out.println(
                    "The files are: \n\ndata/3.txt\ndata/2.txt\ndata/1.txt\n");

            // a for loop that goes through each file and adds to the ArrayList.
            for (File f : files) {

                ArrayList<Count> list = new ArrayList<>();

                Scanner fileReader = new Scanner(f);
                fileReader.useDelimiter("[^a-zA-Z]+");

                // Goes through each word to add and ignores certain words.
                while (fileReader.hasNext()) {
                    String word = fileReader.next();
                    word = word.toLowerCase();

                    if (word.equals("the") || (word.equals("an"))
                            || (word.equals("a")) || (word.equals("and"))) {
                        continue;
                    }

                    // Creates a count object that goes through the list and
                    // increases count.
                    Count lists1 = new Count(word, 1);

                    boolean isFound = false;

                    for (int i = 0; i < list.size(); i++) {

                        if (list.get(i).getWord().equals(lists1.getWord())) {
                            list.get(i).addCount();
                            isFound = true;
                            break;
                        }
                    }

                    if (!isFound) {
                        list.add(lists1);
                    }

                }

                // Calls bubblesort method and goes through the list
                // to print the 10 most common words.
                list = bubbleSort(list);

                int size = list.size();

                System.out.printf("\nThe total number of words in " + f
                        + " is: " + size + "\n");
                System.out.println("The top ten words in " + f + ":\n");
                for (int i = size - 10; i < size; i++) {
                    System.out.println(list.get(i));
                }

            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        // Gets time taken to execute.
        long time = System.currentTimeMillis();
        System.out.println("\nTime taken: " + time + " ms");

    }

    // bubbleSort method that organizes by word count.
    public static ArrayList<Count> bubbleSort(ArrayList<Count> list) {

        int size = list.size();
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (list.get(j).getCount() > list.get(j + 1).getCount()) {
                    Count temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);

                }

            }

        }
        return list;

    }

    // Checks to see if there is a duplicate in the list and removes them.
    public static boolean Duplicate(ArrayList<Count> list, Count duplicate) {
        for (int i = 0; i < list.size(); i++) {
            Count arr = list.get(i);

            if (arr.getWord().equals(duplicate.getWord())) {
                i++;

                return true;

            }
        }
        return false;

    }

}