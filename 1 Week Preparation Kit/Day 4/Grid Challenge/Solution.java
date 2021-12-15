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
    public static String gridChallenge(List<String> grid) {
        int n = grid.size();
        char[][] matrix = new char[n][n];

        for (int i = 0; i < n; i++){
            matrix[i] = sort(grid.get(i).toCharArray());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[j][i] < matrix[j-1][i])
                    return "NO";
            }
        }
        return "YES";
    }

    private static char[] sort(char[] arr){
        Arrays.sort(arr);
        return arr;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<String> grid = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                    .collect(toList());

                String result = Result.gridChallenge(grid);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
