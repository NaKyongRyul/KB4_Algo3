package Day9.B1976_여행가자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1976_여행가자_김혜인 {
	public static int n, m;
	public static int[] parent;
	public String answer;

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

	public static void main(String[] args) throws IOException, NumberFormatException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 도시의 수
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken()); // 여행 계획 수

		parent = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			parent[i] = i; // parent 배열
		}

		// 연결정보
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				int plan = Integer.parseInt(st.nextToken()); // 연결된 거 부모똑같이 만듬.
				if (plan == 1) {
					union(i, j);
				}
			}
		}

		String answer = "YES";
		String[] plan = br.readLine().split(" ");
		for (int i = 1; i < m; i++) {
			if (find(Integer.parseInt(plan[i]))!= find(Integer.parseInt(plan[i - 1]))) {
				// 연결되지 않은 노드 경로에 포함 시 답 변경 후 br	aeak
				answer = "NO";
				break;
			}
		}

		System.out.println(answer);
	}
}