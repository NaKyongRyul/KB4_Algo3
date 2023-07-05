package Day7.B2178_미로탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2178_미로탐색_길민지 {
	static int N, M;
	static int arr[][];
	static int cnt;
	static int [] dx = {-1,1,0,0}; // 상하좌우
	static int [] dy = {0,0,-1,1};
	static boolean [][] isVisited;
	
	static class Pair{ // 좌표
		int x, y, level;
		Pair(int x, int y, int level){
			this.x = x;
			this.y = y;
			this.level = level; // 기준점부터 최단 거리
		}
	}
	
	static void BFS(int startX, int startY) {
		Queue <Pair> que = new ArrayDeque<>();
		
		// 시작점 Enqueue
		Pair start = new Pair(startX, startY, 1);
		que.add(start);
		isVisited[startX][startY] = true;
	
		while(!que.isEmpty()) {
			Pair now = que.poll();
			
			for (int i=0; i<4; i++) { // 기준점 상하좌우 탐색
				Pair next = new Pair(now.x + dx[i], now.y + dy[i], now.level+1);

				// 범위 벗어나면 X
				if (next.x >= N || next.x < 0 || next.y < 0 || next.y>=M) continue; 
				// 길이 아니면 X
				if (arr[next.x][next.y]==0) continue;
				// 이미 방문했으면 X
				if (isVisited[next.x][next.y]) continue;
				// 종점이면 종료
				if (next.x == N-1 && next.y == M-1) {
					System.out.println(next.level);
					return;
				}

				// Enqueue
				que.add(next);
				isVisited[next.x][next.y] = true;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int [N][M];
		isVisited = new boolean [N][M];
		
		// 입력
		for (int i=0; i<N; i++) {
			String s = bf.readLine();
			for (int j=0; j<M; j++) {
				arr[i][j] = (int)s.charAt(j)-48;
			}
		}
		
		// 경로 찾기
		BFS(0,0);
		
	}
}