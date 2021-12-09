import java.io.*;
import java.util.*;

public class Solution {
    static class CharSequence {
        public char charachter;
        public long count;
    
        public CharSequence(char _charachter, long _count) {
            charachter = _charachter;
            count = _count;
        }
    }

    static long substrCount(int n, String s) {
    // Store each charachter sequence in an array. Eg: aaabaaa =>{(a,3),(b,1),(c,3)}
        s += " ";
    List<CharSequence> sequences = new ArrayList<CharSequence>();
    long count = 1;
    char currentChar = s.charAt(0);
    for(int i = 1; i < n ; i++) {
        if(currentChar == s.charAt(i))
            count++;
        else {
            sequences.add(new CharSequence(currentChar, count));
            count = 1;
            currentChar = s.charAt(i);
        }
    }
    // corner case: string is built of occurances of only one charachter
    sequences.add(new CharSequence(currentChar, count));
    
    count = 0;
    if(sequences.size() >= 3) {
        CharSequence previousOne, currentOne, nextOne;
        currentOne = sequences.get(0);
        nextOne =  sequences.get(1);
        count = gaussSum(currentOne.count);
        for(int i = 1; i < sequences.size()-1; i++) {
            previousOne = currentOne;
            currentOne = nextOne;
            nextOne = sequences.get(i+1);
            count += gaussSum(currentOne.count);
            if(previousOne.charachter == nextOne.charachter && currentOne.count == 1)
                if(previousOne.count > nextOne.count)
                    count += nextOne.count;
                else
                count += previousOne.count;
        }
        count += gaussSum(nextOne.count);
    }
    else {
        for(CharSequence currentOne:sequences){
            count += gaussSum(currentOne.count);
        }
    }
        return count;
    }

    private static long gaussSum(long l){
        //Gauss. Sum of numbers eg: Gauss(3)=1+2+3=6
        return (l*(l+1))/2;
    }

    static long substrCount1(int n, String s) {
    // Brute force
        long result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n+1-i; j++) {
                if(satisfiesCond(s.substring(i,i+j), j))
                    result++;
            }
        }
        return result;
    }

    private static boolean satisfiesCond(String s, int n){
        // All characters except the middle one are the same, e.g. aadaa.
        // All of the characters are the same, e.g. aaa.
        // in summary, check all chars except for the middle one to see if they match
        // needless to check midchar in even charachtered strings
        int midChar;
        if(n%2==1)
            midChar=n/2;
        else
            midChar=-1;

        String prev = s.substring(0,1);

        for (int i = 0; i < n; i++) {
            if(i==midChar)
                continue;
            if(!s.substring(i, i+1).equals(prev))
                return false;
        }
        return true;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        long result = substrCount(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}