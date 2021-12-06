import java.io.*;
import java.math.*;
import java.security.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class Solution {
    static long countTriplets(List<Long> arr, long r) {
    // By logic we need to check for each item if there's a number which is it's division by r
    // appearing earlier than itself in the array and if there's it's multiplation by r later
    // in the array
        long result = 0;
        
        Hashtable<Long, Long> higher = new Hashtable<>();
        Hashtable<Long, Long> lower = new Hashtable<>();
        for (Long key : arr)
            if(higher.containsKey(key))
                higher.replace(key, higher.get(key)+1);
            else{ // first occurance of the value 
                higher.put(key, 1L);
                lower.put(key, 0L);
            }
        for(int i = 0; i<arr.size(); i++){
            higher.replace(arr.get(i), higher.get(arr.get(i))-1);// Decrease higher with 1
            if(arr.get(i)%r == 0 && lower.containsKey(arr.get(i)/r) && higher.containsKey(arr.get(i)*r) && lower.get(arr.get(i)/r)>0 && higher.get(arr.get(i)*r)>0){
                result += lower.get(arr.get(i)/r) * higher.get(arr.get(i)*r);
            }

            lower.replace(arr.get(i), lower.get(arr.get(i))+1);// Increase higher with 1
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Long::parseLong)
            .collect(toList());

        long ans = countTriplets(arr, r);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}