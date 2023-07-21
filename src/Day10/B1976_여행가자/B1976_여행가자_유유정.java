package Day10.B1976_여행가자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1976_여행가자_유유정 {
	static int N;
	static int M;
	static int [] parent;
	static int [][] connection;
	
	
	public static int find(int x) {
		if(x == parent[x])
			return x;
		return parent[x] = find(parent[x]);
	}
	
	
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a != b) {
			if(a < b) parent[b]=a;
			else parent[a] =b;
		}
			
	}
	private static void checkplan(int m,String [] strs) {
		for(int i=0;i<m-1;i++) {
			if(find(Integer.parseInt(strs[i]))!=find(Integer.parseInt(strs[i+1]))) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
		return;
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(bf.readLine());
		M = Integer.parseInt(bf.readLine());
		connection = new int [N+1][N+1];
		parent = new int [N+1];
		for(int i=0;i<N+1;i++)
			parent[i] = i;
		String s;
		String []strs;
		
		for(int i=0;i<N;i++) {
			s = bf.readLine();
			strs = s.split(" ");
			for(int j=0;j<N;j++) {
				connection[i+1][j+1] = Integer.parseInt(strs[j]);
				if(connection[i+1][j+1]==1)
					union(i+1,j+1);
			}
		}
		s = bf.readLine();
		strs = s.split(" ");
		checkplan(M, strs);

	}
}
