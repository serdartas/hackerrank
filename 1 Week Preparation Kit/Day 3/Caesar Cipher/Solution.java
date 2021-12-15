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
    public static String caesarCipher(String s, int k) {
        // ascii 65 - 90 A,..,Z
        // ascii 97 - 122 a,...,z
        String result = "";
        char[] text = s.toCharArray();

        for (int i = 0; i < text.length; i++) {

            int ascii = text[i]; // ascii value of char
            
            if (ascii >= 65 && ascii <= 90) { // Upper case
                ascii -= 65; // Get alphebetical order
                ascii += k;
                ascii = ascii % 26;
                ascii += 65;
                result += (char) ascii;
            }
            else if (ascii >= 97 && ascii <= 122) { // Lower case
                ascii -= 97; // Get alphebetical order
                ascii += k;
                ascii = ascii % 26;
                ascii += 97;
                result += (char) ascii;
            }
            else {
                result += text[i];
            }
            
        }
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}