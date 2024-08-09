//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String line = in.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            // int key = Integer.parseInt(in.readLine().trim());

            out.println(new Solution().Maximize(arr));
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    static final int MOD = 1000000007; // Modulo value

    int Maximize(int arr[]) {
        int n = arr.length;

        // Sort the array in ascending order
        Arrays.sort(arr);

        // Initialize sum as long to handle potential overflow
        long sum = 0;

        // Sum the elements after multiplying by their index
        for (int i = 0; i < n; i++) {
            sum = (sum + (long) arr[i] * i) % MOD;
        }

        // Return the sum modulo MOD
        return (int) sum;
    }
}
