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
    public static void miniMaxSum(List<Integer> arr) {
        long arraySum = 0;
        long maxValue = Integer.MIN_VALUE;
        long minValue = Integer.MAX_VALUE;
        int currentValue;
        for (int i = 0; i < arr.size(); i++) {
            currentValue = arr.get(i);
            arraySum += currentValue;
            if (currentValue < minValue)
                minValue = currentValue;
            if (currentValue > maxValue)
                maxValue = currentValue;
        }
        maxValue = arraySum - maxValue;
        minValue = arraySum - minValue;
        System.out.println(maxValue + " " + minValue);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}