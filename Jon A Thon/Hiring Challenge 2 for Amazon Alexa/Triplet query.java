// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class IntMatrix {
    public static int[][] input(BufferedReader br, int n, int m) throws IOException {
        int[][] mat = new int[n][];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for (int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }
}

class StringArray {
    public static String[] input(BufferedReader br, int n) throws IOException {
        String A[] = new String[n];
        for (int i = 0; i < n; i++) A[i] = br.readLine().trim();
        return A;
    }

    public static void print(String[] a) {
        for (String e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<String> a) {
        for (String e : a) System.out.println(e);
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
            String[] str = br.readLine().trim().split(" ");
            int N;
            N = Integer.parseInt(str[0]);

            int M;
            M = Integer.parseInt(str[1]);

            int Q;
            Q = Integer.parseInt(str[2]);

            String col;
            col = br.readLine();

            int[][] Edge = IntMatrix.input(br, M, 2);

            String[] query = StringArray.input(br, Q);

            Solution obj = new Solution();
            ArrayList<String> res = obj.solve(N, M, Q, col, Edge, query);
            for (String ss : res) {
                out.println(ss);
            }
        }
        out.close();
    }
}
// Position this line where user code will be pasted.// } Driver Code Ends


// User function Template for Java
class Solution {
    public static ArrayList<String> solve(int N, int M, int Q, String col,
                                   int[][] Edge, String[] query) {
        // add your code here
        int dp[][][] = new int[26][26][26];
        ArrayList<Integer>[] adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for(int[] it: Edge){
            adj[it[0]].add(it[1]);
            adj[it[1]].add(it[0]);
        }
        
        int vis[] = new int[N];
        for(int i=0;i<N;i++){
            if(vis[i]==0){
                Set<Character> st = new HashSet<>();
                dfs(i, adj, vis, col, st);
                for(int n: st){
                    for(int num: st){
                        dp[col.charAt(i)-'a'][n-'a'][num-'a']=1;
                    }
                }
            }
        }
        
        ArrayList<String> ans = new ArrayList<>();
        for(String str: query){
            char a = (char)(str.charAt(0)-'a');
            char b = (char)(str.charAt(1)-'a');
            char c = (char)(str.charAt(2)-'a');
            if(dp[a][b][c]==1 || dp[a][c][b]==1 || dp[b][a][c]==1 || dp[b][c][a]==1 || 
                dp[c][a][b]==1 || dp[c][b][a]==1) ans.add("YES");
            else ans.add("NO");
        }
        return ans;
    }
    
    public static void dfs(int node, ArrayList<Integer> adj[], int vis[], String col, 
                            Set<Character> st){
        vis[node]=1;
        for(int it: adj[node]){
            if(vis[it]==0 && col.charAt(it)==col.charAt(node)) dfs(it, adj, vis, col, st);
            else if(col.charAt(it)!=col.charAt(node)) st.add(col.charAt(it));
        }
    }
}