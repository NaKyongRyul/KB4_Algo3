package Day10.B1717_집합의표현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1717_집합의표현_강윤서 {
static int[] parent;
	
	public static int find(int x) { // FIND 작업
		if (x==parent[x])
			return x;
		return parent[x] = find(parent[x]);
	}
	
	public static void union(int x, int y) { // UNION 작업
		x = find(x);
		y = find(y);
		if (x!=y) {
			if (x<y) { // 작은 숫자를 부모로 설정
				parent[y] = x;
			} else {
				parent[x] = y;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 집합 개수
		int m = Integer.parseInt(st.nextToken()); // 연산 개수
		
		// 부모 정보 자기자신으로 초기화
		parent = new int[n+1];
		for (int i=0; i<n+1; i++) {
			parent[i] = i;
		}
		
		// 각 연산에 대해 확인
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int opt = Integer.parseInt(st.nextToken()); // 0-합집합, 1-같은 집합 여부 확인
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			if (opt==0) { // 합집합
				union(u, v);
			} else if (opt==1) { // 같은 집합 여부 확인
				if (find(u)==find(v)) System.out.println("YES");
				else System.out.println("NO");
			}
		}
	}
}
