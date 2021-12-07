import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
    
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> dict = new HashMap<>();
        Map<Integer, Integer> freq = new HashMap<>();
        int oldCount = 0;
        int newCount = 0;
        for (List<Integer> query : queries)
        {
            oldCount = dict.getOrDefault(query.get(1), 0);
            switch (query.get(0))
            {
                case 1: // add one occurance
                    newCount = oldCount + 1;
                    if(dict.containsKey(query.get(1))){
                        dict.replace(query.get(1), dict.get(query.get(1))+1);
                    }
                    else{
                        dict.put(query.get(1), 1);
                    }
                    break;
                case 2: // remove one occurance
                    newCount = oldCount - 1;
                    if(!dict.containsKey(query.get(1)))
                        break;
                    else {
                        dict.replace(query.get(1), dict.get(query.get(1))-1);
                    }
                    break;
                case 3: // Check if there are any integer with given frequency
                    if(query.get(1) == 0)
                        result.add(1);
                    else if(query.get(1)>queries.size())
                        result.add(0);
                    else if(freq.containsKey(query.get(1)) && freq.get(query.get(1)) > 0){
                            result.add(1);
                    }
                    else
                        result.add(0);
                    break;            
                default:
                    break;
            }
            if(query.get(0)!=3){
                freq = putOrReplace(freq, newCount, 1);
                freq = putOrReplace(freq, oldCount, -1);
            }
            //System.out.println("dict: " + dict);
            //System.out.println("freq: " + freq);
        }
        
        return result;
    }

    private static  Map<Integer, Integer> putOrReplace(Map<Integer, Integer> dict, int key, int value){
        if(dict.containsKey(key))
            dict.replace(key, dict.get(key) + value);
        else
            dict.put(key, value);
        return dict;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
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

        List<Integer> ans = freqQuery(queries);

        bufferedWriter.write(
            ans.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
