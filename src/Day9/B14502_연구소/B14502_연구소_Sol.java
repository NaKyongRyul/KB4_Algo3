package Day9.B14502_연구소;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B14502_연구소_Sol {
	
	static int N;
	static int M;
	static int [][] board;
	static int [][] temp_board;
	static int [] dx = {1,-1,0,0};
	static int [] dy = {0,0,1,-1};
	static int ans = 0;
	
	static boolean checkValid(int x , int y) {
		if(x<0 || x>=M || y<0 || y>=N) return false;
		return true;
	}
	
	// 벽을 세우는 경우의 수 탐색
	static void makeWall(int cnt) {
		if(cnt == 3) {
			// 벽을 다 세웠으면 바이러스를 발생시키고 안전지대가 몇개인지 카운트 => 최댓값 갱신
			ans = Math.max(countVirus(), ans);
			return;
		}
		
		// 경우의 수 탐색 (백트래킹)
		for(int y=0; y<N; y++) {
			for(int x=0; x<M; x++) {
				if(board[y][x] !=0) continue;
				board[y][x] = 1;
				makeWall(cnt+1);
				board[y][x] = 0;
			}
		}
	}
	
	
	// 전체 좌표 중에 바이러스를 찾아 발생시키고 안전지대 카운트 함수
	static int countVirus() {
		
		// clone 을 안할시 되돌리기 까다로워서 복제배열을 만듬 (2차원 이상은 for 문으로 clone하기)
		for(int i=0; i<N; i++) temp_board[i] = board[i].clone();
		
		// 바이러스 찾아서 발생시키기
		for(int y=0; y<N; y++)
			for(int x=0; x<M; x++) 
				if(board[y][x] == 2) virus(x,y,temp_board);
		
		int cnt = 0;
		
		// 안전지대 카운트
		for(int y=0; y<N; y++) 
			for(int x=0; x<M; x++) 
				if(temp_board[y][x] == 0) cnt++;
		return cnt;
	}
	
	// (x,y) 좌표에 바이러스 발생시키는 함수
	static void virus(int x , int y , int [][] temp) {
		temp[y][x] = 2;
		int next_x , next_y;
		for(int i=0; i<4; i++) {
			next_x = x + dx[i];
			next_y = y + dy[i];
			// 좌표가 유효하지 않은 경우 or 비어있지 않는 경우 skip
			if( (!checkValid(next_x,next_y)) || temp[next_y][next_x] != 0) continue;
			virus(next_x,next_y , temp);
		}
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String [] splits = bf.readLine().split(" ");
		N = Integer.parseInt(splits[0]);
		M = Integer.parseInt(splits[1]);
		board = new int [N][M];
		temp_board = new int [N][M];
		
		for(int y=0; y<N; y++) {
			splits = bf.readLine().split(" ");
			for(int x=0; x<M; x++){
				board[y][x] = Integer.parseInt(splits[x]);
			}
		}
		
		makeWall(0);
		System.out.println(ans);
		
	}
}
