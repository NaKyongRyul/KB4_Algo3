package Day9.B1976_여행가자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1976_여행가자_박찬욱 {
	
	static int n, m; //  도시의 수 : N (N <= 200),  여행 계획에 속한 도시들의 수 : M (M <= 1000)
	static int [] parent;
	
	// x의 부모를 찾는 연산
	public static int find (int x) {
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

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		m = Integer.parseInt(bf.readLine());
		
		StringTokenizer token;
		parent = new int [n+1];
		for(int i = 1; i < n + 1; i++) parent[i] = i;
		
		for(int i = 1; i < n+1; i++) { // 서로에 대한 연결 여부 확인
			token = new StringTokenizer(bf.readLine());
			for(int j = 1; j < n+1; j++) {
				int line = Integer.parseInt(token.nextToken());
				if(line == 1) union(i, j);
			}
		}
		
		// 여행 계획 가능 여부 확인 : 가능하면 YES, 불가능하면 NO
		token = new StringTokenizer(bf.readLine());
		int start = Integer.parseInt(token.nextToken()); // 여행을 시작하는 도시
		for(int  i = 1; i < m; i++) {
			int next = Integer.parseInt(token.nextToken()); // 다음 행선지인 도시
			if(find(start) != find(next)) { // 두 도시간의 이동경로가 없는 경우
				System.out.println("NO"); // 불가능
				return;
			}	
		} // 반복문이 전부다 진행이 되었다면, 여행 계획이 가능하다는 것! 
		System.out.println("YES"); // 여행 계획이 가능하다면 가능으로 출력
	}
}