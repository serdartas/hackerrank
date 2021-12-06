import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.toList;

class Result {
    public static void checkMagazine(List<String> magazine, List<String> note) {
    // Basic problem, requiring words in magazine to be passed to a dictionary
    // followed by comaprison with words in note. The only catch is making sure
    // to hold the word count. Complexity is O(m) + O(n) => O(n)
        System.out.println(doesMagazineCoverNote(magazine, note));
    }

    private static String doesMagazineCoverNote(List<String> magazine, List<String> note){
        Hashtable<String, Integer> dict = new Hashtable<>();
        for (String str : magazine)
               if(dict.containsKey(str))
                    dict.replace(str, dict.get(str)+1);
                else
                    dict.put(str, 1);
        
        for (String str : note) {
            if(!dict.containsKey(str))
                return "No";
            else if (dict.get(str)==0)
                return "No";
            else 
                dict.replace(str, dict.get(str)-1);
        }
        return "Yes";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);

        int n = Integer.parseInt(firstMultipleInput[1]);

        List<String> magazine = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .collect(toList());

        List<String> note = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .collect(toList());

        Result.checkMagazine(magazine, note);

        bufferedReader.close();
    }
}