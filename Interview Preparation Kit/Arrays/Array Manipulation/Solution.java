import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {
    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        // Method 2:  Initialize an n sized array arr for each query, add value k
        // to position a and substract it from position b in array. Loop through 
        // array to get the running sum
        // Complexity is O(n) + O(m) = O(n+m)
            long result = 0;
            long runningSum = 0;
            long[] resultSet = new long[n+1];
            for(int i=0;i<n+1;i++)
                resultSet[i]=0;
    
            for (List<Integer> query : queries){
                resultSet[query.get(0)-1] += query.get(2);
                resultSet[query.get(1)] -= query.get(2);
            }
    
            for(int i=0;i<n+1;i++){
                runningSum+=resultSet[i];
                if(runningSum>result)
                    result = runningSum;
            }
            
            return result;
        }

    public static long arrayManipulation1(int n, List<List<Integer>> queries) {
    // Method 1: Brute force. Create an array of n size, initialize it with 0s
    // for each query, add k to values between a and b in array. Once finished
    // loop through the array and return the max value
        long result = 0;
        long[] resultSet = new long[n];
        for(int i=0;i<n;i++)
            resultSet[i]=0;

        for (List<Integer> query : queries)
            for(int i=query.get(0)-1;i<query.get(1);i++)
                resultSet[i]+=query.get(2);

        for(int i=0;i<n;i++)
            if(resultSet[i]>result)
                result = resultSet[i];
        
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                queries.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        long result = Result.arrayManipulation(n, queries);
        System.out.println(result);

        bufferedReader.close();
    }
}