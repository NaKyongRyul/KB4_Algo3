package Day6.B2615_오목;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2615_오목_박상희 {
	static int N;
	static int input[][];
	
	static int dx[] = {-1, 0, 1, 1}; // 우상, 우, 우하, 하
	static int dy[] = {1, 1, 1, 0}; // 우상, 우, 우하, 하
	
	public static boolean check(int x, int y) {
		if (x < 0 || y < 0 || x >= N || y >= N) {
			return false;
		}
		
		return true;
	}
	
	public static boolean checkPlayer(int x, int y, int player) {
		if ((check(x, y)) && (input[x][y] == player)) {
			return true;
		}
		
		return false;
	}
	
	public static int checkOmok(int x, int y) {			
		int nowPlayer = input[x][y];
		
		if (nowPlayer == 0) { // 알이 놓이지 않았을 경우
			return 0;
		}
		
		for (int d = 0; d < 4; d++) { // 오목이 성립할 수 있는 부분에 알이 있는지 체크 (방향 체크)
			int nx = x;
			int ny = y;
		
			boolean flag = true;
			
			for (int c = 0; c < 4; c++) { // 현재 체크하고 있는 방향에서 다음 알이 있는지 체크 (연속적인 알의 개수 체크)
				nx = nx + dx[d];
				ny = ny + dy[d];
				
				if (!checkPlayer(nx, ny, nowPlayer)) {
					flag = false;
					break;
				}
			}
			
			if (flag == true) { // 바둑알이 6 알 이상 놓이면 무효
				if (checkPlayer(nx + dx[d], ny + dy[d], nowPlayer)) { // 앞으로 1 회 체크 : 오목의 끝(마지막 체크한 부분) 다음에 알이 있는지 체크
					flag = false;
					continue;
				}
				
				if (checkPlayer(x - dx[d], y - dy[d], nowPlayer)) { // 뒤로 1 회 체크 : 오목의 첫 시작(처음 체크한 부분) 전에 알이 있는지 체크
					flag = false;
					continue;
				}
				
				return nowPlayer;
			}
		}
		
		return 0;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		N = 19;
		input = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer token = new StringTokenizer(bf.readLine());
			
			for (int j = 0; j < N; j++) {
				input[i][j] = Integer.parseInt(token.nextToken());
			}
		}
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				int winner = checkOmok(r, c);
				if(winner != 0) {
					System.out.println(winner);
					System.out.println((r + 1) + " " + (c + 1));
					
					return;
				}
			}
		}
		
		System.out.println(0);
	}
}
