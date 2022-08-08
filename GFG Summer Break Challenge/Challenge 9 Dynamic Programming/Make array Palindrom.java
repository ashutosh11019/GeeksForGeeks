// { Driver Code Starts
    import java.io.*;
    import java.util.*;
    
    class IntArray {
        public static int[] input(BufferedReader br, int n) throws IOException {
            String[] s = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);
    
            return a;
        }
    
        public static void print(int[] a) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    
        public static void print(ArrayList<Integer> a) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }
    
    class GFG {
        public static void main(String[] args) throws IOException {
            BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
            int t;
            t = Integer.parseInt(br.readLine());
            while (t-- > 0) {
    
                int n;
                n = Integer.parseInt(br.readLine());
    
                int[] arr = IntArray.input(br, n);
    
                Solution obj = new Solution();
                int res = obj.miniChange(n, arr);
    
                System.out.println(res);
            }
        }
    }
    // } Driver Code Ends
    
    
    class Solution {
        public static int miniChange(int n, int[] arr) {
            // code here
             return n-LPS(n,arr);
        }
        
        public static int LPS(int n, int[] arr){
            int copy[] = new int[n];
            for(int i=0;i<n;i++){
                copy[n-1-i]=arr[i];
            }
            return LCS(n,n,arr,copy);
        }
        
        public static int LCS(int m, int n, int arr[], int copy[]){
            int dp[][] = new int[m+1][n+1];
            for(int i=0;i<m+1;i++){
                for(int j=0;j<n+1;j++){
                    if(i==0 || j==0) dp[i][j]=0;
                }
            }
            
            for(int i=1;i<m+1;i++){
                for(int j=1;j<n+1;j++){
                    if(arr[i-1] == copy[j-1]) dp[i][j]=1+dp[i-1][j-1];
                    else dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
            
            return dp[m][n];
        }
    }
    