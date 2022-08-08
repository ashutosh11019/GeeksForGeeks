// { Driver Code Starts
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
    
        public static Node buildTree(String str) {
            // Corner Case
            if (str.length() == 0 || str.charAt(0) == 'N') return null;
    
            // Creating array of Strings from input
            // String after spliting by space
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
                if (i >= ip.length) break;
    
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
    
        public static Node inputTree(BufferedReader br) throws IOException {
            return buildTree(br.readLine().trim());
        }
    
        public static void inorder(Node root) {
            if (root == null) return;
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }
    
    class GFG {
        public static void main(String[] args) throws IOException {
            BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
            int t;
            t = Integer.parseInt(br.readLine());
            while (t-- > 0) {
    
                Node root = Node.inputTree(br);
    
                Solution obj = new Solution();
                int res = obj.maxSubtreeAll1s(root);
    
                System.out.println(res);
            }
        }
    }
    // } Driver Code Ends
    
    
    /*
    
    Definition for Binary Tree Node
    class Node
    {
        int data;
        Node left;
        Node right;
    
        Node(int data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    }
    */
    
    class Solution {
        static int c=0;
        public static int maxSubtreeAll1s(Node root) {
            // code here
            c=0;
            int val = helper(root);
            return c;
        }
        
        public static int helper(Node root){
            if(root == null) return 0;
            if(root.data == 1){
                int lt = helper(root.left);
                int rt = helper(root.right);
                int val = 1+lt+rt;
                if(c<val) c=val;
                return val;
            }else{
                int lt = helper(root.left);
                int rt = helper(root.right);
                return 0;
            }
        }
    }
    