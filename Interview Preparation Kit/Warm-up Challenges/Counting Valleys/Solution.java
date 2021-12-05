import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import javax.lang.model.util.ElementScanner14;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */
    public static int countingValleys(int steps, String path) {
        // Method 1: Convert string to char array and iterate through the array
        // method needs to go through each charachter in the string once
        // so the compexity is O(N)
            int currentElevation = 0; // Start from sea level
            boolean inValley = false;
            int valleyCount = 0;
            char[] InputChars = path.toCharArray();

            for(int i=0;i<InputChars.length;i++){
                if(InputChars[i] == 'U')
                    currentElevation++;
                else if(InputChars[i]== 'D')
                    currentElevation--;
                else
                    throw new NoSuchElementException();
                
                if(!inValley && currentElevation < 0){
                    valleyCount++;
                    inValley = true;
                }
                if(currentElevation >= 0)
                    inValley = false;
            }
            return valleyCount;
        }

    public static int countingValleys1(int steps, String path) {
    // Method 2: Use substring to nagivate through the string
    // method needs to go through each charachter in the string
    // so the compexity is O(N)
        int currentElevation = 0; // Start from sea level
        boolean inValley = false;
        int valleyCount = 0;

        for(int i=0;i<path.length();i++){
            if(path.substring(i, i+1).equals("U"))
                currentElevation++;
            else if(path.substring(i, i+1).equals("D"))
                currentElevation--;
            else
                throw new NoSuchElementException();
            
            if(!inValley && currentElevation < 0){
                valleyCount++;
                inValley = true;
            }
            if(currentElevation >= 0)
                inValley = false;
        }
        return valleyCount;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int steps = Integer.parseInt(bufferedReader.readLine().trim());
        String path = bufferedReader.readLine();

        int result = Result.countingValleys(steps, path);

        System.out.println(String.valueOf(result));

        bufferedReader.close();
    }
}
