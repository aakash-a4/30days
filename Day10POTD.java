//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}




class Solution {
    // Function to rotate a linked list.
    public Node rotate(Node head, int k) {
        if (head == null || k == 0) return head;
        
        // Step 1: Compute the length of the linked list
        Node current = head;
        int length = 1;  // start with 1 because we are at head
        while (current.next != null) {
            current = current.next;
            length++;
        }
        
        // Step 2: Handle the case where k is greater than the length
        k = k % length;
        if (k == 0) return head;  // No need to rotate
        
        // Step 3: Find the new tail, which is at the (k-1) position
        Node newTail = head;
        for (int i = 1; i < k; i++) {
            newTail = newTail.next;
        }
        
        // Step 4: The new head is the next of the new tail
        Node newHead = newTail.next;
        
        // Step 5: Break the loop
        newTail.next = null;
        
        // Step 6: Connect the old tail to the old head
        current.next = head;
        
        return newHead;
    }
}


//{ Driver Code Starts.

public class GFG {
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = br.readLine().trim();
            if (!input.isEmpty()) {
                String[] numbers = input.split("\\s+");
                for (String num : numbers) {
                    if (!num.isEmpty()) {
                        arr.add(Integer.parseInt(num));
                    }
                }
            }

            Node head = null;
            if (!arr.isEmpty()) {
                head = new Node(arr.get(0));
                Node tail = head;
                for (int i = 1; i < arr.size(); ++i) {
                    tail.next = new Node(arr.get(i));
                    tail = tail.next;
                }
            }
            int k = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            head = ob.rotate(head, k);
            printList(head);
        }
    }
}

// } Driver Code Ends
