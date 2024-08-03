//***Candidate Identification: First, identify a candidate who could be a celebrity. This can be done in O(n) time.
//Validation: Validate if the identified candidate is indeed a celebrity. This requires another O(n) time.
//The idea is to use two pointers technique to identify the candidate and then verify the candidate by checking the matrix.

//Steps:
//Initialize two pointers: Start with two pointers, one at the beginning and one at the end of the matrix.
//Identify the candidate: Move the pointers towards each other. If person i knows person j, then i cannot be a celebrity, move i forward. If person i does not know person j, then j cannot be a celebrity, move j backward. Continue this until the pointers meet.
//Validate the candidate: Check if the identified candidate knows no one and everyone knows the candidate.
//Here's the implementation of the solution:***

  
class Solution {
    // Function to find if there is a celebrity in the party or not.
    public int celebrity(int mat[][]) {
        int n = mat.length;
        int candidate = 0;

        // Step 1: Find the candidate
        for (int i = 1; i < n; i++) {
            if (mat[candidate][i] == 1) {
                // Candidate knows i, candidate can't be a celebrity, i might be
                candidate = i;
            }
        }

        // Step 2: Validate the candidate
        for (int i = 0; i < n; i++) {
            if (i != candidate && (mat[candidate][i] == 1 || mat[i][candidate] == 0)) {
                return -1;
            }
        }

        return candidate;
    }
}

// Example usage
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] mat1 = { {0, 1, 0}, {0, 0, 0}, {0, 1, 0} };
        System.out.println(solution.celebrity(mat1)); // Output: 1
        
        int[][] mat2 = { {0, 1}, {1, 0} };
        System.out.println(solution.celebrity(mat2)); // Output: -1
    }
}
//Explanation:
//Identify the Candidate: We iterate through the people. If the current candidate knows the next person, we update the candidate. By the end of this loop, we will have one candidate.
//Validate the Candidate: Check if this candidate doesn't know anyone and everyone knows this candidate. If any of these conditions fail, return -1.
