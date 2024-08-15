class Solution {
    public Node addOne(Node head) {
        // Reverse the linked list
        head = reverse(head);

        Node temp = head;
        int carry = 1;

        // Traverse the list and add 1
        while (temp != null) {
            int sum = temp.data + carry;
            temp.data = sum % 10;
            carry = sum / 10;
            if (carry == 0) break;
            if (temp.next == null && carry > 0) {
                temp.next = new Node(carry);
                carry = 0;
            }
            temp = temp.next;
        }

        // Reverse the linked list again to restore the original order
        return reverse(head);
    }
    
    // Function to reverse the linked list
    private Node reverse(Node head) {
        Node prev = null, current = head, next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}