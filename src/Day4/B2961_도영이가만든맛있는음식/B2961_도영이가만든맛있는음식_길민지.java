package Day4.B2961_도영이가만든맛있는음식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2961_도영이가만든맛있는음식_길민지 {
	static int N;
	static int [] S, B;
	static boolean [] isSelected;
	static long minDiff;
	
	static void subset(int num) {
		// 종료 조건
		if (num==N) {
			int s = 1; // 신맛
			int b = 0; // 쓴맛
			int cnt = 0;
			for (int i=0; i<N; i++) {
				if (isSelected[i]==true) {
					cnt++;
					s *= S[i];
					b += B[i];
				}
			}
			if(cnt!=0) { // 재료가 0개가 아닌 경우
				int diff = Math.abs(s-b);
				if (diff<minDiff) minDiff = diff; // 최소 차이 갱신
			}
			return;
		}
		
		// 분할
		// 사용 O
		isSelected[num] = true;
		subset(num+1);
		
		// 사용 X
		isSelected[num] = false;
		subset(num+1);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		// 재료 개수 입력
		N = Integer.parseInt(bf.readLine());
		S = new int[N];
		B = new int[N];
		isSelected = new boolean[N];
		
		// 신맛 쓴맛 입력
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			S[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		minDiff = 1000000000;
		subset(0);
		System.out.println(minDiff);
	}
}
