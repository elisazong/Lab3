import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

/**
 * A class that can do several kinds of word counting.
 *
 * For now it can only count the number of word "prince" in the given url
 * (case-sensitive)
 */
public class WordCount {

    /**
     * Present the result of several word counting functions.
     *
     * @param args args input parameters.
     */
    public static void main(final String[] args) {

        System.out.println("Number of \"prince\" in the url: " + countSpecificWord());

    }

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    /**
     * @para NUM_OF_CHAR number of characters in the word "prince"
     */
    public static final int NUM_OF_CHAR = 6;

    /**
     * Count how many "prince"s are in the text.
     *
     * @return the number of "prince" in the text
     */
    public static int countSpecificWord() {

        String contents;
        String contentsRemain;
        int count = 0;
        int returnPosition = 0;

        contents = urlToString("http://erdani.com/tdpl/hamlet.txt");
        contentsRemain = contents;
        returnPosition = contents.indexOf("prince");

        while (returnPosition != -1) {
            count++;
            contentsRemain = contentsRemain.substring(returnPosition + NUM_OF_CHAR);
            returnPosition = contentsRemain.indexOf("prince");
        }

        return count;
    }

}

