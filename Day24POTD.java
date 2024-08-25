//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int x[] = new int[str.length];
            for (int i = 0; i < str.length; i++) x[i] = Integer.parseInt(str[i]);
            str = (br.readLine()).trim().split(" ");
            int[] y = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                y[i] = Integer.parseInt(str[i]);
            }
            System.out.println(new Solution().countPairs(x, y, x.length, y.length));
        }
    }
}

// } Driver Code Ends


//Back-end complete function Template for Java

class Solution {
    // Function to count number of pairs such that x^y is greater than y^x.
    public long countPairs(int x[], int y[], int M, int N) {
        // Frequency array for y[]
        int[] count = new int[1005];
        for (int i = 0; i < N; i++) {
            count[y[i]]++;
        }

        // Sort array y[] for binary search
        Arrays.sort(y);

        long totalPairs = 0;

        for (int i = 0; i < M; i++) {
            totalPairs += countValidPairs(x[i], y, count);
        }

        return totalPairs;
    }

    // Function to count valid pairs for a specific x
    private long countValidPairs(int x, int[] y, int[] count) {
        if (x == 0) return 0; // No valid pairs when x is 0
        if (x == 1) return count[0]; // Only valid with y = 0

        // Find the first element in y[] greater than x
        int index = upperBound(y, x);

        long pairs = y.length - index; // Elements in y[] greater than x

        // Add special cases
        pairs += count[1]; // Pairs with y=1 are valid when x > 1

        if (x == 2) {
            // Exclude pairs with y=3 and y=4 for x=2
            pairs -= (count[3] + count[4]);
        }

        if (x == 3) {
            // Include pairs with y=2 for x=3
            pairs += count[2];
        }

        return pairs;
    }

    // Function to find the upper bound (first element greater than x)
    private int upperBound(int[] y, int x) {
        int low = 0, high = y.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (y[mid] > x) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
