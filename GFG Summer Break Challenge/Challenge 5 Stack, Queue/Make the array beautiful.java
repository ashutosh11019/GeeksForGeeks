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
            PrintWriter out = new PrintWriter(System.out);
            int t;
            t = Integer.parseInt(br.readLine());
            while (t-- > 0) {
    
                int n;
                n = Integer.parseInt(br.readLine());
    
                int[] arr = IntArray.input(br, n);
    
                Solution obj = new Solution();
                ArrayList<Integer> res = obj.makeBeautiful(arr);
                for (int e : res) out.print(e + " ");
                out.println();
            }
            out.close();
        }
    }
    // } Driver Code Ends
    
    
    class Solution {
        public static ArrayList<Integer> makeBeautiful(int[] arr) {
            // code here
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int i=0;i<arr.length;i++){
                list.add(arr[i]);
            }
            while(check(list) == false){
                int i=0;
                while(!list.isEmpty() && i<list.size()-1){
                    // System.out.println(i);
                    if(list.get(i)>=0 && list.get(i+1)>=0){
                        i++;
                    }else if(list.get(i)<0 && list.get(i+1)<0){
                        i++;
                    }else{
                        list.remove(i);
                        list.remove(i);
                        if(i!=0) i--; 
                    }
                }
            }
            return list;
        }
        
        static boolean check(ArrayList<Integer> list){
            boolean flag = true;
            for(int i=0;i<list.size()-1;i++){
                if(list.get(i)>=0 && list.get(i+1)>=0){
                    
                }else if(list.get(i)<0 && list.get(i+1)<0){
                    
                }else{
                    return false;
                }
            }
            return true;
        }
    }
    