package Day8.B9663_N_Queen;

import java.util.Arrays;
import java.util.Scanner;

public class B9663_N_Queen_Sol {

	static int N;
	static int [] queen;
	static boolean [] isSelected;
	static int ans = 0;
	
	// (x,y) 좌표에 퀸을 놓은 경우에 - 다른 퀸들이랑 대각선 충돌이 일어나는지
	public static boolean checkValid(int x , int y) {
		
		// 다른 퀸들이랑 비교
		for(int queen_x = 0; queen_x<N; queen_x++ ) {
			
			// 퀸이 아직 선택되지 않은 경우 혹은 자기자신인 경우
			if(x == queen_x || queen[queen_x] == -1) continue;
			
			// 대각선인 경우 
			if( Math.abs(x - queen_x) == Math.abs(y - queen[queen_x]))
				return false;
		}
		
		return true;
	}
	
	// 순열-경우의수 탐색 
	public static void DFS(int x) {
		
		// 1. 종료조건
		if(x>= N) {
//			System.out.println(Arrays.toString(queen));
			ans++;
			return;
		}
		
		// 2. 재귀 확장 = 다음 탐색
		for(int y = 0; y<N; y++) {
			// 중복 방지
			if(isSelected[y]) continue;
			
			// 대각선 조건 확인
			if(!checkValid(x,y)) continue;
			
			// 선택
			isSelected[y] = true;
			queen[x] = y;
			
			DFS(x+1);
			
			// 선택해제
			isSelected[y] = false;
			queen[x] = -1;	
		}
	}
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		queen = new int [N];
		
		Arrays.fill(queen, -1);
		
		isSelected = new boolean [N];
		
		DFS(0);
		
		System.out.println(ans);
	}
}
