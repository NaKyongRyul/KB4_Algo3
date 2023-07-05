package Day5.B1182_부분수열의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1182_부분수열의합_길민지 {
	static int N, S; // 정수의 개수, 합
	static int arr[]; // 정수 배열
	static int cnt; // 합이 S개 되는 부분 수열의 개수
	static boolean isSelected[]; // 선택 여부
	
	static void subset(int num) {
		if (num == N) { // 재귀 종료 조건
			int sum = 0; // 선택된 원소의 합
			boolean flag = false; // 원소가 하나라도 들어가는지
			for (int i=0; i<N; i++) if(isSelected[i]==true) {
				sum+=arr[i];
				flag = true;
			}
			if (sum == S && flag == true) cnt++;
			return;
		}
		
		// 선택 O
		isSelected[num] = true;
		subset(num+1);
		
		// 선택 X
		isSelected[num] = false;
		subset(num+1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		// 입력
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		// 초기화
		arr = new int [N];
		isSelected = new boolean [N];
		
		// 배열 입력
		st = new StringTokenizer(bf.readLine());
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		subset(0);
		
		// 정답 출력
		System.out.println(cnt);
	}
}
