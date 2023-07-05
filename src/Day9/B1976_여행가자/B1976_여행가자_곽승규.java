package Day9.B1976_여행가자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1976_여행가자_곽승규 {

	static int N, M;
	static int [] parent;
	static int [][] graph;
	static int [] plan;

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
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		M = Integer.parseInt(st.nextToken());

		// 도시 연결 정보 저장
		graph = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j = 1; j <= N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//System.out.println(Arrays.deepToString(graph));

		// parent 배열 초기화 하기
		parent = new int[N+1];
		for(int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		// 여행계획 정보 저장
		plan = new int[M+1];
		st = new StringTokenizer(bf.readLine());
		for(int i = 1; i <= M; i++) {
			plan[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (graph[i][j] == 1) {
					union(i, j);
				}
			}
		}
		
		//System.out.println(Arrays.toString(parent));
		
		int idx = find(plan[1]);
		for ( int i = 2; i < plan.length; i++) {
			if (idx != find(plan[i])) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
			

	}

}
