// { Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class Node {
    char data;
    Node next;

    Node(char x) {
        data = x;
        next = null;
    }

    public static Node inputList(BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine().trim()); // Length of Linked List

        String[] s = br.readLine().trim().split(" ");
        Node head = new Node((s[0].charAt(0))), tail = head;
        for (int i = 1; i < s.length; i++)
            tail = tail.next = new Node((s[i].charAt(0)));

        return head;
    }

    public static void printList(Node node, PrintWriter out) {
        while (node != null) {
            out.print(node.data + " ");
            node = node.next;
        }
        out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            Node head = Node.inputList(br);

            String S = br.readLine().trim();

            Solution obj = new Solution();
            ArrayList<Node> res = obj.findAnagrams(head, S);

            for (Node node : res) {
                Node temp = node;
                Node.printList(temp, out);
            }
            if (res.size() == 0) {
                out.println("-1");
            }
        }
        out.close();
    }
}// } Driver Code Ends


// User function Template for Java
/*

Definition for singly Link List Node
class Node
{
    char data;
    Node next;

    Node(char x){
        data = x;
        next = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
    public boolean isAna(int A[], int B[]) {
        for (int i = 0; i < 26; i++) {
            if (A[i] != B[i]) return false;
        }
        return true;
    }

    public ArrayList<Node> findAnagrams(Node head, String s) {
        // code here
        int len = s.length();
        int freq[] = new int[26];
        char S[] = s.toCharArray();
        for (char ch : S) {
            freq[ch - 'a']++;
        }
        int freq1[] = new int[26];
        Node ptr1 = head;
        Node ptr2 = head;
        Node prev = null;
        for (int i = 0; i < len && (ptr2 != null); i++) {
            freq1[ptr2.data - 'a']++;
            prev = ptr2;
            ptr2 = ptr2.next;
        }
        ptr2 = prev;

        ArrayList<Node> res = new ArrayList<>();

        while (ptr2.next != null) {
            boolean ok = isAna(freq1, freq);
            if (ok) {
                Node prev1 = null;

                res.add(ptr1);
                Node temp1 = ptr2;
                ptr2 = (ptr2).next;
                if (temp1 != null) temp1.next = null;
                ptr1 = ptr2;
                for (int i = 0; i < 26; i++) freq1[i] = 0;
                for (int i = 0; i < len && (ptr2 != null); i++) {
                    freq1[(ptr2).data - 'a']++;
                    prev1 = (ptr2);
                    if (ptr2 != null) ptr2 = (ptr2).next;
                }

                (ptr2) = prev1;

            } else {
                freq1[ptr1.data - 'a']--;
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
                freq1[ptr2.data - 'a']++;
            }
        }

        boolean ok = isAna(freq1, freq);
        if (ok) {
            res.add(ptr1);
        }

        return res;
    }
}