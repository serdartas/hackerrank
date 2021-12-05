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
    public static long repeatedString1(String s, long n) {
    // Method 1: Create the string containing n charachters by adding s to end of itself
    // iterate within each charachter of the string and count letter "a"
    // Complexity of the algorithm is O(N) as it needs to iterate N times within the string
    // that's built
    
        String p = "";
        int result = 0;
        while(p.length()<n)
        {
            p += s;
            if(p.length() > n)
                p = p.substring(0, (int) n);
        }
        
        for(long i=0; i<n; i++)
        {
            if(p.charAt((int)i)=='a')
                result++;
        }
        return result;
    }
    
    public static long repeatedString(String s, long n) {
    // Method 2: Count the occurance of charachter "a" in given string and do the math to count
    // how many times string should be repeated to reach n charachters followed by adding amount
    // of letter a in the remainder
    // Complexity of this algorithm is not relative to n but size of S. Assume size of S is M
    // complexity of the algorithm becomes O(M) as is needs to iterate through each char in given
    // string for once to calculate amount of charachter a within it.
        long remainder = n % s.length();    
        n -= remainder;
        long repeats = n/s.length();
        long result = repeats * getCharACountinString(s);
        if(remainder!=0)
            result += getCharACountinString(s.substring(0, (int) remainder));
        return result;
    }
    
    private static int getCharACountinString(String s){
    // Method that calculates amount of charachter a within given string.
    // A separata method is created to not repeat the code
        int result = 0;
        char[] LettersInS = s.toCharArray();
        for(int i=0; i<LettersInS.length;i++)
            if(LettersInS[i]=='a')
                result++;
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String s = bufferedReader.readLine();
        long n = Long.parseLong(bufferedReader.readLine().trim());

        long result = Result.repeatedString(s, n);
        System.out.println(result);

        bufferedReader.close();
    }
}
