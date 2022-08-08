// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
          
            String S = read.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.removeReverse(S); 
            System.out.println(ans);
        }
    } 
} 

 // } Driver Code Ends
//User function Template for Java

class Solution 
{ 
    String removeReverse(String S) 
    { 
        // code here
        String str1="", str2="";
        HashMap<Character, Integer> map = new HashMap<>();
        int c=0;
        for(int i=0;i<S.length();i++){
            char ch = S.charAt(i);
            if(!map.containsKey(ch)){
                map.put(ch, 1);
            }else{
                int num = map.get(ch)+1;
                map.put(ch, num);
                c++;
            }
        }
        // System.out.println(map);
        // System.out.println(c);
        if(c==0) return S;
        int i=0, j=S.length()-1, flag=0;
        while(i<j){
            if(c==0) break;
            if(flag==0){
                char ch = S.charAt(i);
                if(map.get(ch)==1){
                    str1+=ch;
                }else{
                    int num = map.get(ch)-1;
                    c--;
                    flag=1;
                    map.put(ch,num);
                }
                i++;
            }else{
                char ch = S.charAt(j);
                if(map.get(ch)==1){
                    str2+=ch;
                }else{
                    int num = map.get(ch)-1;
                    c--;
                    flag=0;
                    map.put(ch,num);
                }
                j--;
            }
            // System.out.println(map);
        }
        // System.out.println(i+" "+j);
        // System.out.println(str1+" "+str2);
        String ans = "";
        if(flag==0){
            ans+=str1;
            for(int k=i;k<=j;k++){
                char ch=S.charAt(k);
                ans+=ch;
            }
            for(int k=str2.length()-1;k>=0;k--){
                char ch=str2.charAt(k);
                ans+=ch;
            }
        }else{
            ans+=str2;
            // System.out.println(ans);
            for(int k=j;k>=i;k--){
                char ch=S.charAt(k);
                ans+=ch;
            }
            // System.out.println(ans);
            for(int k=str1.length()-1;k>=0;k--){
                char ch=str1.charAt(k);
                ans+=ch;
            }
            // System.out.println(ans);
        }
        
        return ans;
    }
} 

// { Driver Code Starts.
  // } Driver Code Ends