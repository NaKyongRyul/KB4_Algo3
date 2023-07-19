package Day8.B2178_미로탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair{ // 좌표
	int row, col;
	Pair(int row, int col){
		this.row = row;
		this.col = col;
	}
}

public class B2178_미로탐색_강윤서 {
	static int n;
	static int m;
	static int[][] graph;
	static Queue <Pair> queue = new ArrayDeque<>(); // BFS에서 사용
	
	public static void bfs(int startNodeR, int startNodeC) { // 너비 우선 탐색-큐
		int[] dr = {0, 1, 0, -1}; // 동, 남, 서, 북
		int[] dc = {1, 0, -1, 0};
		
		queue.offer(new Pair(startNodeR, startNodeC)); // 시작 노드 방문
		
		while(!queue.isEmpty()) {
			Pair nowNode = queue.poll();
			for (int i=0; i<4; i++) { // 4가지 방향에 대해서 이동가능한 칸 확인
				int nextNodeR = nowNode.row+dr[i];
				int nextNodeC = nowNode.col+dc[i];
				
				if (nextNodeR>=0 && nextNodeR<n && nextNodeC>=0 && nextNodeC<m) { // 미로 범위 내이면
					if (graph[nextNodeR][nextNodeC]==1) { // 아직 방문 처리 안했으면				
						queue.add(new Pair(nextNodeR, nextNodeC));
						graph[nextNodeR][nextNodeC]=graph[nowNode.row][nowNode.col]+1; // 현재 이동한 칸 수로 업데이트
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		// 그래프 구조
		graph = new int[n][m];
		for (int i=0; i<n; i++) {
		String line = br.readLine();
			for (int j=0; j<m; j++) {
				graph[i][j] = Integer.parseInt(line.substring(j, j+1));
			}
		}
		
		// BFS 수행
		bfs(0, 0);
		System.out.println(graph[n-1][m-1]);
	}
}
