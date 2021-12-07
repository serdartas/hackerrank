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

    public static int sherlockAndAnagrams(String s) {
        HashMap<String, Integer> substrings = new HashMap<>();
        char[] arr;
        String currentSubstring;
        int result = 0;
        
        for(int i=1;i<s.length();i++){
            for(int j=0;j<s.length()+1-i;j++){
                arr = s.substring(j, j+i).toCharArray();
                Arrays.sort(arr);
                currentSubstring = new String(arr);
                if(substrings.containsKey(currentSubstring))
                    substrings.replace(currentSubstring, substrings.get(currentSubstring)+1);
                else
                    substrings.put(currentSubstring, 1);
            }
        }
        System.out.println(substrings);
        for (int val : substrings.values()) {
            if(val>1)
                result += gaussSum(val-1);
        }
        return result;
    }
    private static int gaussSum(int n){
        return n*(n+1)/2;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = Result.sherlockAndAnagrams(s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}