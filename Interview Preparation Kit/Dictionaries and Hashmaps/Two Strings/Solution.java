import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {
    public static String twoStrings(String s1, String s2) {
    // To share a substring they should certainly share a charachter
    // brute force will result in O(N square) if we use an array to
    // iterate. To lower the complexity, we move each charachter in
    // one of the strings to a dictionary and iterate in next string
    // to see if dictionary has a match
    // Complexity is O(n+m) => O(n)
        Dictionary<Character, Integer> dict = new Hashtable(); 
        char[] str1 = s1.toCharArray();
        for (char c : str1)
            dict.put(c,1);
        
        str1 = s2.toCharArray();
        for (char c : str1)
            if(dict.get(c)!=null)
                return "YES";
        return "NO";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s1 = bufferedReader.readLine();

                String s2 = bufferedReader.readLine();

                String result = Result.twoStrings(s1, s2);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
