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
                
                int n; 
                n = Integer.parseInt(br.readLine());
                
                
                int[] arr = IntArray.input(br, n);
                
                
                int x; 
                x = Integer.parseInt(br.readLine());
                
                Solution obj = new Solution();
                int res = obj.compressArray(n, arr, x);
                
                System.out.println(res);
                
            }
        }
    }
    // } Driver Code Ends
    
    
    class Solution {
        public static int compressArray(int n, int[] arr, int x) {
            // code here
            Arrays.sort(arr);
            int d=0;
            int s=0;
            for(int i=0;i<n-1;i++){
                if(arr[i]==arr[i+1]){
                    s++;
                }else if(arr[i]<arr[i+1]){
                    int val=arr[i]+x;
                    if(val>=arr[i+1]){
                        d++;
                        d+=s;
                        s=0;
                    }else{
                        s=0;
                    }
                }
            }
            return n-d;
        }
    }
            
    