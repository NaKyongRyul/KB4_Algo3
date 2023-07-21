package Day10.B1717_집합의표현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1717_집합의표현_유유정 {
	static int N;
	static int M;
	static int [] parent;
	
	
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
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine();
		String []strs = s.split(" ");
		N = Integer.parseInt(strs[0]);
		M = Integer.parseInt(strs[1]);
		
		parent = new int [N+1];
		for(int i=0;i<N+1;i++)
			parent[i] = i;
		
		int op, a, b;
		
		for(int i=0;i<M;i++) {
			s = bf.readLine();
			strs = s.split(" ");
			
			op = Integer.parseInt(strs[0]);
			a = Integer.parseInt(strs[1]);
			b = Integer.parseInt(strs[2]);
			
			if(op == 1) {
				if(find(a) == find(b))
					System.out.println("YES");
				else
					System.out.println("NO");
			}
			
			if(op ==0) {
				union(a,b);
				
			}
		}
	}


}
