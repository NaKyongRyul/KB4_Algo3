package Day6.B11047_동전0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;

public class B11047_동전0_곽승규 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N, K;
		int count = 0;
		int [] coinArr;
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		coinArr = new int[N];
		
		// 코인 정보 저장
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			coinArr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = N-1; i >= 0; i--) {
			if ( K >= coinArr[i] ) {
				int tmp;
				tmp = K / coinArr[i];
				count += tmp;
				K = K % coinArr[i];
			}
		}
		
		System.out.println(count);
		
	}

}
