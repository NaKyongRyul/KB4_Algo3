package Day8.B9663_N_Queen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B9663_N_Queen_강윤서 {
	static int n;
	static int[] queenRow; // 각 col에 대한 queen의 row좌표
	static boolean[] isSelected; // 선택 여부
	static int result = 0; // 결과
	
	public static boolean checkValid(int row, int col) { // 대각선에 있는지 확인
		for (int i=0; i<col; i++) { // 선택한 col 전까지만 확인
			if (Math.abs(col-i) == Math.abs(row-queenRow[i])) { // 대각선에 있는 경우
				return false;
			}
		}
		return true;
	}
	
	public static void dfs(int size) {
		// 종료 조건
		if (size==n) { // 모두 선택한 경우
			result++;
			return;
		}
		
		// 순열-각 col에 대한 queen의 row좌표 선택
		for(int i=0; i<n; i++) {
			if (isSelected[i]) continue; // 이미 방문한 경우
			
			if (!checkValid(i, size)) continue; // 대각선에 있어 방문할 수 없는 경우
			
			isSelected[i] = true;
			queenRow[size] = i;
			
			dfs(size+1); // 순열 생성
			
			isSelected[i] = false; // 다음 순열을 만들기 위해 초기화
			queenRow[size] = -1;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		// 각 col에 대한 queen의 row좌표
		queenRow = new int[n];
		Arrays.fill(queenRow, -1); // 모두 -1로 초기화
		
		isSelected = new boolean[n];
		
		dfs(0);
		
		System.out.println(result);
	}
}
