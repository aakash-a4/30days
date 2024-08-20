//{ Driver Code Starts
//Initial Template for Java


import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class GfG {

	static Node buildTree(String str) {

		if (str.length() == 0 || str.charAt(0) == 'N') {
			return null;
		}

		String ip[] = str.split(" ");
		// Create the root of the tree
		Node root = new Node(Integer.parseInt(ip[0]));
		// Push the root to the queue

		Queue<Node> queue = new LinkedList<>();

		queue.add(root);
		// Starting from the second element

		int i = 1;
		while (queue.size() > 0 && i < ip.length) {

			// Get and remove the front of the queue
			Node currNode = queue.peek();
			queue.remove();

			// Get the current node's value from the string
			String currVal = ip[i];

			// If the left child is not null
			if (!currVal.equals("N")) {

				// Create the left child for the current node
				currNode.left = new Node(Integer.parseInt(currVal));
				// Push it to the queue
				queue.add(currNode.left);
			}

			// For the right child
			i++;
			if (i >= ip.length)
				break;

			currVal = ip[i];

			// If the right child is not null
			if (!currVal.equals("N")) {

				// Create the right child for the current node
				currNode.right = new Node(Integer.parseInt(currVal));

				// Push it to the queue
				queue.add(currNode.right);
			}
			i++;
		}

		return root;
	}

	static void printInorder(Node root) {
		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");

		printInorder(root.right);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			String s = br.readLine();
			int target = Integer.parseInt(br.readLine());
			Node root = buildTree(s);

			Solution g = new Solution();
			System.out.println(g.minTime(root, target));
			t--;

		}
	}
}



// } Driver Code Ends


//User function Template for Java

class Solution {
    // Function to find the parent of each node and return the target node
    private static Node mapParents(Node root, int target, Map<Node, Node> parentMap) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        Node targetNode = null;

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            
            if (current.data == target) {
                targetNode = current;
            }
            
            if (current.left != null) {
                parentMap.put(current.left, current);
                queue.offer(current.left);
            }
            if (current.right != null) {
                parentMap.put(current.right, current);
                queue.offer(current.right);
            }
        }

        return targetNode;
    }

    public static int minTime(Node root, int target) {
        if (root == null) return 0;

        // Map to store the parent of each node
        Map<Node, Node> parentMap = new HashMap<>();
        Node targetNode = mapParents(root, target, parentMap);

        // BFS to simulate the burning process
        Map<Node, Boolean> visited = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(targetNode);
        visited.put(targetNode, true);

        int time = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean flag = false; // To track if any node is burned at this level

            for (int i = 0; i < size; i++) {
                Node current = queue.poll();

                // Check left child
                if (current.left != null && !visited.getOrDefault(current.left, false)) {
                    queue.offer(current.left);
                    visited.put(current.left, true);
                    flag = true;
                }

                // Check right child
                if (current.right != null && !visited.getOrDefault(current.right, false)) {
                    queue.offer(current.right);
                    visited.put(current.right, true);
                    flag = true;
                }

                // Check parent
                Node parent = parentMap.get(current);
                if (parent != null && !visited.getOrDefault(parent, false)) {
                    queue.offer(parent);
                    visited.put(parent, true);
                    flag = true;
                }
            }

            if (flag) {
                time++;
            }
        }

        return time;
    }
}
