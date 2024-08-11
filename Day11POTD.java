//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}
// } Driver Code Ends


  
class Solution {
    // Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n) {
        // Sort jobs in decreasing order of profit
        Arrays.sort(arr, (a, b) -> (b.profit - a.profit));
        
        // Find the maximum deadline to size the slots array
        int maxDeadline = 0;
        for (Job job : arr) {
            if (job.deadline > maxDeadline) {
                maxDeadline = job.deadline;
            }
        }
        
        // Create slots array to keep track of free slots
        int[] slots = new int[maxDeadline + 1];
        Arrays.fill(slots, -1); // -1 indicates the slot is free
        
        int countJobs = 0, totalProfit = 0;
        
        // Iterate through all jobs
        for (Job job : arr) {
            // Check from the last possible slot for the current job
            for (int j = job.deadline; j > 0; j--) {
                if (slots[j] == -1) { // If the slot is free
                    slots[j] = job.id; // Assign the job to this slot
                    countJobs++;
                    totalProfit += job.profit;
                    break;
                }
            }
        }
        
        return new int[]{countJobs, totalProfit};
    }
}

/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/
