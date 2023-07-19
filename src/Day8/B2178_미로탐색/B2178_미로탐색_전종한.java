package Day8.B2178_미로탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B2178_미로탐색_전종한 {
	
	static int N;
	static int M;
	static int [][] board;
	static int [][] visited;
	static int cnt;
	static Queue<Node> que = new LinkedList<>();

	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void searchExit() {
		// 0, 0 에서 출발
		que.offer(new Node(0, 0));
		visited[0][0] = 1;

		while(!que.isEmpty()) {
			Node now = que.poll();
			int nowRow = now.row;
			int nowCol = now.col;
			// 도착한경우 해당 거리 cnt 에 저장
			if(nowRow == N - 1 && nowCol == M - 1) {
				cnt = visited[nowRow][nowCol];
				break;
			}

			for(int i=0; i<4; i++) {

				int nextRow = nowRow + dr[i];
				int nextCol = nowCol + dc[i];
				// 미로 밖으로 나갈 경우
				if ( nextRow < 0 || nextCol < 0 || nextRow >= N || nextCol >= M ) continue;
				// 다음 칸이 1이고, 방문하지 않은 곳
				if(visited[nextRow][nextCol] == 0 && board[nextRow][nextCol] == 1) {
					que.offer(new Node(nextRow, nextCol));
					// 거리 + 1
					visited[nextRow][nextCol]  = visited[nowRow][nowCol] + 1; 
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String [] strs = br.readLine().split(" ");

		N = Integer.parseInt(strs[0]);
		M = Integer.parseInt(strs[1]);

		board = new int [N][M];

		for(int i=0; i<N; i++) {
			strs = br.readLine().split("");
			for(int j=0; j<M; j++) board[i][j] = Integer.parseInt(strs[j]);
		}

		visited = new int [N][M];

		searchExit();

		System.out.println(cnt);

	}
}

class Node {
	public int row;
	public int col;
	public Node(int row, int col){
		this.row = row;
		this.col = col;
	}
}