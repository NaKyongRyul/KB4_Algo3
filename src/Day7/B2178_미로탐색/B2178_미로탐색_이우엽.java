package Day7.B2178_미로탐색;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2178_미로탐색_이우엽 {
	static int N;
	static int M;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int[][] arr2d;
	static boolean[][] isVisited;
	public static void BFS(int x, int y) {
		Queue<Integer[]> queue = new ArrayDeque<>();
		isVisited[x][y] = true;
		queue.offer(new Integer[] {x,y});
		while(!queue.isEmpty()) {
			Integer[] cur = queue.remove();
			for(int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				// 범위를 벗어나면 continue
				if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
					if(arr2d[nx][ny] != 0 && !isVisited[nx][ny]) {
						isVisited[nx][ny] = true;
						arr2d[nx][ny] = arr2d[cur[0]][cur[1]] + 1;
						queue.offer(new Integer[] {nx, ny});
					}
				}
			}
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		String[] arr = new String[N];
		arr2d = new int[N][M];
		isVisited = new boolean[N][M];
		// 한줄씩 입력받기
		for(int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < arr[i].length(); j++) {
				arr2d[i][j] = arr[i].charAt(j)-'0';
			}
		}
		BFS(0,0);
		System.out.println(arr2d[N-1][M-1]);
	}
}
