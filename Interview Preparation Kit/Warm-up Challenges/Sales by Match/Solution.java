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

    /*
     * Complete the 'sockMerchant' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY ar
     */

    public static int sockMerchant(int n, List<Integer> ar) {
        // Method 1:
        // Sort the items in the list and go through each to get the count of pairs
        // Sorting has the complexity of O(N*log N) => O(N)
        // Looping through each item in the input letting the complexity be O(N)
        // Ending up with having O(2N) => O(N) complexity
        Collections.sort(ar);
        int prevItem = ar.get(0);
        int itemCount = 1;
        int pairCount = 0;

        for(int i = 1; i<ar.size(); i++){
            if(prevItem == ar.get(i)){
                itemCount++;
            }
            else{
                pairCount += (itemCount - itemCount % 2) / 2;
                itemCount = 1;
                prevItem = ar.get(i);
            }
        }
        pairCount += (itemCount - itemCount % 2) / 2;
        return pairCount;
    }

    public static int sockMerchant1(int n, List<Integer> ar) {
        // Method 2:
        // Create a dictionay, use each item as key and value as single item counts to calculate pairs
        // Theoratically there's a chance each item in the input will be unique causing amount of key
        // value pairs be equal to n so complexity becomes O(2n) => O(n)
        int result = 0;
        int dictKey = 0;
        Dictionary<Integer, Integer> socks = new Hashtable<Integer, Integer>(); 
        // populate hashtable
        for(int i = 0; i<ar.size(); i++){
            if(socks.get(ar.get(i)) == null)
                socks.put(ar.get(i), 1);
            else
                socks.put(ar.get(i), socks.get(ar.get(i))+1);
        }

        // calculate pair count
        Enumeration<Integer> keys = socks.keys();
        while(keys.hasMoreElements()){
            dictKey = keys.nextElement();
            result += (socks.get(dictKey) - socks.get(dictKey) % 2) / 2;
        }
        return result;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.sockMerchant(n, ar);
        System.out.println(result);

        bufferedReader.close();
    }
}
//1 1 1 1 2 3 3 3 3 3