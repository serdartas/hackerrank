import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {
    public static void minimumBribes(List<Integer> q) {
    // Method 2: Optimized version of first method which times out in some test scenarios.
    // Optimization is made while counting people bribed current item. Logically, everyone
    // can go maximum two positions ahead by bribing. Otherwise, they would have returned
    // "too chaotic" output. Hence, when checking amount of persons bribed current person,
    // we start checking from 1 position ahead of starting position of current person.
    // Remember, in a race, when you pass the 3rd, you become the 3rd, so passing 2 person
    // will bring you one position ahead of the starting position of the person in front of
    // you
        int result = 0;
        int personsAhead;

        for(int i = q.size()-1; i >= 0; i--){//Loop backwards from last item to first
        
            if (q.get(i) - (i+1) > 2) { //Bribed more than 2 person
                System.out.println("Too chaotic");
                return;
            }

            if (q.get(i) < 3)
                personsAhead = 0;
            else
                personsAhead = q.get(i) - 2; // 1 position before original position
            
            for(int j = personsAhead; j < i; j++) {
                if(q.get(j) > q.get(i))
                    result++;
            }
        }
        System.out.println(result);
    }

    public static void minimumBribes1(List<Integer> q) {
    // Method 1: First eliminating too chaotic rule by checking if any number moved
    // more than two positions ahead. Everyone in front of you that has a bigger 
    // number than you  must have bribed you. Hence starting from last and for each
    // item counting bigger numbers ahead. 
    // Worst case scenario is close to O(N square)
        int result = 0;
        for(int i=q.size()-1;i>=0;i--){//Loop backwards from last item to first
            if(q.get(i)-(i+1)>2){//Bribed more than 2 person
                System.out.println("Too chaotic");
                return;
            }

            for(int j=0;j<i;j++)
                if(q.get(j)>q.get(i))
                    result++;            
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
