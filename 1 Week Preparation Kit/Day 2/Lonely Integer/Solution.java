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
    public static int lonelyinteger(List<Integer> a) {
        // implement using a hashmap
        HashMap<Integer, Integer> elements = new HashMap<>();
        int currentVal;
        for (int i = 0; i < a.size(); i++) {
            currentVal = a.get(i);

            if (elements.containsKey(currentVal)) {
                elements.replace(currentVal, elements.get(currentVal)+1);
            }
            else
                elements.put(currentVal, 1);
        }
        
        for (Map.Entry<Integer, Integer> entry : elements.entrySet()) {
            if (entry.getValue() == 1)
                return (int) entry.getKey();
        };
        return -1;
    }

    public static int lonelyinteger1(List<Integer> a) {
        // implement using a binary tree
        return -1;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.lonelyinteger(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
