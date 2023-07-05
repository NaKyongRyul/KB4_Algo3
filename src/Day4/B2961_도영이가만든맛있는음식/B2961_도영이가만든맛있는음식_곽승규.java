package Day4.B2961_도영이가만든맛있는음식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2961_도영이가만든맛있는음식_곽승규 {

	static int N;
	static int [] sourT; // 신맛 배열
	static int [] bitterT; // 쓴맛 배열
	static int minT = Integer.MAX_VALUE; // 신맛과 쓴맛의 차이가 가장 작은 값
	static boolean [] isSelected;
	
	static void subset(int num) {
		if (num == N) {
			
			int sum_Bit = 0;
			int sum_Sour = 1;
			int flag = 0;
			
			for (int i = 0; i < N; i++) {
				if(isSelected[i]) {
					flag = 1;
					sum_Bit += bitterT[i];
					sum_Sour *= sourT[i];
				}
			}
			
			if (minT > (Math.abs(sum_Bit - sum_Sour))&& flag == 1) {
				minT = (Math.abs(sum_Bit - sum_Sour));
			}
			return;
		}

		// 선택 0
		isSelected[num] = true;
		subset(num+1);

		// 선택 x
		isSelected[num] = false;
		subset(num+1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(bf.readLine());

		N = Integer.parseInt(st.nextToken());

		isSelected = new boolean[N];

		//신맛, 쓴맛 입력받아서 배열에 넣기
		sourT = new int[N];
		bitterT = new int[N];

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			sourT[i] = Integer.parseInt(st.nextToken());
			bitterT[i] = Integer.parseInt(st.nextToken());	
		}
		
		
		// 재료가 한 개 일 때 처리
		if (N == 1) {
			System.out.println(Math.abs(sourT[0] - bitterT[0]));
			return;
		}
		
		subset(0);

		System.out.println(minT);
		
	}

}
