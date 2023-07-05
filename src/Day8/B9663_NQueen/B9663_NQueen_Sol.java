package Day8.B9663_NQueen;
import java.util.Arrays;
import java.util.Scanner;

public class B9663_NQueen_Sol {
	
	static int N;
	static int [] select;
	static boolean [] isSelected;
	static int ans = 0;
		
	public static boolean checkValid(int x , int y) {
		for(int i=0; i<N; i++) {
			if(y == i || select[i] == -1) continue;				// 자기자신이나 안 고른 경우는 pass
			if(Math.abs(y - i) == Math.abs(x - select[i])) return false;	// 대각선 걸리는 경우
		}
		return true;
	}
	
	public static void DFS(int cnt) {
		
		
		if(cnt >= N){
			ans++;			// 정답 체크
			System.out.println(Arrays.toString(select));
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(isSelected[i]) continue;		// 중복 방지
			if(!checkValid(i,cnt)) continue;	// 유효하지 않은 경우 ~ 퀸끼리 대각선에 걸리는 경우 Skip
			
			// 마킹
			isSelected[i] = true;
			select[cnt] = i;
			
			DFS(cnt + 1);	// 다음 경우의 수 탐색
			
			// 마킹 해제
			isSelected[i] = false;
			select[cnt] = -1;					 
		}
	}

	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		select = new int [N];
		Arrays.fill(select, -1);
		
		isSelected = new boolean [N];
		DFS(0);
		System.out.println(ans);
		
	}
}


