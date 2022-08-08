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
                
                
                int[] a = IntArray.input(br, n);
                
                
                int k; 
                k = Integer.parseInt(br.readLine());
                
                Solution obj = new Solution();
                boolean res = obj.palindromicArray(n, a, k);
                
                String _result_val = (res) ? "Yes" : "No";
                System.out.println(_result_val);
            }
        }
    }
    // } Driver Code Ends
    
    
    class Solution {
        public static boolean palindromicArray(int n, int[] a, int k) {
            // code here
            int i=0, j=n-1;
            while(i<=j){
                if(a[i]==a[j]){
                    i++;
                    j--;
                    continue;
                }
                if(a[i]==k){
                    i++;
                }else if(a[j]==k){
                    j--;
                }else{
                    return false;
                }
            }
            return true;
        }
    }
            
    