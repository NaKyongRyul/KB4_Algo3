package Day9.B1976_여행가자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;


// 1. 유니온 파인드 사용
public class B1976_여행가자_길민지 {
	static int N, M;
	static int parent[];
	
	static int find (int x) {
		if (x == parent[x]) return x; // 루트 노드
		return parent[x] = find(parent[x]);
	}
	
	static void union (int x, int y) {
		x = find(x);
		y = find(y);
		if (x!=y) {
			if (x>y) parent[x] = y;
			else parent [y] = x;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(bf.readLine());
		
		// 부모 배열 초기화
		parent = new int [N+1];
		for (int i=1; i<N+1; i++) parent[i] =i;
		
		// 연결 정보 입력
		for(int i=1; i<N+1; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j=1; j<N+1; j++) {
				int sel = Integer.parseInt(st.nextToken());
				if (sel == 1) union(i, j);
			}
		}
		
		
		
		// 여행 계획 입력
		st = new StringTokenizer(bf.readLine());
		int start = Integer.parseInt(st.nextToken()); // 시작점
		boolean flag = true;
		for (int i=1; i<M; i++) {
			int p = Integer.parseInt(st.nextToken()); 
			if (find(start) == find(p)) continue;
			flag = false;
		}
		
		// 출력
		if (flag == true) System.out.println("YES");
		else System.out.println("NO");
	}

}


// 2. ArrayList 사용
/* 
public class B1976_여행가자_길민지 {
	static int N, M;
	static ArrayList <Integer> link[];
	static boolean [] isVisited;
	
	static boolean BFS(int start, int end) {
		Queue <Integer> que = new ArrayDeque();
		
		que.add(start);
		
		isVisited = new boolean[N+1];
		isVisited[start] = true;
		
		while(!que.isEmpty()) {
			int now = que.poll();
			for (int next : link[now]) {
				if (next == end) return true;
				if (isVisited[next]) continue;
				isVisited[next] = true;
				que.add(next);
			}
		}
		
		return false;
	}
	
	public static void main(String [] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(bf.readLine());
		
		link = new ArrayList[N+1];
		for (int i=1; i<N+1; i++) link[i] = new ArrayList();
		
		// 연결 정보 입력
		for(int i=1; i<N+1; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j=1; j<N+1; j++) {
				int sel = Integer.parseInt(st.nextToken());
				if (sel == 1) {
					link[i].add(j);
					link[j].add(i);
				}
			}
		}
		
		// 여행 계획 입력
		st = new StringTokenizer(bf.readLine());
		
		boolean flag = true; // 가능 여부
		int start = Integer.parseInt(st.nextToken()); // 시작점
		for (int i=1; i<M; i++) {
			int end = Integer.parseInt(st.nextToken()); // 도착점
			
			if(start == end) continue; // 시작점과 도착점이 같은 경우 무조건 가능
			
			if (!BFS(start, end)) { // 갈 수 없다면 종료
				flag = false;
				break;
			}
			start = end;
		}
		
		// 출력
		if (flag) System.out.println("YES");
		else System.out.println("NO");
	}
}
*/