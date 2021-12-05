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
    public static int hourglassSum(List<List<Integer>> arr) {
    // Get sum of each hourglass in the array and find the highest value
    // input is made of a fixed amount of 36 values, algorithm iterates
    // a fixed amount of 16 times. As iteration count is not subject to
    // change complexity is O(16) => O(1)
        int result = Integer.MIN_VALUE;
        int hourglassSum = 0;
        for(int col=0; col<4; col++){
            for(int row=0; row<4; row++){
                //This is the left top corner of the hourglass
                hourglassSum = arr.get(row).get(col) + arr.get(row).get(col+1) + arr.get(row).get(col+2);//top row
                hourglassSum += arr.get(row+1).get(col+1);//mid row
                hourglassSum += arr.get(row+2).get(col) + arr.get(row+2).get(col+1) + arr.get(row+2).get(col+2);//bottom row
                if(hourglassSum>result)
                    result = hourglassSum;
            }
        }
        return result;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.hourglassSum(arr);

        System.out.println(result);

        bufferedReader.close();
    }
}