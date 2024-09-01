//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // consume the remaining newline

        for (int k = 0; k < t; k++) {
            List<Integer> arr1 = new ArrayList<>();
            String input = sc.nextLine();
            Scanner lineScanner = new Scanner(input);
            while (lineScanner.hasNextInt()) {
                arr1.add(lineScanner.nextInt());
            }
            lineScanner.close();

            List<Integer> arr2 = new ArrayList<>();
            input = sc.nextLine();
            lineScanner = new Scanner(input);
            while (lineScanner.hasNextInt()) {
                arr2.add(lineScanner.nextInt());
            }
            lineScanner.close();

            Solution ob = new Solution();
            int ans = ob.maxPathSum(arr1, arr2);
            System.out.println(ans);
        }

        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    // Function to find the maximum sum path in two arrays
    public int maxPathSum(List<Integer> arr1List, List<Integer> arr2List) {
        int m = arr1List.size();
        int n = arr2List.size();

        int i = 0, j = 0;
        int sum1 = 0, sum2 = 0;
        int result = 0;

        // Traverse both arrays
        while (i < m && j < n) {
            if (arr1List.get(i) < arr2List.get(j)) {
                sum1 += arr1List.get(i++);
            } else if (arr1List.get(i) > arr2List.get(j)) {
                sum2 += arr2List.get(j++);
            } else { // Both elements are the same
                // Take the maximum sum path and add to result
                result += Math.max(sum1, sum2) + arr1List.get(i);
                i++;
                j++;
                // Reset the sums
                sum1 = 0;
                sum2 = 0;
            }
        }

        // Add remaining elements of arr1
        while (i < m) {
            sum1 += arr1List.get(i++);
        }

        // Add remaining elements of arr2
        while (j < n) {
            sum2 += arr2List.get(j++);
        }

        // Add the maximum of the remaining sums to result
        result += Math.max(sum1, sum2);

        return result;
    }
}
