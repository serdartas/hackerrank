import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'jumpingOnClouds' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY c as parameter.
     */

    public static int jumpingOnClouds(List<Integer> c) {
    // Method: try to jump 2 steps first to get the fastest possible route
    // if two jumps don't work, go back and do one jump
    // Best case is N/2 iterations while worst case is N-1 for N>1 [0,0,1,0]
    // hence complexity of the algorith is O(N)
        int output=0;
        int i=0;
        while(i<c.size())
        {
            if(i+2<c.size() && c.get(i+2)==0)
            {
                output++;
                i+=2;
            }
            else
            {
                if(i+1 < c.size() && c.get(i+1)==0)
                {
                    output++;
                    i+=1;
                }
                else
                {
                    break;
                }
            }
        }
        return output;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> c = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.jumpingOnClouds(c);

        System.out.println(result);

        bufferedReader.close();
    }
}