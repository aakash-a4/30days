//{ Driver Code Starts
import java.util.*;

public class GFG {
    // Function to check if v2 is a subsequence of v1
    public static boolean isSubSequence(int[] v1, int[] v2) {
        int m = v2.length;
        int n = v1.length;
        int j = 0; // For index of v2

        // Traverse v1 and v2
        for (int i = 0; i < n && j < m; i++) {
            if (v1[i] == v2[j]) {
                j++;
            }
        }
        return j == m;
    }

    // Driver code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String[] input = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
            int n = arr.length;
            Solution obj = new Solution();
            List<Integer> res = obj.find3Numbers(arr);
            if (!res.isEmpty() && res.size() != 3) {
                System.out.println(-1);
            } else {
                int[] resArray = res.stream().mapToInt(Integer::intValue).toArray();
                if (resArray.length == 0) {
                    System.out.println(0);
                } else if (resArray[0] < resArray[1] && resArray[1] < resArray[2] &&
                           isSubSequence(arr, resArray)) {
                    System.out.println(1);
                } else {
                    System.out.println(-1);
                }
            }
        }
        sc.close();
    }
}

// } Driver Code Ends

class Solution {
    List<Integer> find3Numbers(int arr[]) {
        int n = arr.length; // Determine the length of the array
        
        // Arrays to store the smallest and greatest elements on the left and right
        int[] smaller = new int[n];
        int[] greater = new int[n];
        
        smaller[0] = -1; // No element on the left of the first element
        int minIndex = 0; // Index of the smallest element so far
        
        for (int i = 1; i < n; i++) {
            if (arr[i] <= arr[minIndex]) {
                minIndex = i;
                smaller[i] = -1;
            } else {
                smaller[i] = minIndex;
            }
        }
        
        greater[n - 1] = -1; // No element on the right of the last element
        int maxIndex = n - 1; // Index of the greatest element so far
        
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= arr[maxIndex]) {
                maxIndex = i;
                greater[i] = -1;
            } else {
                greater[i] = maxIndex;
            }
        }
        
        // Find a triplet (i, j, k) such that arr[i] < arr[j] < arr[k] and i < j < k
        for (int j = 0; j < n; j++) {
            if (smaller[j] != -1 && greater[j] != -1) {
                return Arrays.asList(arr[smaller[j]], arr[j], arr[greater[j]]);
            }
        }
        
        // No such triplet found
        return new ArrayList<>();
    }
}




