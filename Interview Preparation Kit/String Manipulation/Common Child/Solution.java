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
    public static int commonChild(String s1, String s2) {
        Hashtable<String, Integer> childs1 = getChilds(s1);
        Hashtable<String, Integer> childs2 = getChilds(s2);
        int result = 0;
        for (String key : childs1.keySet()) {
            if(childs2.containsKey(key))
                if(key.length()>result)
                    result=key.length();
        }
        return result;
    }

    private static Hashtable<String, Integer> getChilds(String s){
        Hashtable<String, Integer> ht = new Hashtable<>();
        String child="";
        for(int i = 0; i<s.length(); i++){
            for(int j=0; j<s.length()-i;j++){
                //ht.putIfAbsent(s.substring(j, j+i), 1);
                child = "";
                for (int k = 0; k < i; k++) {
                    child+= s.substring(k + j, k + j + 1) + k;
                }
                System.out.println(child);
            }
        }
        System.out.println(ht);
        return ht;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s1 = bufferedReader.readLine();

        String s2 = bufferedReader.readLine();

        int result = Result.commonChild(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
