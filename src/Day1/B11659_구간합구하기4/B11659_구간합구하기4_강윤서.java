package Day1.B11659_구간합구하기4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11659_구간합구하기4_강윤서 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String [] strs = reader.readLine().split(" ");
		int n = Integer.parseInt(strs[0]); // 숫자 개수
		int m = Integer.parseInt(strs[1]); // 합을 구하는 횟수
		
		// 숫자 리스트
		int [] numList = new int[n+1];
		
		strs = reader.readLine().split(" ");
		numList[0] = 0;
		for (int i=0; i<n; i++) {
			numList[i+1] = Integer.parseInt(strs[i]);
		}
		
		// 구간 합 값 저장
		int [] sumList = new int[n+1];
		sumList[0] = 0;
		for (int i=1; i<n+1; i++) {
			sumList[i] = numList[i] + sumList[i-1];
		}
		
		// 합을 구하는 과정 반복
		for (int i=0; i<m; i++) {
			
			// 구간 범위
			strs = reader.readLine().split(" ");
			int start = Integer.parseInt(strs[0]);
			int end = Integer.parseInt(strs[1]);
			
			// 구간 합 계산
			System.out.println(sumList[end]-sumList[start-1]);
		}
	}
}
