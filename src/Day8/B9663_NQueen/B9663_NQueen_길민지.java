package Day8.B9663_NQueen;

import java.util.Scanner;

public class B9663_NQueen_길민지 {
	static int N;
	static int queen[];
	static int cnt;
	static boolean isSelected[];
	
	static boolean check(int r, int i) { // r번째 행 i번째 열
		// 대각선 확인
		for (int k=0; k<r; k++) {
			// k행 queen[k]열
			if (Math.abs(k-r)==Math.abs(i-queen[k])) return false;
		}
		return true; // 써도 됨
	}
	
	static void findQueen(int r) {
		if (r==N) { // N개를 모두 찾았을 경우 종료
			cnt++;
			return;
		}
		
		for (int i=0; i<N; i++) {
			if (isSelected[i] || !check(r, i)) continue; // 이미 선택되었거나, 대각선 겹치면 X
			queen[r] = i; // r번째 행 i번째 열
			isSelected[i] = true; // 선택 체크
			findQueen(r+1);
			isSelected[i]=false; // 선택 해제
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 입력 및 초기화
		N = sc.nextInt();
		queen = new int [N];
		isSelected = new boolean[N];
		
		// 퀸 개수 찾기
		findQueen(0);
		
		// 출력
		System.out.println(cnt);
		sc.close();
	}

}
