import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    public static List<Integer> rotLeft(List<Integer> a, int d) {
        // Method 2: Input array has k amount of items and it is asked to rotate d
        // times in k. When d is bigger than k, it will rotate back to original state
        // for division of d to k and actual rotation will only happen for the remainder
        // of division of d to k. So, problem can be solved by only iterating once in 
        // items in input array
        // Complexity is not relative to rotation count but size of input array. Assume
        // size of input array is k, complexity is O(k)
            int iterateFor = d % a.size();
            List<Integer> result = new ArrayList<Integer>();
            for(int i=0;i<a.size();i++)
                result.add(a.get((i+iterateFor)%a.size()));
            return result;
        }

    public static List<Integer> rotLeft1(List<Integer> a, int d) {
    // Method 1: rotate the array d times to produce the output
    // considering d is N, complexity is O(N) as it needs to call
    // itself d times. In the other hand the algorithm does not 
    // make good use of the memory, so it's quite possible to have
    // memory overflows

        int firstItem;
        Integer[] result = a.toArray(new Integer[0]);
        firstItem = result[0];
        for(int i = 0; i<result.length-1;i++){
            result[i] = result[i+1];
        }
        result[result.length-1]=firstItem;
        if(d>1){
            return rotLeft(Arrays.asList(result), d-1);
        }
        else
            return Arrays.asList(result);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);
        int d = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.rotLeft(a, d);

        for(int i=0; i<result.size();i++)
            System.out.print(result.get(i) + " ");

        bufferedReader.close();
    }
}