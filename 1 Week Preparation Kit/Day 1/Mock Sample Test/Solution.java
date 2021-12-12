import java.io.*;

class Result {
    public static void fizzBuzz(int n) {
        String result;
        for (int i=1; i<=n;i++){
            result = "";
            if(i%3 != 0 && i%5 != 0){
                System.out.println(i);
                continue;            
            }
            if (i%3 == 0)
                result += "Fizz";
            
            if (i%5 == 0)
                result += "Buzz";
            
            System.out.println(result);
        }
    }

    public static void fizzBuzz1(int n) {
    // Brut force =)
        for (int i = 1; i <= n; i++) {
            if (i<3){
                System.out.println(i);
                continue;
            }
            
            if (i%3 == 0 && i%5 == 0){
                System.out.println("FizzBuzz");
            }
            else if (i%3 == 0){
                System.out.println("Fizz");
            }
            else if (i%5 == 0) {
                System.out.println("Buzz");
            }
            else {
                System.out.println(i);
            }     
        }
    }

}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        Result.fizzBuzz(n);

        bufferedReader.close();
    }
}