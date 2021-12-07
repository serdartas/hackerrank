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

    public static String isValid(String s) {
        Hashtable<String, Integer> chars = stringToDictionary(s);
        Hashtable<Integer, Integer> values = valueAsKeys(chars.values());
        int[] vals = valueAsArray(chars.values());
        if(values.size()>2)
            return "NO";
        
        if(values.size() == 2){
            // when there are only 2 different amount of occurances {a, b}
            // test 1- [a-b] should be 1
            // test 2- either one of a or b should occur only once also one occurance should be for only one item
            if(values.containsKey(1)){
                if(values.get(1)!=1)
                    return "NO";
                else
                    return "YES";
            }
            
            if(Math.abs(vals[0]-vals[1])!=1)
                return "NO";
        }

        return "YES";
    }
    
    private static int[] valueAsArray(Collection<Integer> arr){
        Hashtable<Integer, Integer> ht = valueAsKeys(arr);
        int[] result = new int[ht.size()];
        int i = 0;
        for (int key : ht.keySet()) {
            result[i] = key;
            i++;
        }
        return result;
    }

    private static Hashtable<Integer, Integer> valueAsKeys(Collection<Integer> arr){
        Hashtable<Integer, Integer> result = new Hashtable<>();
        for (int key : arr) {
            if(result.containsKey(key))
                result.replace(key, result.get(key)+1);
            else
                result.put(key, 1);
        }
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

        String s = bufferedReader.readLine();

        String result = Result.isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
