package Day10.B1717_집합의표현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1717_집합의표현_장재은 {
	
	static int N;
	static int M;
	static int [] parent;
	
	public static int find(int x) {
		if(x == parent[x]) return x;
		return parent[x] = find(parent[x]);
	}
	
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x != y) {
			if(x < y) parent[y] = x;
			else parent[x] = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String strs[] = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		M = Integer.parseInt(strs[1]);
		parent = new int [N + 1];
		for(int i=0; i<N+1; i++) parent[i] = i;
		
		for(int i=0; i<M; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(stk.nextToken());
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			if(c == 0) {
				union(a, b);
//				System.out.println(Arrays.toString(parent));
			}
			else {
				int aParent = find(a);
				int bParent = find(b);
				if(aParent == bParent) System.out.println("YES");
				else System.out.println("NO");
			}
		}
	}
}