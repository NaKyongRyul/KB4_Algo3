package Day9.B1976_여행가자;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1976_여행가자_임재현 {
	static int[] root;
	static int N, M;

	static int find(int target) {
		if (target == root[target])
			return target;
		return root[target] = find(root[target]);
	}

	static void union(int a, int b) {
		root[find(a)] = root[find(b)];
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		N = Integer.parseInt(token.nextToken());
		root = new int[N + 1];

		token = new StringTokenizer(br.readLine());
		M = Integer.parseInt(token.nextToken());
		for (int i = 1; i <= N; i++)
			root[i] = i;

		for (int i = 1; i <= N; i++) {
			token = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int road = Integer.parseInt(token.nextToken());
				if (road == 1) {
					union(i, j);
				}
			}
		}

		token = new StringTokenizer(br.readLine());
		M--;
		int start = Integer.parseInt(token.nextToken());
		while (M-- > 0) {
			int next = Integer.parseInt(token.nextToken());
			if (find(start) != find(next)) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
		return;
	}
}
