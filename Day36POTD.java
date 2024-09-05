//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] arr = new int[n - 1];
            for (int i = 0; i < n - 1; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            Solution sln = new Solution();
            System.out.println(sln.missingNumber(n, arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {

    // Note that the size of the array is n-1
    int missingNumber(int n, int arr[]) {
        // Calculate the sum of the first n natural numbers
        int totalSum = n * (n + 1) / 2;
        
        // Calculate the sum of the elements in the array
        int arraySum = 0;
        for (int i = 0; i < n - 1; i++) {
            arraySum += arr[i];
        }
        
        // The missing number is the difference between totalSum and arraySum
        return totalSum - arraySum;
    }
}
