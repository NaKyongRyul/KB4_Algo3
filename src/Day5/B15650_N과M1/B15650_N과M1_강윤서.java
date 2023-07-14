package Day5.B15650_N과M1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15650_N과M1_강윤서 {
	static int[] arr;
	static int N; // 숫자 개수
	static int R; // 선택 개수
	
	static int[] select; // 선택 저장
	static boolean[] isSelected; // 마킹 배열
	
	public static void combination(int idx, int size) {
		// 종료 조건
		if (size == R) {
			for (int i=0; i<select.length; i++) {
				System.out.print(arr[select[i]]+" ");
			}
			System.out.println();
			return;
		}
		
		// 재귀 확장
		for (int i=idx; i<N; i++) {
			// 이미 선택한 경우
			if (isSelected[i]) continue;
			
			// 아직 선택하지 않은 경우
			isSelected[i] = true;
			select[size] = i;
			combination(i, size+1); // 조합 생성
			isSelected[i] = false; // 다음 조합을 만들기 위해 초기화
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 숫자
		R = Integer.parseInt(st.nextToken()); // 선택 개수
		
		arr = new int[N];
		for (int i=0; i<N; i++) {
			arr[i] = i+1;
		}
		select = new int [R];
		isSelected = new boolean [N];
		
		combination(0, 0);
	}
}
