import java.io.*;
import java.util.stream.*;

import javax.lang.model.util.ElementScanner14;

class Result {

    public static int palindromeIndex(String s) {
        int n = s.length();
        int start = 0;
        int end = n-1;
        
        while(s.length() > 1 && start<end){
            if (s.charAt(start) == s.charAt(end)){
                start++;
                end--;
                continue;
            }                
            else {
                if (isPalindrome(s.substring(start+1, end+1)))
                    return start;
                else if (isPalindrome(s.substring(start, end)))
                    return end;
                else
                    return -1;                    
            }            
        }
        return -1;
    }

    private static boolean isPalindrome(String s){
        int n = s.length();
        for (int i = 0; i < n / 2; i++)
            if (s.charAt(i) != s.charAt(n - i - 1))
                return false;
        return true;
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

                int result = Result.palindromeIndex(s);

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
