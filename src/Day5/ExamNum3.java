package Day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ExamNum3 {
	
	// 입력 //
	static int N;
	static int [][] arr;
	
	static int [] dx = {1 , 1 , 1 , 0 };
	static int [] dy = {-1 , 0 , 1 , 1};
	
	// (x,y) 좌표 = nowPlayer 동일한지 체크
	static boolean checkPlayer(int player , int x , int y) {
		
		if(checkValid(x,y) && arr[y][x] == player) {
			return true;
		}
		
		return false;
	}
	
	
	// (x,y) 좌표 = 배열에서 유효한지를 체크
	static boolean checkValid(int x , int y) {
		
		if( x < 1 || x >= N || y <1 || y>=N ) {
			return false;
		}
		return true;
	}
	
	
	// (x,y) 좌표가 주어진 경우에 게임이 종료되는지 확인해주는 함수
	static int checkFinish(int x, int y){
		
		// 현재 좌표 확인
		int nowPlayer = arr[y][x];
		
		// 빈 공간인 경우 => 게임이 종료되지 않음
		if(nowPlayer == 0) return nowPlayer;
		
		int next_x;
		int next_y;
		boolean flag;
		
		// 현재 좌표 기준으로 4가지 방향 확인
		for(int i=0; i<4; i++) {
			
			next_x = x + dx[i];
			next_y = y + dy[i];
			flag = true;
			
			// 4번 통과 = 오목 성립
			for(int cnt = 0; cnt <4; cnt++) {
				
				// 통과하지 못한 경우
				// 1. 다음좌표 = 배열의 인덱스가 유효한지
				// 2. 해당좌표가 nowPlayer 랑 동일한지
				if(!checkPlayer(nowPlayer , next_x , next_y)) {
					flag = false;
					break;
				}
			}
			
			// 오목이 성립되는 경우 => 6목 체크
			if(flag == true) {
				
				// 앞으로 1회 탐색
				next_x = next_x + dx[i];
				next_y = next_y + dy[i];
				
				if(!checkPlayer(nowPlayer , next_x , next_y)) {
					flag = false;
					continue;
				}
				
				
				// 뒤로도 1회 탐색
				if(!checkPlayer(nowPlayer , x - dx[i] , y - dy[i])) {
					flag = false;
					continue;
				}
				
				// 여기 도달 = nowPlayer 승리 성립
				return nowPlayer;
				
			}
			
		}
		
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
		
//		arr = new int [][] {{0,0,1,1,1} , {0,0,1,1,1} , {0,0,1,1,1} , {0,0,1,1,1} , {0,0,1,1,1}};
//		N = 5;
//		
//		for(int i=0; i<arr.length; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}
		
		
		// 모든 (x,y) 에 대해서 게임이 종료되는지 완전탐색 //
		for(int y =1; y<N; y++) {
			for(int x =1; x<N; x++) {
				
				int check;
				// 검사
				if(check = checkFinish(x,y) != 0) {
					// 게임이 종료된 경우
					System.out.println(check);
					System.out.println(y + " " + x);
					return;
				}
				
			}
		}
		

		

		
	}
}
