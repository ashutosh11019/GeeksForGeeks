// { Driver Code Starts
    import java.io.*;
    import java.util.*;
    
    class GFG {
        public static void main(String[] args) throws IOException {
            BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
            int t;
            t = Integer.parseInt(br.readLine());
            while (t-- > 0) {
    
                String S;
                S = br.readLine();
    
                String T;
                T = br.readLine();
    
                Solution obj = new Solution();
                boolean res = obj.isEqual(S, T);
    
                String _result_val = (res) ? "YES" : "NO";
                System.out.println(_result_val);
            }
        }
    }
    // } Driver Code Ends
    
    
    class Solution {
        public static boolean isEqual(String S, String T) {
            // code here
            if(S.length()!=T.length()) return false;
            HashMap<Character, Integer> map = new HashMap<>();
            for(int i=0;i<S.length();i++){
                if(!map.containsKey(S.charAt(i))){
                    map.put(S.charAt(i),1);
                }else{
                    int n = map.get(S.charAt(i))+1;
                    map.put(S.charAt(i),n);
                }
            }
            int num=0;
            for(int i=0;i<T.length();i++){
                if(!map.containsKey(T.charAt(i))){
                    map.put(T.charAt(i),-1);
                    // num++;
                    // return false;
                }else{
                    int n = map.get(T.charAt(i))-1;
                    map.put(T.charAt(i),n);
                }
            }
            // int sum=0;
            for(Map.Entry<Character, Integer> entry: map.entrySet()){
                if(entry.getValue()%2!=0) return false;
                // sum+=Math.abs(entry.getValue());
            }
            
            // if(num != sum) return false;
            // System.out.println(map);
            return true;
        }
    }
    