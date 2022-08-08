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
    
                String s;
                s = br.readLine();
    
                Solution obj = new Solution();
                int res = obj.minimumSum(s);
    
                System.out.println(res);
            }
        }
    }
    // } Driver Code Ends
    
    
    class Solution {
        public static int minimumSum(String s) {
            // code here
            int c=0, i=0, j=s.length()-1;
            char ch='0';
            while(i<=j){
                if(s.charAt(i) == '?' && s.charAt(j)=='?'){
                    
                }else if(s.charAt(i) == '?'){
                    if(ch=='0'){
                        ch=s.charAt(j);
                    }else{
                        int n=ch-s.charAt(j);
                        c+=(int)Math.abs(n);
                        c+=(int)Math.abs(n);
                        ch=s.charAt(j);
                    }
                }else if(s.charAt(j) == '?'){
                    if(ch=='0'){
                        ch=s.charAt(i);
                    }else{
                        int n=ch-s.charAt(i);
                        c+=(int)Math.abs(n);
                        c+=(int)Math.abs(n);
                        ch=s.charAt(i);
                    }
                }else if(s.charAt(i) == s.charAt(j)){
                    if(ch=='0'){
                        ch=s.charAt(i);
                    }else{
                    int n=ch-s.charAt(i);
                    c+=(int)Math.abs(n);
                    c+=(int)Math.abs(n);
                    ch=s.charAt(i);
                    }
                }else{
                    return -1;
                }
                // System.out.println(c);
                i++;
                j--;
            }
            return c;
        }
    }
    