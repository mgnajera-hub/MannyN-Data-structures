import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * This program checks which words in a file are not present in a dictionary.
*/
public class WordAnalysis
{
    public static void main(String[] args)
        throws FileNotFoundException
    {
        //Determine the current working directory
        //System.out.println(System.getProperty("user.dir"));

        Set<String> wordsList = readWords("MannyN-Data-structures/Chapter 15 Class Notes/src/words"); //Put all the words into a set
        Set<String> novelWords = readWords("MannyN-Data-structures/Chapter 15 Class Notes/src/war-and-peace.txt");

        //Print all the words that are in the novel, but not in the dictionary
        for (String word: novelWords)
        {
            if(!wordsList.contains(word));
            {
                System.out.println(word);
            }
        }

        //Print out the # of unique words in the dictionary
        System.out.println("There are "+novelWords.size()+" unique words in the novel");

        //Print the number of unique words with >3 letters

        Iterator<String> iter = novelWords.iterator();
        while (iter.hasNext())
        {
            if (iter.next().length() <= 3)
                iter.remove();
        }
        System.out.println("There are "+novelWords.size()+" unique words in the novel with 3 or MORE letters");
    }

    /**
     * Reads all words from a file.
     *
     * @param filename the name of the file
     * @return a set with all lowercased words in the file. Here, a
     * word is a sequence of upper- and lowercase letters.
    */
    public static Set<String> readWords(String filename)
        throws FileNotFoundException
    {
        // Use a HashSet instead of a TreeSet because the order does not matter
        Set<String> words = new HashSet<>();
        Scanner in = new Scanner(new File(filename), "UTF-8");
        //Use any character that's not a letter as a delimiter
        in.useDelimiter("[^a-zA-Z]+");

        while (in.hasNext())
        {
            words.add(in.next().toLowerCase());
        }

        in.close();
        return words;
    }
}
