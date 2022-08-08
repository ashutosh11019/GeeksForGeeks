// { Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int E = Integer.parseInt(s[0]);
            int V = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i <= V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            int ans = obj.findNumberOfGoodComponent(V, adj);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    static int vertices;
    static int edges;
    public int findNumberOfGoodComponent(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean vis[] = new boolean[V + 1];
        int ans = 0;
        for (int i = 1; i <= V; i++) {
            if (!vis[i]) {
                vertices = 0;
                edges = 0;
                dfs(adj, i, vis);
                edges /= 2;
                if (edges == ((long)vertices * (vertices - 1)) / 2) ans++;
            }
        }
        return ans;
    }

    private static void dfs(ArrayList<ArrayList<Integer>> A, int i, boolean vis[]) {
        vis[i] = true;
        vertices++;
        edges += A.get(i).size();
        for (int child : A.get(i)) {
            if (!vis[child]) {
                dfs(A, child, vis);
            }
        }
    }
}
