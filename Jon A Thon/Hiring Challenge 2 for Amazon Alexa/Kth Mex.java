// { Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.io.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        // taking testcases
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String str = br.readLine();
            String[] starr = str.split(" ");

            // input n and d
            int n = Integer.parseInt(starr[0]);
            int K = Integer.parseInt(starr[1]);

            int[] arr = new int[n];
            String str1 = br.readLine();
            String[] starr1 = str1.split(" ");

            // inserting elements in the array
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(starr1[j]);
            }
            int res = Solution.kthMex(n, K, arr);
            System.out.println(res);
        }
    }
}// } Driver Code Ends


// User function Template for Java
class Solution {
    static int kthMex(int n, int k, int arr[]) {
        // add your code here
        Arrays.sort(arr);
        int j=0;
        for(int i=0;i<n;){
            if(i>0 && arr[i]==arr[i-1]) i++;
            else if(j==arr[i]){
                i++;
                j++;
            }else{
                k--;
                if(k==0) return j;
                j++;
            }
        }
        return (j+k-1);
    }
}
