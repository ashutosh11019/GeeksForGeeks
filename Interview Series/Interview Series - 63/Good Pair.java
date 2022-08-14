// { Driver Code Starts
    import java.io.*;
    import java.util.*;
    
    
    class StringArray
    {
        public static String[] input(BufferedReader br, int n) throws IOException
        {
            String[] s = new String[n];
            for(int i=0;i<n;i++){
                s[i]=br.readLine();
            }
            return s;
        }
    
        public static void print(String[] a)
        {
            for(String e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    
        public static void print(ArrayList<String> a)
        {
            for(String e : a)
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
                
                
                String[] A = StringArray.input(br, N);
                
                Solution obj = new Solution();
                long res = obj.getNumGoodPair(N, A);
                
                System.out.println(res);
                
            }
        }
    }
    // } Driver Code Ends
    
    
    class Solution {
        public static int generate_mask(String s){
            int mask=0;
            for(int i=0;i<s.length();i++){
                int ind = (int)(s.charAt(i)-'a');
                mask^=(1<<ind);
            }
            return mask;
        }
        
        public static long getNumGoodPair(int N, String[] A) {
            // code here
            long ans = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for(String s: A){
                int mask = generate_mask(s);
                map.put(mask, map.getOrDefault(mask, 0)+0);
                // System.out.println(map.get(mask));
                ans+=map.get(mask);
                for(int j=0;j<26;j++){
                    int new_mask = mask^(1<<j);
                    map.put(new_mask, map.getOrDefault(new_mask, 0)+0);
                    // System.out.println()
                    ans+=map.get(new_mask);
                }
                
                map.put(mask, map.getOrDefault(mask, 0)+1);
            }
            
            return ans;
            
            
            // int[][] arr = new int[N][26];
            // for(int i=0;i<N;i++){
            //     for(int j=0;j<A[i].length();j++){
            //         arr[i][A[i].charAt(j) - 'a']++;
            //     }
            // }
            // long ans = 0L;
            // int odd=0, sum=0;
            // for(int i=0;i<N;i++){
            //     // odd=0;
            //     for(int j=i+1;j<N;j++){
            //         // int a[] = new int[26];
            //         odd=0;
            //         for(int k=0;k<26;k++){
            //             sum=arr[i][k]+arr[j][k];
            //             if(sum%2==1) odd++;
            //         }
            //         if(odd==0 || odd==1) ans++;
            //         // if(check(a)==true) ans++;
            //     }
            // }
            // return ans;
        }
        
        // static boolean check(int[] a){
        //     int odd=0;
        //     for(int i=0;i<26;i++){
        //         if(a[i]%2==1) odd++;
        //     }
        //     if(odd==0 || odd==1) return true;
        //     else return false;
        // }
    }
            
    