package Day8.B2178_미로탐색;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2178_미로탐색_Sol {
	
	static int N;
	static int M;
	static int [][] maze;
	static int [] dx = {1,0,-1,0};
	static int [] dy = {0,1,0,-1};
	static int [][] dist;
	
	// (x,y) 좌표 유효한지 확인 //
	public static boolean checkValid(int x , int y) {
		if(x < 0 || x >= M || y <0 || y>=N) return false;
		else return true;
	}
	
	
	// BFS 탐색
	public static void searchBFS() {
		
		Queue <int []> que = new ArrayDeque<>();
		que.add(new int [] {0,0});
		dist[0][0] = 1;
		
		// 반복문
		while(!que.isEmpty()) {
			
			// 현재 노드
			int [] now = que.poll();
			
			// 다음 탐색
			for(int i=0; i<4; i++) {
				
				// 다음 좌표
				int next_x = now[0] + dx[i];
				int next_y = now[1] + dy[i];

				
				// 2. 배열의 인덱스가 유효하지 않은 경우 = x < 0 | x > M | y < 0 | y > N 
				if(next_x < 0 || next_x >= M || next_y <0 || next_y>=N) continue;
				
				
				// 1. 이동할수 없는 칸 = maze[y][x] == 0 인 경우
				if(maze[next_y][next_x] == 0 ) continue;
				
				// 3. 이미 방문한 경우 = dist[y][x] != 0 
				if(dist[next_y][next_x] != 0) continue;
				
				dist[next_y][next_x] = dist[now[1]][now[0]] + 1;
				que.add(new int [] {next_x , next_y});
				
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException {
	
		// 입력 처리 //
		BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(io.readLine() , " ");
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		maze = new int [N][M];
		dist = new int [N][M];   				// 최솟값 저장 배열
		String line;
		
		for(int i=0; i<N; i++) {
			line = io.readLine();
			for(int j=0; j<M; j++) {
				maze[i][j] = line.charAt(j) - '0';
			}
		}
		
		// BFS 탐색
		searchBFS();
		
		// 정답 출력 (N,M) 최솟값
		System.out.println(dist[N-1][M-1]);
		
	}
}

