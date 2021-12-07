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
    public static int makeAnagram(String a, String b) {
        Hashtable<String, Integer> dictA = stringToDictionary(a);
        Hashtable<String, Integer> dictB = stringToDictionary(b);
        int result = 0;
        for (String key : dictA.keySet()) {
            result += Math.abs(dictA.get(key) - dictB.getOrDefault(key, 0));
            dictB.remove(key);
        }
        for (int value : dictB.values()) 
            result += value;

        return result;
    }

    private static Hashtable<String, Integer> stringToDictionary(String s){
        Hashtable<String, Integer> result = new Hashtable<>();
        String currentString;
        for(int i = 0; i<s.length(); i++)
        {
            currentString = s.substring(i, i + 1);
            if(result.containsKey(currentString))
                result.replace(currentString, result.get(currentString) + 1);
            else
                result.put(currentString, 1);
        }
        System.out.println(result);
        return result;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String a = bufferedReader.readLine();

        String b = bufferedReader.readLine();

        int res = Result.makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
