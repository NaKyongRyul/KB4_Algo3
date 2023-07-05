package Day4.B2961_도영이가만든맛있는음식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2961_도영이가만든맛있는음식_이지은 {
	static int N;
	static int [] S, B;
	static boolean [] isSelected;
	static int sSum, bSum;
	static int min = 1000000000;
	
	public static void subset(int num) {
		//종료 조건 
		if(num == N) {
			sSum = 1;
			bSum = 0;
			for(int i=0; i<N; i++) {
				if(isSelected[i]) {
					sSum *= S[i];
					bSum += B[i];
					
					min = Math.min(Math.abs(sSum-bSum),min);
				}
			}
			return;
		}
		
		/// 분할 ///
		isSelected[num] = true;
		subset(num+1);
		
		isSelected[num] = false;
		subset(num+1);
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine()); //재료의 갯수 
		
		S = new int[N];
		B = new int[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			S[i] = Integer.parseInt(st.nextToken());  //신맛 *
			B[i] = Integer.parseInt(st.nextToken());  //쓴맛 + 
		}
		isSelected = new boolean[N];
	
		subset(0);
		System.out.println(min);
	}
}
