import java.io.*;

class Result {
    public static String timeConversion(String s) {
        boolean pM = false;
        int hourPart;
        if (s.substring(8,10).equals("PM"))
            pM = true;
        
        hourPart = Integer.parseInt(s.substring(0,2));
        if (pM) {
            if (hourPart != 12)
                hourPart += 12;
        }
        else if (hourPart == 12){
            hourPart = 0;
        }
        s = hourPart + s.substring(2, 8);
        if (s.length()==7)
            s = "0" + s;
        return s;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
