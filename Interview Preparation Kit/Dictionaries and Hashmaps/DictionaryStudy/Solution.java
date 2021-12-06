import java.io.*;
import java.util.Hashtable;

public class Solution {
    
    public static void main(String[] args) throws IOException {
        Hashtable<Integer, Integer> dict = new Hashtable<>();
        dict.put(1, 1);
        dict.put(2, 1);
        dict.put(3, 1);
        dict.put(4, 1);
        

        System.out.println("First set: " + dict);

        dict.replace(3, 2);
        dict.replace(2, dict.get(2)+1);
        dict.put(4,1);

        System.out.println("Second set: " + dict);

        if(dict.containsKey(2))
            System.out.println("Record found");
    }
}
