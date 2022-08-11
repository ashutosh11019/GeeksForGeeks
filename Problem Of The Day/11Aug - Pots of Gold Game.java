//{ Driver Code Starts
    import java.util.*;
    import java.lang.Math;
    class Pots{
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-- > 0)
            {
                int n = sc.nextInt();
                int[] a =new  int[n];
                for(int i=0;i<n;i++)
                {
                    a[i] = sc.nextInt();
                }
                GfG g = new GfG();
                System.out.println(g.maxCoins(a,n));
                
            }
        }
    }
    // } Driver Code Ends
    
    
    /*Complete the function below*/
    class GfG
    {
        static int[][] dp;
        public static int maxCoins(int A[],int n)
        {
              //add code here.
            dp = new int[n+1][n+1];
            return help(A, 0, n-1);
        }
        
        public static int help(int arr[], int i, int j){
            if(i==j) return arr[i];
            if((i+1) == j) return Math.max(arr[i], arr[j]);
            if(dp[i][j]==0){
                int x = arr[i]+Math.min(help(arr, i+2, j), help(arr, i+1, j-1));
                int y = arr[j]+Math.min(help(arr, i+1, j-1), help(arr, i, j-2));
                dp[i][j]=Math.max(x, y);
            }
            return dp[i][j];
        }
    }