package Day5.B2961_도영이가만든맛있는음식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2961_도영이가만든맛있는음식_강윤서 {
	static int[] sourness; // 신 맛
	static int[] bitterness; // 쓴 맛
	static int N; // 재료 개수
	
	static boolean[] isSelected; // 마킹 배열
	
	static int minDiff; // 신 맛과 쓴 맛의 최소 차이
	
	public static void subSet(int n) {
		// 종료 조건
		if (n == N) {
			int mulSourness = 1; // 신 맛 곱
			int sumBitterness = 0; // 쓴 맛 합
			int valid = 0; // 재료 하나라도 선택했는지 여부
			for (int i=0; i<N; i++) {
				if (isSelected[i]) {
					mulSourness *= sourness[i];
					sumBitterness += bitterness[i];
					valid = 1;
				}
			}
			if (valid == 1) { // 재료 하나라도 선택한 경우
				minDiff = Math.min(minDiff, Math.abs(mulSourness-sumBitterness)); // 신 맛과 쓴 맛의 최소 차이 업데이트
			}
			return;
		}
		
		// 재귀 확장
		// 선택하는 경우
		isSelected[n] = true;
		subSet(n+1);
		
		// 선택하지 않은 경우
		isSelected[n] = false;
		subSet(n+1);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		sourness = new int[N];
		bitterness = new int[N];
		
		// 신 맛과 쓴 맛 분리해서 배열에 저장
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			sourness[i] = Integer.parseInt(st.nextToken());
			bitterness[i] = Integer.parseInt(st.nextToken());
		}
		
		minDiff = Integer.MAX_VALUE;
		
		isSelected = new boolean [N];
		
		subSet(0);
		// 결과 출력
		System.out.println(minDiff);
	}
}
