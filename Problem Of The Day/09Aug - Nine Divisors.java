//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

// } Driver Code Ends
//User function Template for Java
class Solution{
    static long nineDivisors(long n){
        //Code Here
        int c = 0;
        int limit = (int) Math.sqrt(n);
        int prime[] = new int[limit + 1];
        for (int i = 1; i <= limit; i++) {
            prime[i] = i;
        }
        
        for (int i = 2; i * i <= limit; i++) {
            if (prime[i] == i) {
                for (int j = i * i; j <= limit; j += i) {
                    if (prime[j] == j) {
                        prime[j] = i;
                    }
                }
            }
        }
        
        for (int i = 2; i <= limit; i++) {
            int p = prime[i];
            int q = prime[i / prime[i]];
            if (p * q == i && q != 1 && p != q) {
                c += 1;
            } else if (prime[i] == i) {
                if (Math.pow(i, 8) <= n) {
                    c += 1;
                }
            }
        }
        
        return c;
    }
}

//{ Driver Code Starts.
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            long N = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.nineDivisors(N));
        }
    }
}
// } Driver Code Ends