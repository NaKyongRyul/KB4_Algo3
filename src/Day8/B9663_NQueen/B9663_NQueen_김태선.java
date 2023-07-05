package Day8.B9663_NQueen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9663_NQueen_김태선 {	
	
	static int [] arr; // 1차원 배열 선언
	static int N; // 체스판 크기
	static int cnt = 0; // 조건에 맞는 자리의 경우의 수
	
	// i 즉 인덱스의 위치를 열으로, arr[i] 즉 인덱스의 값을 행으로 하여 1차원배열로  
	
	public static boolean isPossible(int col) {
		
		for(int i = 0; i < col; i++) { 
			
			if(arr[col] == arr[i]) { // 같은 행에 존재할 경우
				return false; 
			}
			
			else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
				return false;
			} // 대각선 상 존재할 경우 계산(열의 차와 행의 차가 같을 경우 대각선에 위치)
		
		}
		
		return true;
		
	}
	
	
	public static void dfs(int depth) {
		
		if(depth == N) { // 행 계산
			cnt++;
			return;
		}
		
		for(int i = 0; i < N; i++) {
			arr[depth] = i;
			
			if(isPossible(depth)) { 
				// 해당 열에서 i번째 행에 놓을 수 있는지 검사
				dfs(depth + 1); // 놓을 수 있는 위치일 경우 재귀
			}
		}
	}
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		
		dfs(0); // dfs호출
		
		System.out.println(cnt);

	}

}
