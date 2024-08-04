//N meetings in one room
//Difficulty: EasyAccuracy: 45.3%Submissions: 260K+Points: 2
//You are given timings of n meetings in the form of (start[i], end[i]) where start[i] is the start time of meeting i and end[i] is the finish time of meeting i. Return the maximum number of meetings that can be accommodated in a single meeting room, when only one meeting can be held in the meeting room at a particular time. 

//Note: The start time of one chosen meeting can't be equal to the end time of the other chosen meeting.

//Examples :

//Input: n = 6, start[] = [1, 3, 0, 5, 8, 5], end[] =  [2, 4, 6, 7, 9, 9]
//Output: 4
//Explanation: Maximum four meetings can be held with given start and end timings. The meetings are - (1, 2), (3, 4), (5,7) and (8,9)
//Input: n = 3, start[] = [10, 12, 20], end[] = [20, 25, 30]
//Output: 1
//Explanation: Only one meetings can be held with given start and end timings.
//Expected Time Complexity: O(n*logn)
//Expected Auxilliary Space: O(n)

class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int n, int start[], int end[]) {
        // Creating a list of pairs (end time, start time)
        List<int[]> meetings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            meetings.add(new int[]{end[i], start[i]});
        }
        
        // Sorting the meetings based on their end times
        meetings.sort((a, b) -> a[0] - b[0]);
        
        // Initializing the count of meetings and the end time of the last meeting
        int count = 0;
        int lastEndTime = -1;
        
        // Iterating through the sorted meetings
        for (int[] meeting : meetings) {
            if (meeting[1] > lastEndTime) {
                // Selecting the meeting if it starts after the last selected meeting ends
                count++;
                lastEndTime = meeting[0];
            }
        }
        
        return count;
    }
}
