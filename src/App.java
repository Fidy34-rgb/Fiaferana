import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        ArrayList<String> words = readWords("res/words.txt"); //Step 4
        HashMap<String, Integer> wordCounter = buildHashMap(words); //Step 5
        createHTMLFile(wordCounter); //Step 6
        //Step 9: create ArrayList of WordFrequency and populate it with data from step 5
        ArrayList<WordFrequency> wordFrequencyList = new ArrayList<>();
        for(String key: wordCounter.keySet())
        {
            WordFrequency wordOrder = new WordFrequency(wordCounter.get(key), key);
            wordFrequencyList.add(wordOrder);
        }
        Collections.sort(wordFrequencyList);
        createOrderedHTMLFile(wordFrequencyList);
    }

    //Step 4 - Read Input file
    private static ArrayList<String> readWords(String fileName){
        File file = new File(fileName);
        ArrayList<String> wordList = new ArrayList<>();

        // Try catch block to read lines from input file and store each word in the array
        try {
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line = bufferedReader.readLine();
            // while the not at the end of the file
            while(line != null){

                String[] words = line.split("[ .,]+");
                for(String word: words)
                {
                    // if there is a word add it to the arrayList
                    if(word.trim().length() > 0)
                    {
                        wordList.add(word.toLowerCase());
                    }
                }
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return wordList;
    }

    //Step 5: Count word occurences
    private static HashMap<String, Integer> buildHashMap(ArrayList<String> words){
        HashMap<String, Integer> wordCounter = new HashMap<>();
        // For loop to count words, if a word exists counter is incremented, if word does not exist 
        // counter is initiated at 1
        for(String word: words) 
        {
            Integer count = wordCounter.get(word);
            // If the word was not found yet, initialize counter to 1
            if(count == null)
            {
                wordCounter.put(word, 1);
            }
            // If word already exists, increment counter by 1
            else
            {
                wordCounter.put(word, count + 1);
            }
        }
        return wordCounter;
    }

    //Step 6: Create output HTML file
    private static void createHTMLFile(HashMap<String, Integer> wordCounter){
        File file = new File("res/words.html");

        // Try catch to create and style a table with the words from input file
        try {
            FileWriter FileWriter = new FileWriter(file);
            StringBuilder builder = new StringBuilder();
            final String css = "<style>" // Add styling to table
                        + "td, th { border: solid }"
                        + "table, td, th { border-collapse: collapse }"
                        + "</style>";
            builder.append(css).append("\n");
            builder.append("<h1>Word Count</h1>"); // builder creates Title for HTML page
            // builder creates and populates table with data from input file
            builder.append("<table>");
            for(String key: wordCounter.keySet()){
                builder.append("<tr>");
                builder.append("<td>" + key + "</td>");
                builder.append("<td>" + wordCounter.get(key) + "</td>");
                builder.append("</tr>");
            }
            builder.append("</table>");
            FileWriter.append(builder.toString());
            FileWriter.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        for (String keyWord: wordCounter.keySet()){
            System.out.println(keyWord + ": " + wordCounter.get(keyWord));
        }
    }

    // Step 10: create HTML file for arraylist that holds words ordered by frequency in ascending order
    private static void createOrderedHTMLFile(ArrayList<WordFrequency> wordFrequencyList){
        File file = new File("res/sorted.html");

        // Try catch to create and style a table with the words from input file
        try {
            FileWriter FileWriter = new FileWriter(file);
            StringBuilder builder = new StringBuilder();
            final String css = "<style>" // Add styling to table
                        + "td, th { border: solid }"
                        + "table, td, th { border-collapse: collapse }"
                        + "</style>";
            builder.append(css).append("\n");
            builder.append("<h1>Word Count</h1>"); // builder creates Title for HTML page
            // builder creates and populates table with data from input file
            builder.append("<table>");
            for(WordFrequency words: wordFrequencyList){
                builder.append("<tr>");
                builder.append("<td>" + words.getWord() + "</td>");
                builder.append("<td>" + words.getCount() + "</td>");
                builder.append("</tr>");
            }
            builder.append("</table>");
            FileWriter.append(builder.toString());
            FileWriter.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
