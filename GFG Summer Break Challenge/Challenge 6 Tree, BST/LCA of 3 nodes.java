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
    
                int p;
                p = Integer.parseInt(br.readLine());
    
                int q;
                q = Integer.parseInt(br.readLine());
    
                int r;
                r = Integer.parseInt(br.readLine());
    
                Solution obj = new Solution();
                int lca = obj.lca3Nodes(root, p, q, r);
                System.out.println(lca);
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
        public static int lca3Nodes(Node root, int p, int q, int r) {
            // code here
            int max=p, min=p;
            if(p>q && p>r) max=p;
            else if(q>r) max=q;
            else max=r;
            
            if(p<q && p<r) min=p;
            else if(q<r) min=q;
            else min=r;
            
            Node cur = LCA(root, max, min);
            return cur.data;
        }
        
        public static Node LCA(Node root, int n1, int n2)
        {
            // code here.    
            if(root == null) return null;
            int cur = root.data;
            if(cur < n1 && cur < n2){
                return LCA(root.right,n1,n2);
            }
            if(cur>n1 && cur>n2){
                return LCA(root.left,n1,n2);
            }
            return root;
        }
    }
    