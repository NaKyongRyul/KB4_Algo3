package Exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Num3 {

	static int N;
	static int [][] arr;
	
	// 이동 방향 정의
	static int [] dx = {1,0,1,1};
	static int [] dy = {0,1,1,-1};
	
	
	static boolean checkPlayer(int player , int x , int y) {
		if(checkValid(x , y) && (arr[y][x] == player)) {
			return true;
		}
		return false;
	}
	
	// 좌표가 배열에서 유효한지 확인
	static boolean checkValid(int x, int y) {
		if(x < 1 || x >= N || y < 1 || y >= N) return false;
		return true;
	}
	
	// (x,y) 좌표에서 게임이 종료되는지 확인하기
	static int checkFinish(int x,int y) {
		
		// 현재 좌표 확인
		int nowPlayer = arr[y][x];
		
		// 빈 공간인 경우 -> 게임이 종료될 수 없음
		if(nowPlayer == 0) return nowPlayer;
		
		// 빈 공간이 아닌 경우 -> 게임이 종료될 수 있는지 확인
		int next_x; int next_y;
		boolean flag;
		
		// 현재 좌표에서 4가지 방향 전부 확인해줘야 함
		for(int i=0; i<4; i++) {

			// 다음 좌표 확인
			int now_x = x;
			int now_y = y;
			flag = true;
			
			// 4번 확인 = 4번 성공시 5목임
			for(int cnt=0; cnt<4; cnt++) {
				now_x = now_x + dx[i];
				now_y = now_y + dy[i];
				
				// (now_x , now_y) 에 놓인 말이 nowPlayer 인지 확인
				if(!checkPlayer(nowPlayer , now_x, now_y)) {
					// 만약 nowPlayer 꺼가 아니라면 해당방향은 FAIL.. 다른 방향으로 확인
					flag = false;
					break;
				}
			}

			// 6목 이상인 경우를 확인 => 6목 이상이면 무효
			if(flag == true) {
								
				// 앞으로 1회 체크
				now_x = now_x + dx[i];
				now_y = now_y + dy[i];
				if(checkPlayer(nowPlayer , now_x , now_y)) {
					flag = false;
					continue;
				}
				
				// 뒤로 1회 체크
				if(checkPlayer(nowPlayer , x - dx[i] , y - dy[i])) {
					flag = false;
					continue;
				}
				
				// 여기까지 성공했다면 nowPlayer 가 이김!
				return nowPlayer;
			}
		}
		
		// 그게 아니라면 실패 
		return 0;
	}
	
	
	
	public static void main(String[] args) throws IOException {
		
		// 입력 처리 //
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
