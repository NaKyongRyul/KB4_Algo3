package Day9.B1717_집합의표현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1717_집합의표현_임재현 {
	static int N, M;
	static int[] arr;

	static void union(int a, int b) { // find(b)위에 a 올리기
		arr[find(b)] = find(a);
	}

	static int find(int target) { // 최소 넘버 조상 리턴
		if (arr[target] == target) return target;
		arr[target] = find(arr[target]);
		return arr[target];
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());

		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		
		arr = new int[N + 1];
		
		for (int i = 0; i <= N; i++) {
			arr[i] = i;
		}

		while (M-- > 0) {
			token = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(token.nextToken());
			int a = Integer.parseInt(token.nextToken());
			int b = Integer.parseInt(token.nextToken());
			if (command == 0) {
				union(a, b);
			}
			if (command == 1) {
				if (find(a) == find(b)) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		}
	}
}
