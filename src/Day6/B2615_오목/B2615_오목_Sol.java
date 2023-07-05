package Day6.B2615_오목;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2615_오목_Sol {

	static int N;
	static int [][] arr;
	
	// 오른/아래/아래대각/위대각 표현 
	static int [] dx = {1,0,1,1};
	static int [] dy = {0,1,1,-1};
	
	static boolean checkPlayer(int player , int x , int y) {
		if(checkValid(x , y) && (arr[y][x] == player)) {
			return true;
		}
		return false;
	}
	
	static boolean checkValid(int x, int y) {
		if(x < 1 || x >= N || y < 1 || y >= N) return false;
		return true;
	}
	
	static int checkFinish(int x,int y) {
		
		// 현재 좌표에 무엇?
		int nowPlayer = arr[y][x];
		
		// 빈 공간인 경우 > 확인할게 없음 > return
		if(nowPlayer == 0) return nowPlayer;
		
		// 변수 세팅 
		int next_x; int next_y;
		boolean flag;
		
		// 다음칸 확인
		for(int i=0; i<4; i++) {

			int now_x = x;
			int now_y = y;
			flag = true;
			
			for(int cnt=0; cnt<4; cnt++) {
				now_x = now_x + dx[i];
				now_y = now_y + dy[i];
				
				if(!checkPlayer(nowPlayer , now_x, now_y)) {
					flag = false;
					break;
				}
			}

			// 6개 이상인 경우 무효이므로 체크
			if(flag == true) {
				// 앞으로 1회 체크
				if(checkPlayer(nowPlayer , now_x + dx[i] ,  now_y + dy[i])) {
					flag = false;
					continue;
				}
				// 뒤로 1회 체크
				if(checkPlayer(nowPlayer , x - dx[i] , y - dy[i])) {
					flag = false;
					continue;
				}
				return nowPlayer;
			}
		}
		return 0;
	}
	
	public static void main(String[] args) throws IOException {
		
		N = 20;
		arr = new int [N][N];
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;
		for(int y = 1; y<N; y++) {
			token = new StringTokenizer(bf.readLine() , " ");
			for(int x=1; x<N; x++) {
				arr[y][x] = Integer.parseInt(token.nextToken());
			}
		}
		for(int y=1; y<N; y++) {
			for(int x=1; x<N; x++) {
				int check;
				if((check = checkFinish(x,y))!=0) {
					System.out.println(check);
					System.out.println(y + " " + x);
					return;
				};
			}
		}
		System.out.println(0);
	}
}
