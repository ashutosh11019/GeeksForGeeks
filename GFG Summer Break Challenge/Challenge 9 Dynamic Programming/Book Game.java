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
    
                int[] points = IntArray.input(br, n);
    
                Solution obj = new Solution();
                long res = obj.maxScore(n, points);
    
                System.out.println(res);
            }
        }
    }
    // } Driver Code Ends
    
    
    class Solution {
        public static long maxScore(int n, int[] points) {
            // code here
            int[] dp = new int[n+1];
            int i=n-1, j, sum, val;
            while(i>=0){
                j=i+1;
                sum=points[i]+j;
                if(sum>n) dp[j]=points[i];
                else dp[j]=points[i]+dp[sum];
                i--;
            }
            int max = Integer.MIN_VALUE;
            for(int k=0;k<=n;k++){
                if(max<dp[k]) max=dp[k];
            }
            return max;
        }
    }
    