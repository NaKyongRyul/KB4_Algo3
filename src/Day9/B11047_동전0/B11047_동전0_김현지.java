package Day9.B11047_동전0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class B11047_동전0_김현지 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int [] coins = new int[N];
		
		for (int i=N-1; i>=0; i--) {
			st = new StringTokenizer(br.readLine());
			coins[i] = Integer.parseInt(st.nextToken());
		}
//		System.out.println(Arrays.toString(coins));

		
		int idx = 0;
		int sum = 0; 
		int cnt = 0;
		while ( sum != K) {
//			System.out.println("sum: " + sum);
			if (sum + coins[idx] <= K) {
				sum += coins[idx];
				cnt++;
			} else {
				idx++;
			}
		}
		System.out.println(cnt);
		

	}

}
