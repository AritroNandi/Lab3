import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScraper {
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
    public static int wordCount(final String url) {
        String newUrl = urlToString(url);
        char[] urlArray = newUrl.toCharArray();
        int count = 0;

        for (int i = 0; i < urlArray.length; i++) {
            if (i + 1 != urlArray.length) {
                if ((urlArray[i] == ' ' || urlArray[i] == '\n') && (urlArray[i + 1] != '\n' || urlArray[i + 1] != ' ')) {
                    count += 1;
                }
            }
        }
        return count;
    }
    public static void main(String[] unused) {
        String url = "https://www.bls.gov/tus/charts/chart9.txt";
        System.out.println(wordCount(url));
    }
}
