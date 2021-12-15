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
    public static void minimumBribes(List<Integer> q) {
        int result = 0;
        for (int i = q.size()-1; i > 0; i--) {
            if(q.get(i)-(i+1)>2){//Bribed more than 2 person
                System.out.println("Too chaotic");
                return;
            }
            
            if (q.get(i) < i+1){
                if (i>1){
                    for (int j = q.get(i)-2; j < i; j++) {
                        if (q.get(j) > q.get(i))
                            result++;
                    }
                }
                else if (q.get(0) > q.get(1))
                    result++;
            }
        }
        System.out.println(result);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                Result.minimumBribes(q);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
