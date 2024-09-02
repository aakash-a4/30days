//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.minimumCostPath(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class Solution {
    public int minimumCostPath(int[][] grid) {
        int n = grid.length;
        int[][] dist = new int[n][n];
        int[] dx = {-1, 1, 0, 0}; // direction vectors for up, down, left, right
        int[] dy = {0, 0, -1, 1};

        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // Priority Queue to store (cost, x, y)
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        dist[0][0] = grid[0][0];
        pq.add(new int[]{dist[0][0], 0, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int cost = current[0], x = current[1], y = current[2];

            // If we've reached the bottom-right cell, return the cost
            if (x == n - 1 && y == n - 1) {
                return cost;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    int newCost = cost + grid[nx][ny];
                    if (newCost < dist[nx][ny]) {
                        dist[nx][ny] = newCost;
                        pq.add(new int[]{newCost, nx, ny});
                    }
                }
            }
        }

        return dist[n - 1][n - 1];
    }
}
