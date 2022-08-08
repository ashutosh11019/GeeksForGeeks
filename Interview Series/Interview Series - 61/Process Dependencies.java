// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class Main
{
    public static void main(String args[])throws Exception
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(in.readLine());
        while(t-->0)
        {
            String s[]=in.readLine().trim().split(" ");
            int e=Integer.parseInt(s[0]);
            int n=Integer.parseInt(s[1]);
            int arr[][]=new int[e][2];
            for(int i=0;i<e;i++){
                s=in.readLine().trim().split(" ");
                arr[i][0]=Integer.parseInt(s[0]);
                arr[i][1]=Integer.parseInt(s[1]);
            }
            Solution ob=new Solution();
            int ans[]=ob.orderProcesses(n, arr);
            HashMap<Integer,Integer> hm=new HashMap<>();
            for(int i=0;i<n;i++){
                hm.put(ans[i],i);
            }
            int q=0;
            for(int i=0;i<e;i++){
                if(hm.get(arr[i][0])>hm.get(arr[i][1])){
                    q=1;
                    break;
                }
            }
            if(q==1)out.println("0");
            else out.println("1");
        }
        out.close();
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    int[] orderProcesses(int V,int dependencies[][])
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        int n=dependencies.length;
        for(int i=0;i<n;i++){
            adj.get(dependencies[i][0]).add(dependencies[i][1]);
        }
        
        Stack<Integer> st = new Stack<Integer>();
        int vis[] = new int[V];
        for(int i=0;i<V;i++){
            if(vis[i]==0) Sort(i,vis,adj,st);
        }
        int topo[] = new int[V];
        int i=0;
        while(!st.isEmpty()){
            topo[i++]=st.pop();
        }
        return topo;
    }
    
    static void Sort(int node, int vis[], ArrayList<ArrayList<Integer>> adj, Stack<Integer> st){
        vis[node]=1;
        for(Integer it: adj.get(node)){
            if(vis[it]==0) Sort(it,vis,adj,st);
        }
        st.push(node);
    }
}