package Day7.B2178_미로탐색;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class B2178_미로탐색_Sol {
	static int N;
	static int M;
	static int [][] maze;
	static int [] dx = {1,0,-1,0};
	static int [] dy = {0,1,0,-1};
	static int [][] dist;
	
	public static boolean checkValid(int x , int y) {
		if(x < 0 || x >= M || y <0 || y>=N) return false;
		else return true;
	}
	
	public static void searchBFS() {
		
		Queue <int []> que = new ArrayDeque<>();
		que.add(new int []{0,0});
		dist[0][0] = 1;   // 스타트값
		
		// BFS
		while(!que.isEmpty()) {
			int [] now = que.poll();
			for(int i=0; i<4; i++) {
				
				// 다음좌표 계산
				int next_x = now[0] + dx[i];
				int next_y = now[1] + dy[i];
				
				// 좌표가 유효하지 않은 경우 or 해당 좌표로 움직이지 못하는 경우 or 이미 방문한 좌표인 경우 탐색 제외 // 
				if(!checkValid(next_x , next_y) 
						|| maze[next_y][next_x] == 0 
						|| dist[next_y][next_x] != 0) continue;
				
				// 동적프로그래밍 ~ dist[next_y][next_x] = dist[x][y] + 1 //
				dist[next_y][next_x] = dist[now[1]][now[0]] + 1;
				
				// 탐색 추가
				que.offer(new int [] {next_x , next_y});
				
			}
		}
	}
	
	
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(io.readLine() , " ");
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		maze = new int [N][M];
		dist = new int [N][M];
		String line;
		
		for(int i=0; i<N; i++) {
			line = io.readLine();
			for(int j=0; j<M; j++) {
				maze[i][j] = line.charAt(j) - '0';
			}
		}
		searchBFS();
		System.out.println(dist[N-1][M-1]);
	}
}
