// { Driver Code Starts
    import java.io.*;
    import java.util.*;
    
    
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
            for(var a : m)
            {
                for(int e : a)
                    System.out.print(e + " ");
                System.out.println();
            }
        }
    }
    
    
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
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
    
    class GFG {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out=new PrintWriter(System.out);
            int t;
            t = Integer.parseInt(br.readLine());
            while(t-- > 0){
                
                int A[]=IntArray.input(br,2);
                int n;
                n = A[0];
                
                
                int m;
                m = A[1];
                
                
                int[][] mat = IntMatrix.input(br, n, m);
                
                
                int q;
                q = Integer.parseInt(br.readLine());
                
                
                int[][] vec = IntMatrix.input(br, q, 5);
                
                Solution obj = new Solution();
                ArrayList<Integer> res = obj.matSearch(n, m, mat, q, vec);
                
                
                for(int i : res){
                    out.print(i==1?"True ":"False ");
                }
                out.println();
                
                
            }
            out.close();
        }
    }
    // } Driver Code Ends
    
    
    class Solution {
        public static ArrayList<Integer> matSearch(int n, int m, int[][] mat, int q, int[][] vec) {
            // code here
            ArrayList<Integer> arr = new ArrayList<>();
            
            for(int i=0;i<q;i++){
                int x1=vec[i][0];
                int y1=vec[i][1];
                int x2=vec[i][2];
                int y2=vec[i][3];
                int k=vec[i][4];
                
                // System.out.println(x1+" "+x2+" "+y1+" "+y2+" "+k);
                
                if(mat[x1][y1]>k || mat[x2][y2]<k) arr.add(0);
                else{
                    int low=x1, high=y2, index=0;
                    // for(int j=x1;j<=x2;j++){
                    //     if(mat[j][y1]<=k && mat[j][y2]>=k){
                    //         index=j;
                    //         break;
                    //     }
                    // }
                    // System.out.println(index);
                    int flag=0;
                    while(high >= y1 && low <= x2) {
                        if(k == mat[low][high]) {
                            arr.add(1);
                            flag=1;
                            break;
                            // return true;
                        } else if(k < mat[low][high]) {
                            high--;
                        } else if(k > mat[low][high]) {
                            low++;
                        }
                    }
                    // for(int j=y1;j<=y2;j++){
                    //     if(mat[index][j]==k){
                    //         flag=1;
                    //         arr.add(1);
                    //         break;
                    //     }
                    // }
                    // while(low<=high){
                    //     int mid=low+(high-low)/2;
                    //     if(mat[index][mid]==k){
                    //         arr.add(1);
                    //         flag=1;
                    //         break;
                    //     }
                    //     else if(mat[index][mid]<k){
                    //         low=mid+1;
                    //     }else{
                    //         high=mid-1;
                    //     }
                    // }
                    if(flag==0) arr.add(0);
                }
                
            }
            
            return arr;
        }
    }
            
    
