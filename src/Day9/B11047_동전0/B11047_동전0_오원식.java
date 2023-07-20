package Day9.B11047_동전0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class B11047_동전0_오원식 {
	
	static int N;
	static int K;
	static Integer [] coin;
	static int res;
	static int q;

	public static void count() {
		for(int c : coin) {
			if(K >= c) {
				q = K/c;
				K %= c;
				res += q;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		K = Integer.parseInt(s[1]);
		
		coin = new Integer[N];
		for(int i = 0; i<N; i++) 
			coin[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(coin, Collections.reverseOrder());
		

		count();
		System.out.println(res);
	}

}
