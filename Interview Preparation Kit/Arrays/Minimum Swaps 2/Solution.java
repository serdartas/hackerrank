import java.io.*;
import java.util.*;

public class Solution {
    static int minimumSwaps(int[] arr) {
        // Method 2: Array always contain values 1...n. so, aim is to have arr[n]=n-1
        // It will iterate through the array for once plus amount of swaps making
        // complexity O(N)
        int i=0;
        int result = 0;
        int swapVal = 0;
        while(i<arr.length){
            if(i+1 != arr[i]){
                swapVal = arr[i];
                arr[i]=arr[swapVal-1];
                arr[swapVal-1]=swapVal;
                result++;
            }

            if(i+1 == arr[i])
                i++;
        }
        return result;
    }
    
    static int minimumSwaps1(int[] arr) {
    // Method 1: Check if array is sorted, if not do a swap and call self
    // Checking if array is sorted is O(N), Doing a swap is O(2N), total 
    // O(3N) ==>O(N) Although 3 can be eliminated in complexity, it's 3 
    // times more complex than O(N) so algorithm is not going to perform
    // well and will timeout or raise runtime error due to use of high 
    // memory in some of the test cases
        if(!isArraySorted(arr))
            return minimumSwaps(swap(arr)) + 1;
        return 0;
    }

    private static int[] swap(int[] arr){
        int firstItem = Integer.MAX_VALUE;
        int swapValue = Integer.MAX_VALUE;
        
        for(int i=1;i<arr.length;i++){
            if(firstItem==Integer.MAX_VALUE && arr[i]<arr[i-1])
                firstItem = i;
            else if(firstItem!=Integer.MAX_VALUE && arr[i]<arr[firstItem])
                firstItem = i;
        }

        for(int i=0;i<arr.length;i++)
            if(arr[firstItem] < arr[i])
            {
                swapValue = arr[i];//2
                arr[i] = arr[firstItem];//4 3 1 4
                arr[firstItem] = swapValue;//2 3 1 4
                break;
            }
        return arr;
    }

    private static boolean isArraySorted(int[] arr){
        for(int i=1;i<arr.length;i++)
            if(arr[i]<arr[i-1])
                return false;
            return true;        
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);
        System.out.println(res);

        scanner.close();
    }
}
