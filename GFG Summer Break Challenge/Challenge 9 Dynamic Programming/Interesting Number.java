// { Driver Code Starts
    import java.io.*;
    import java.util.*;
    
    class GFG {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t;
            t = Integer.parseInt(br.readLine());
            while(t-- > 0){
                
                String num;
                num = br.readLine();
                
                Solution obj = new Solution();
                boolean res = obj.divisibleByEight(num);
                
                String _result_val = (res) ? "Yes" : "No";
                System.out.println(_result_val);
            }
        }
    }
    // } Driver Code Ends
    
    
    class Solution {
        public static boolean divisibleByEight(String num) {
            // code here
            int n=num.length();
            for(int i=0;i<n;i++){
                if(num.charAt(i)=='0') return true;
                if(num.charAt(i)=='8') return true;
                for(int j=i+1;j<n;j++){
                    for(int k=j+1;k<n;k++){
                        // String ans = num.charAt(i)+num.charAt(j)+num.charAt(k);
                        
                        String ans="";
                        ans+=num.charAt(i);
                        ans+=num.charAt(j);
                        ans+=num.charAt(k);
                        int res = Integer.parseInt(ans);
                        // System.out.println(i+" "+j+" "+k+" "+res+" "+divisible(res));
                        if(divisible(res)==true) return true;
                    }
                }
            }
            
            for(int i=0;i<n;i++){
                for(int j=i+1;j<n;j++){
                    String ans="";
                    ans+=num.charAt(i);
                    ans+=num.charAt(j);
                    int res = Integer.parseInt(ans);
                    if(divisible(res)==true) return true;
                }
            }
            
            return false;
        }
        
        public static boolean divisible(int num){
            if(num%8 == 0) return true;
            else return false;
        }
    }
            
    
