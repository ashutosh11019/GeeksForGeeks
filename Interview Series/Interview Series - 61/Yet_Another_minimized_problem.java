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
                
                
                int[] start = IntArray.input(br, n);
                
                
                int[] end = IntArray.input(br, n);
                
                Solution obj = new Solution();
                int res = obj.minimumRooms(n, start, end);
                
                System.out.println(res);
                
            }
        }
    }
    // } Driver Code Ends
    
    
    class Solution {
        public static int minimumRooms(int n, int[] start, int[] end) {
            // code here
            Arrays.sort(start);
            Arrays.sort(end);
            int max=0;
            int count=0;
            int i=0;
            int j=0;
            while(i<n)
            {
                 if(end[j]>=start[i])
                 {
                     count++;
                     if(count>max)
                     {
                         max=count;
                     }
                     i++;
                 }
                 else
                 {
                     count--;
                     j++;
                 }
                 
            }
            return max;
        }
    }
            
    