//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if (ans.size() == 0)
                System.out.println("-1");
            else {
                for (int i = 0; i < ans.size(); i++) {
                    System.out.print("[");
                    for (int j = 0; j < ans.get(i).size(); j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> currentSolution = new ArrayList<>();
        solveNQueens(n, 0, currentSolution, result);
        return result;
    }

    private void solveNQueens(int n, int row, ArrayList<Integer> currentSolution, ArrayList<ArrayList<Integer>> result) {
        if (row == n) {
            result.add(new ArrayList<>(currentSolution));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(row, col, currentSolution)) {
                currentSolution.add(col + 1);  // Add 1 to match 1-indexed result requirement
                solveNQueens(n, row + 1, currentSolution, result);
                currentSolution.remove(currentSolution.size() - 1);  // Backtrack
            }
        }
    }

    private boolean isSafe(int row, int col, ArrayList<Integer> currentSolution) {
        for (int i = 0; i < row; i++) {
            int placedCol = currentSolution.get(i) - 1;
            if (placedCol == col || Math.abs(placedCol - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }
}
