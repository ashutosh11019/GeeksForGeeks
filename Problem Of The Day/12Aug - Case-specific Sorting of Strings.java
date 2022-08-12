//{ Driver Code Starts
    import java.util.*;
    import java.lang.*;
    import java.io.*;
    
    
    // } Driver Code Ends
    class Solution
    {
        //Function to perform case-specific sorting of strings.
        public static String caseSort(String str)
        {
            // Your code here
            StringBuilder scase=new StringBuilder();
            StringBuilder ucase=new StringBuilder();
            char[] arr=str.toCharArray();
            Arrays.sort(arr);
            for(int i=0;i<arr.length;i++){
                char c=arr[i];
                
                if(c>='a' && c<='z'){
                    scase.append(c);
                }else{
                    ucase.append(c);
                }
            }
            
            char[] lower=scase.toString().toCharArray();
            char[] upper=ucase.toString().toCharArray();
            
            int l=0;
            int u=0;
            StringBuilder ans=new StringBuilder();
            for(int i=0;i<str.length();i++){
                char c=str.charAt(i);
                if(c>='a' && c<='z'){
                    ans.append(lower[l++]);
                }else{
                    ans.append(upper[u++]);
                }
            }
            
            return ans.toString();
        }
    }
    
    //{ Driver Code Starts.
    
    class GFG {
        
        public static void main (String[] args) {
            
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String[] words = br.readLine().split("\\s+");
                int numTestCases = Integer.parseInt(words[0]);
                
                for (int tIdx = 0; tIdx < numTestCases; tIdx++) {
                    words = br.readLine().split("\\s+");
                    int size = Integer.parseInt(words[0]);
                    String str = br.readLine();
                    String sortedStr = new Solution().caseSort(str);
                    System.out.println(sortedStr);
                }
            }
            catch (IOException e) {
                System.out.println(e);
            }
        }
    }
    
    // } Driver Code Ends