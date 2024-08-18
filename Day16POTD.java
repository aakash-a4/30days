//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] s = br.readLine().trim().split(" ");

            int[] arr = new int[s.length];
            for (int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(s[i]);

            Solution obj = new Solution();
            boolean res = obj.canSplit(arr);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends

class Solution {
    public boolean canSplit(int[] arr) {
        int totalSum = 0;
        
        // Calculate the total sum of the array
        for (int num : arr) {
            totalSum += num;
        }
        
        // If the total sum is odd, it's impossible to split the array equally
        if (totalSum % 2 != 0) {
            return false;
        }
        
        int halfSum = totalSum / 2;
        int runningSum = 0;
        
        // Iterate through the array and check for the point where running sum equals halfSum
        for (int num : arr) {
            runningSum += num;
            if (runningSum == halfSum) {
                return true;
            }
        }
        
        // If no such point is found, return false
        return false;
    }
}
