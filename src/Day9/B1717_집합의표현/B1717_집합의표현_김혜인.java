package Day9.B1717_집합의표현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1717_집합의표현_김혜인 {

	public static int n, m, x, y, z;
	public static int[] parent;

	public static void main(String[] args) throws IOException, NumberFormatException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		 n = Integer.parseInt(st.nextToken()); // 입력
		 m = Integer.parseInt(st.nextToken());
		parent = new int[n + 1];

		for (int i = 0; i <=n; i++) {
			parent[i] = i; // parent 배열 만들기
		}

		// 비교(재귀쓰기)
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			 x = Integer.parseInt(st.nextToken());
			 y = Integer.parseInt(st.nextToken());
			 z = Integer.parseInt(st.nextToken());
			 
			switch (x) {
			case 0:
				union(y,z);
				break;
			default:
				if (find(y) == find(z)) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}break;
			}
			
		}
	}

	// x의 부모를 찾는 연산
	public static int find(int x) {
		if (x == parent[x]) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}

	// y의 부모를 x의 부모로 치환하는 연산 (x > y 일 경우, 반대)
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x != y) {
			if (x < y) {
				parent[y] = x;
			} else {
				parent[x] = y;
			}
		}
	}

}
