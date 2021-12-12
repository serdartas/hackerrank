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

    public static void plusMinus(List<Integer> arr) {
        int positiveValues = 0;
        int negativeValues = 0;
        int zeros = 0;
        int currentValue;
        int n = arr.size();
      // 1. Get count of positives values
      // 2. Get count of negative values
      // 3. Get count of zeros
        for (int i = 0; i < n; i++) {
            currentValue = arr.get(i);
            if (currentValue < 0)
                negativeValues++;
            else if (currentValue == 0)
                zeros++;
            else
                positiveValues++;
      }
      // 4. Return positive to all ratio
        System.out.println((1.0 * positiveValues) / n);
      // 5. Return negative to all ratio
        System.out.println((1.0 * negativeValues) / n);
      // 6. Return zero to all ratio
        System.out.println((1.0 * zeros) / n);        
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}