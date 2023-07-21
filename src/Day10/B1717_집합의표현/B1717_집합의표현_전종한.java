package Day10.B1717_집합의표현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B1717_집합의표현_전종한 {
	static int N, M;
	static int[] parent;
	static StringBuilder sb;
	static ArrayList<Integer>[] list;
	static int [][] arr;

	public static int find(int x) {
		if (x == parent[x]) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}

	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x != y) {
			if (x < y) parent[y] = x;
			else parent[x] = y;
		}
	}

	public static void included(int a, int b) {
		int root_a = find(a);
		int root_b = find(b);
		if(root_a == root_b) sb.append("YES\n");
		else sb.append("NO\n");
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		parent = new int [N+1];
		list = new ArrayList[N+1];
		for(int i=0; i<N+1; i++) {
			parent[i]= i;
			list[i] = new ArrayList<>();
		}


		sb = new StringBuilder();
		arr = new int[N+1][3];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int type = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(type == 1) { // 찾는 연산
				included(a, b);
			}else if(type == 0) { // 합치는 연산
				union(a, b);
			}
		}

		System.out.println(sb);

	}
}
