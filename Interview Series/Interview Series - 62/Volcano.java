// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main
{
    static FastIO f;
    
    public static void main(String args[]) throws IOException
    {
        f = new FastIO();
        
        int t = f.nextInt();
        
        while(t-->0)
        {
            int N = f.nextInt();
            int M = f.nextInt();
            int K = f.nextInt();
            
            int[][] Volcano = new int[K][2];
            
            for(int i = 0; i < K; i++)
            {
                Volcano[i][0] = f.nextInt();
                Volcano[i][1] = f.nextInt();
            }
            
            f.out(Solution.solve(N, M, K, Volcano) + "\n");
        }
        
        f.flush();
    }
}

class FastIO
{
	BufferedReader br;
	PrintWriter bw, be;
	StringTokenizer st;

	public FastIO()
	{
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new PrintWriter(System.out);
		be = new PrintWriter(System.err);
		st = new StringTokenizer("");
	}

	private void read() throws IOException
	{
		st = new StringTokenizer(br.readLine());
	}

	public String nextLine() throws IOException
	{
		return br.readLine();
	}

	public String next() throws IOException
	{
		while(!st.hasMoreTokens())
			read();
		return st.nextToken();
	}

	public int nextInt() throws IOException
	{
		return Integer.parseInt(next());
	}

	public long nextLong() throws IOException
	{
		return Long.parseLong(next());
	}

	public float nextFloat() throws IOException
	{
		return Float.parseFloat(next());
	}

	public double nextDouble() throws IOException
	{
		return Double.parseDouble(next());
	}

	public char nextChar() throws IOException
	{
		return next().charAt(0);
	}

	public void out(String s) throws IOException
	{
		bw.print(s);
	}

	public void flush() throws IOException
	{
		bw.flush();
		be.flush();
	}

	public void err(String s) throws IOException
	{
		be.print(s);
	}
}// } Driver Code Ends


//User function Template for Java
class Pair{
    int x, y;
    Pair(int x, int y){
        this.x=x;
        this.y=y;
    }
}

class Solution {
    static int arr[][] = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    
    static int solve(long N, int M, int K, int[][] Volcano) {
        int[][] mat = new int[(int)N][M];
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<K;i++){
            q.add(new Pair(Volcano[i][0]-1, Volcano[i][1]-1));
            mat[Volcano[i][0]-1][Volcano[i][1]-1]=1;
        }
        int c=0;
        while(!q.isEmpty()){
            c++;
            int size=q.size();
            for(int i=0;i<size;i++){
                Pair cur = q.poll();
                for(int j=0;j<4;j++){
                    int x=arr[j][0]+cur.x;
                    int y=arr[j][1]+cur.y;
                    
                    if(x>=0 && y>=0 && x<N && y<M && mat[x][y]==0){
                        mat[x][y]=1;
                        q.add(new Pair(x, y));
                    }
                }
            }
        }
        return c-1;
    }
}