class Solution
{
    // Function to return a list containing the bottom view of the given tree.
    public ArrayList<Integer> bottomView(Node root)
    {
        // Result list
        ArrayList<Integer> result = new ArrayList<>();
        
        if (root == null)
            return result;
        
        // TreeMap to store horizontal distance and the corresponding node's value
        TreeMap<Integer, Integer> map = new TreeMap<>();
        // Queue for level order traversal. Stores pairs of node and horizontal distance
        Queue<Pair> queue = new LinkedList<>();
        
        // Start with the root node at horizontal distance 0
        queue.add(new Pair(root, 0));
        
        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            Node node = curr.node;
            int hd = curr.hd;
            
            // Update the map with the node's value at its horizontal distance
            map.put(hd, node.data);
            
            // Add left child to the queue with horizontal distance - 1
            if (node.left != null) {
                queue.add(new Pair(node.left, hd - 1));
            }
            
            // Add right child to the queue with horizontal distance + 1
            if (node.right != null) {
                queue.add(new Pair(node.right, hd + 1));
            }
        }
        
        // Collecting the bottom view nodes from the map
        for (Integer value : map.values()) {
            result.add(value);
        }
        
        return result;
    }
    
    // Helper class to store node and its horizontal distance
    class Pair {
        Node node;
        int hd;
        
        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }
}
