package Day10.B1976_여행가자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1976_여행가자_전종한 {
	static int N, M; // N : 도시의 수, M : 여행 계획에 속한 도시의 수
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());

		parent = new int[N+1];
		for(int i=1; i<N+1; i++) {
			parent[i] = i;
		}
		for(int i=1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<N+1; j++) {
				int type = Integer.parseInt(st.nextToken());
				if(type == 1) union(i, j);
			}
		}
		st = new StringTokenizer(br.readLine());
		int city = Integer.parseInt(st.nextToken());
		int root = find(city);
		for(int i=1; i<M; i++) {
			city = Integer.parseInt(st.nextToken());
			if(find(city) == root) continue;
			else {
				System.out.println("NO");
				System.exit(0);
			}
		}
		System.out.println("YES");
	}

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
}
