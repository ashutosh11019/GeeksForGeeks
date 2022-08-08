// { Driver Code Starts
    import java.io.*;
    import java.util.*;
    
    
    class IntArray
    {
        public static int[] input(BufferedReader br, int n) throws IOException
        {
            String[] s = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for(int i = 0; i < n; i++)
                a[i] = Integer.parseInt(s[i]);
    
            return a;
        }
    
        public static void print(int[] a)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    
        public static void print(ArrayList<Integer> a)
        {
            PrintWriter out=new PrintWriter(System.out);
            for(int e : a)
                out.print(e + " ");
            out.println();
            out.flush();
        }
    }
    
    
    class IntMatrix
    {
        public static int[][] input(BufferedReader br, int n, int m) throws IOException
        {
            int[][] mat = new int[n][];
    
            for(int i = 0; i < n; i++)
            {
                String[] s = br.readLine().trim().split(" ");
                mat[i] = new int[s.length];
                for(int j = 0; j < s.length; j++)
                    mat[i][j] = Integer.parseInt(s[j]);
            }
    
            return mat;
        }
    
        public static void print(int[][] m)
        {
            for(var a : m)
            {
                for(int e : a)
                    System.out.print(e + " ");
                System.out.println();
            }
        }
    
        public static void print(ArrayList<ArrayList<Integer>> m)
        {
            PrintWriter out=new PrintWriter(System.out);
            for(var a : m)
            {
                for(int e : a)
                    out.print(e + " ");
                out.println();
                out.flush();
            }
        }
    }
    
    class GFG {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t;
            t = Integer.parseInt(br.readLine());
            while(t-- > 0){
                
                int[] a = IntArray.input(br, 3);
                
                
                int[][] vec = IntMatrix.input(br, a[2], 4);
                
                Solution obj = new Solution();
                ArrayList<ArrayList<Integer>> res = obj.setMatrix(a[0],a[1],a[2], vec);
                
                IntMatrix.print(res);
                
            }
        }
    }
    // } Driver Code Ends
    
    
    class Solution {
        public static ArrayList<ArrayList<Integer>> setMatrix(int n,int m,int q, int[][] Queries) {
            int a[][]=new int[n][m];
            for(int i=0;i<q;i++){
                int x1 = Queries[i][0];
                int y1 = Queries[i][1];
                int x2 = Queries[i][2];
                int y2 = Queries[i][3];
                x1--;
                y1--;
                x2--;
                y2--;
                a[x1][y1]++;
                if(y2 +1 < m){
                    a[x1][y2+1]--;
                }
                if(x2 + 1 < n){
                    a[x2+1][y1]--;
                }
                if(x2 + 1 < n && y2 + 1 < m){
                    a[x2+1][y2+1]++;
                }
            }
          
            for(int i=0;i<n;i++){
                for(int j=1;j<m;j++){
                    a[i][j]+=a[i][j-1];
                }
            }
            for(int i=1;i<n;i++){
                for(int j = 0;j<m;j++){
                    a[i][j]+= a[i-1][j];
                }
            }
            ArrayList<ArrayList<Integer>> res=new ArrayList<>();
            for(int i=0;i<n;i++){
                ArrayList<Integer> l=new ArrayList<>();
                for(int j=0;j<m;j++){
                    l.add(a[i][j]);
                }
                res.add(l);
            }
            return res;
            
            // int [][]ans= new int[n][n];
            // code here
            // int arr[][] = new int[n][m];
            // ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            // for(int j=0;j<n;j++){
            //     ArrayList<Integer> sub = new ArrayList<>();
            //     for(int k=0;k<m;k++){
            //         sub.add(0);
            //     }
            //     list.add(sub);
            // }
            // for(int i=0;i<q;i++){
            //     int x1=vec[i][0];
            //     int y1=vec[i][1];
            //     int x2=vec[i][2];
            //     int y2=vec[i][3];
            //     // System.out.println(x1+" "+y1+" "+x2+" "+y2);
            //     for(int j=x1-1;j<x2;j++){
            //         for(int k=y1-1;k<y2;k++){
            //             // arr[j][k]+=1;
            //             int val=list.get(j).get(k)+1;
            //             list.get(j).set(k,val);
            //         }
            //     }
            // }
            // // ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            // // for(int j=0;j<n;j++){
            // //     ArrayList<Integer> sub = new ArrayList<>();
            // //     for(int k=0;k<m;k++){
            // //         // System.out.print(arr[j][k]);
            // //         sub.add(arr[j][k]);
            // //     }
            // //     list.add(sub);
            // //     // System.out.println();
            // // }
            // return list;
        }
    }
            
    