import java.io.*;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.*;

class Result {
    
    public static String isBalanced(String s) {
        int n = s.length();
        Deque<Character> stack = new ArrayDeque<>();

        //Corner case 1: input has one or no items
        if (n<2)
            return "NO";

        HashMap<Character, Character> bracketsMap = getBracketMap();

        //Corner case: first char is a bracket close
        if(bracketsMap.containsKey(s.charAt(0)))
            return "NO"; 

        stack.push(s.charAt(0));

        for (int i = 1; i < n; i++) {
            if(bracketsMap.containsKey(s.charAt(i))){
                if(bracketsMap.get(s.charAt(i)).equals(stack.peek())){
                    stack.pop();
                }
                else
                    return "NO";
            }
            else
                stack.push(s.charAt(i));
        }

        if(stack.size()>0)
            return "NO";
        return "YES";
    }
    

    private static HashMap<Character, Character> getBracketMap(){
        HashMap<Character, Character> bracketMap = new HashMap<>();
        bracketMap.put('}','{');
        bracketMap.put(']','[');
        bracketMap.put(')','(');
        return bracketMap;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                System.out.print("Balances(?) list: ");
                String s = bufferedReader.readLine();

                String result = Result.isBalanced(s);

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
