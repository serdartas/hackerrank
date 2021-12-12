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

    public static int flippingMatrix(List<List<Integer>> matrix) {
        int result = 0;
        int s = matrix.size()/2;
        int n = matrix.size(); //last index in matrix
        int[][] values = new int[s][s];
        
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < s; j++) {
                if (matrix.get(i).get(j) > values[i][j]) values[i][j] = matrix.get(i).get(j);
                if (matrix.get(i).get(n-j-1) > values[i][j]) values[i][j] = matrix.get(i).get(n-j-1);
                if (matrix.get(n-i-1).get(j) > values[i][j]) values[i][j] = matrix.get(n-i-1).get(j);
                if (matrix.get(n-i-1).get(n-j-1) > values[i][j]) values[i][j] = matrix.get(n-i-1).get(n-j-1);
            }
        }

        for (int i = 0; i < s; i++) {
            for (int j = 0; j < s; j++) {
                result += values[i][j];
            }   
        }
        
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<List<Integer>> matrix = new ArrayList<>();

                IntStream.range(0, 2 * n).forEach(i -> {
                    try {
                        matrix.add(
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                int result = Result.flippingMatrix(matrix);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}