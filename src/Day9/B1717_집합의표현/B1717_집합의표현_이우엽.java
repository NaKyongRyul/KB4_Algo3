package Day9.B1717_집합의표현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1717_집합의표현_이우엽 {
	static int[] parent;
	public static int find(int x) {
		if(x == parent[x]) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x != y) {
			if(x < y) {
				parent[y] = x;
			} else {
				parent[x] = y;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(token.nextToken());
		int m = Integer.parseInt(token.nextToken());
		parent = new int[n+1];
		
		for(int i = 1; i < parent.length; i++) parent[i] = i;
		// m번의 연산 만큼 입력
		for(int i = 0; i < m; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			int operator = Integer.parseInt(token.nextToken());
			int a = Integer.parseInt(token.nextToken());
			int b = Integer.parseInt(token.nextToken());
			if(operator == 0) {
				union(a, b);
			} else {
				if(find(a) == find(b)) System.out.println("YES");
				else System.out.println("NO");
			}
		}
//		System.out.println(Arrays.toString(parent));
	}
}
