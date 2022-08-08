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
    
                int N;
                N = Integer.parseInt(br.readLine());
    
                int[] A = IntArray.input(br, N);
    
                Solution obj = new Solution();
                long res = obj.maximumMultiple(N, A);
    
                System.out.println(res);
            }
        }
    }
    // } Driver Code Ends
    
    
    
    
    class Solution {
        public static long maximumMultiple(int N, int[] A) {
            // code here
            ArrayList<Long> pos = new ArrayList<>();
            ArrayList<Long> neg = new ArrayList<>();
            for(int i=0;i<N;i++){
                if(A[i]<0) neg.add((long)A[i]);
                else pos.add((long)A[i]);
            }
            
            Collections.sort(pos);
            Collections.sort(neg);
            int m=neg.size(), n=pos.size();
            if(m==n){
                long max=Long.MIN_VALUE;
                for(int i=0;i<n;i++){
                    long prod=neg.get(i)*pos.get(i);
                    if(prod>max) max=prod;
                }
                return max;
            }else if(m>n){
                long max=Long.MIN_VALUE;
                int size = (m-n)/2;
                for(int i=n;i<(size+n);i++){
                    long prod=neg.get(i)*neg.get(m-i+n-1);
                    if(prod>max) max=prod;
                }
                return max;
            }else{
                long max=Long.MIN_VALUE;
                int size = (n-m)/2;
                for(int i=0;i<size;i++){
                    long prod=pos.get(i)*pos.get(n-m-i-1);
                    if(prod>max) max=prod;
                }
                return max;
            }
        }
    }
    