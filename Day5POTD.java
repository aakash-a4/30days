//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.util.*;

public class validip {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();

            if (obj.isValid(s))
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    public boolean isValid(String str) {
        // Split the string by '.'
        String[] parts = str.split("\\.");
        
        // There should be exactly 4 parts
        if (parts.length != 4) {
            return false;
        }
        
        for (String part : parts) {
            // Check if part is an integer and within the range 0-255
            if (!isValidPart(part)) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean isValidPart(String part) {
        try {
            // Part should be a valid integer
            int num = Integer.parseInt(part);
            
            // Check if the integer is within the valid range
            if (num < 0 || num > 255) {
                return false;
            }
            
            // Check for leading zeros
            if (part.length() > 1 && part.charAt(0) == '0') {
                return false;
            }
            
            return true;
        } catch (NumberFormatException e) {
            // If part is not a valid integer
            return false;
        }
    }
}
