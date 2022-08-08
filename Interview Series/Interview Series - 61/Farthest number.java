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
                
                
                int[] A = IntArray.input(br, N);
                
                Solution obj = new Solution();
                ArrayList<Integer> res = obj.farNumber(N, A);
                
                IntArray.print(res);
                
            }
        }
    }
    // } Driver Code Ends
    
    
    class Solution {
        public static ArrayList<Integer> farNumber(int N, int[] A) {
            // code here
            ArrayList<Integer> list = new ArrayList<>();
            int[] arr = new int[N];
            arr[N - 1] = A[N - 1];
            for (int i = N - 2; i >= 0; i--) {
                arr[i] = Math.min(arr[i + 1], A[i]);
            }
            for (int i = 0; i < N; i++) {
                int low = i + 1, high = N - 1, ans = -1;
     
                while (low <= high) {
                    int mid = (low + high) / 2;
                    if (arr[mid] < A[i]) {
                        ans = mid;
                        low = mid + 1;
                    }
                    else high = mid - 1;
                }
                list.add(ans);
            }
            return list;
        }
    }
            
    