//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.countFriendsPairings(n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public long countFriendsPairings(int n) 
    { 
       //code here
       return recv(n)%1000000007;
    }
    
    public static long recv(int n){
        if(n==1) return 1;
        if(n==2) return 2;
        
        long a=1, b=2;
        for(int i=3;i<=n;i++){
            long c = (b+a*(i-1))%1000000007;
            a=b;
            b=c;
        }
        return b%1000000007;
    }
}    
 

// class Solution
// {
//     static long mod = 1000000007;
//     public long countFriendsPairings(int n) 
//     { 
//        //code here
//        long[] dp = new long[n+1];
//        return count(dp,n)%mod;
//     }
//     static long count(long[] dp, int n){
//         for(int i=0;i<=n;i++){
//             if(i<0) return 0;
//             if(i==0){
//                 dp[i]=1;
//                 continue;
//             }
//             long c=0;
//             c+=dp[i-1]%mod;
//             if(i-2>=0) c+=dp[i-2]*(i-1)%mod;
//             dp[i]=c%mod;
//         }
//         return dp[n];
//     }
// }