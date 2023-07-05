package Day8.B9663_NQueen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9663_NQueen_박상희 {
	static int N;
	
	static boolean isSelected[];
	static int selectQueen[];
	
	static int count;
	
	public static boolean check(int index) { // 대각선 체크 함수		
		for (int n = 0; n < index; n++) {
			if (Math.abs(index - n) == Math.abs(selectQueen[index] - selectQueen[n])) { // 대각선 조건 체크
				return false;
			}
		}
		
		return true;
	}
	
	public static void permutation(int r) { // 순열 구하는 함수 이용
		if (r == N) {
			count++;
			return;
		}
		
		for (int j = 0; j < N; j++) {
			if (isSelected[j]) {
				continue;
			}
			
			isSelected[j] = true;
			selectQueen[r] = j; // j : 선택한 행(열의 값)
			if (check(r)) {
				permutation(r + 1);
			}
			isSelected[j] = false;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
				
		isSelected = new boolean[N];
		selectQueen = new int[N];
		
		permutation(0);
		System.out.println(count);
	}
}
