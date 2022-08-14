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
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
    
    class GFG {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t;
            t = Integer.parseInt(br.readLine());
            while(t-- > 0){
                
                int N;
                N = Integer.parseInt(br.readLine());
                
                
                String S;
                S = br.readLine();
                
                
                int[] P = IntArray.input(br, N);
                
                Solution obj = new Solution();
                int res = obj.getMinimumDays(N, S, P);
                
                System.out.println(res);
                
            }
        }
    }
    // } Driver Code Ends
    
    
    class Solution {
        public static int getMinimumDays(int N, String S, int[] P) {
            // code here
            int c=0;
            for(int i=0;i<N-1;i++){
                if(S.charAt(i) == S.charAt(i+1)) c++;
            }
            if(c==0) return 0;
            StringBuilder sb = new StringBuilder(S);
            for(int i=0;i<N;i++){
                if(P[i] > 0 && sb.charAt(P[i]) == sb.charAt(P[i]-1)) c--;
                if(P[i] < (N-1) && sb.charAt(P[i]) == sb.charAt(P[i]+1)) c--;
                sb.setCharAt(P[i], '?');
                if(c==0) return i+1;
            }
            return -1;
        }
    }
            
    