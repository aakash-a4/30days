//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s1 = sc.next();
                    String s2 = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.minOperations(s1,s2));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java



class Solution
{
    // Helper function to find the length of the Longest Common Subsequence (LCS)
    private int lcs(String str1, String str2, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];
        
        // Build the dp table in a bottom-up manner
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        return dp[n][m];
    }

    // Function to find the minimum number of deletions and insertions
	public int minOperations(String str1, String str2) 
	{ 
	    int n = str1.length();
        int m = str2.length();
        
        // Find the length of the Longest Common Subsequence (LCS)
        int lenLCS = lcs(str1, str2, n, m);
        
        // The number of deletions required
        int deletions = n - lenLCS;
        
        // The number of insertions required
        int insertions = m - lenLCS;
        
        // Return the total number of operations (deletions + insertions)
        return deletions + insertions;
	} 
}
