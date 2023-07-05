package Day4.B2961_도영이가만든맛있는음식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2961_도영이가만든맛있는음식_전상희 {
	static int[] S; // 신맛
	static int[] B; // 쓴맛
	static boolean[] isSelectedS;
	static boolean[] isSelectedB;
	static int[] sumS; // 신맛 부분집합의 곱 저장할 배열
	static int[] sumB; // 쓴맛 부분집합의 합 저장할 배열
	static int N;
	static int cnt = 0; 

	static void subset(int num, int[] arr, boolean[] isSelected) {
		if(num == N) {
			for(int i=0; i<N; i++) {
				if(isSelected[i]) {
					if(arr == S && arr[i]!=0) sumS[cnt] *= arr[i];
					if(arr == B) sumB[cnt] += arr[i];
				}				
			}
			cnt++;
			return;
		}
		
		isSelected[num] = true;
		subset(num+1, arr, isSelected);
		
		isSelected[num] = false;
		subset(num+1, arr, isSelected);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine()); // 재료의 개수 (1~10개)
		S = new int[N];
		B = new int[N];
		isSelectedS = new boolean[N];
		isSelectedB = new boolean[N];
		int len = 1;
		for(int i=1; i<=N; i++) 
			len *= 2;
		
		sumS = new int[len];
		sumB = new int[len];
		StringTokenizer token;
		
		for(int i=0; i<len; i++) sumS[i] = 1;
		
		for(int i=0; i<N; i++) {
			token = new StringTokenizer(bf.readLine());
			S[i] = Integer.parseInt(token.nextToken());
			B[i] = Integer.parseInt(token.nextToken());
			sumS[i] = 1;
		}
		
		// S과 B의 부분집합들을 구하고 S(곱) B(합) -> 차이를 저장할 배열을 만든다
		// subset
		cnt = 0;
		subset(0, S, isSelectedS);
		cnt = 0;
		subset(0, B, isSelectedB);
		// 여기까지 잘 돌아간다
		
		
		for(int i=0; i<len; i++) {
			if(sumS[i] == 1) sumS[i] = 0;
		}
		int min = Math.abs(sumS[0] - sumB[0]);
		
		for(int i=1; i<len; i++) {
			if(sumS[i]!=0 && sumB[i]!=0) {
			int n = Math.abs(sumS[i]-sumB[i]);
			if(n < min)
				min = n;
			}
		}
		
		System.out.println(min);
	}
}
