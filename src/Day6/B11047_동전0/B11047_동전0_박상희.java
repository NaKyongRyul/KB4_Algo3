package Day6.B11047_동전0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11047_동전0_박상희 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(bf.readLine(), " ");
		
		int N = Integer.parseInt(token.nextToken());
		int K = Integer.parseInt(token.nextToken());
		
		int moneyArr[] = new int[N];
		int idx = 0;
		int money = 0;
		for (int n = 0; n < N; n++) {
			moneyArr[n] = Integer.parseInt(bf.readLine());
			
			if (moneyArr[n] <= K) {
				money = Math.max(money, moneyArr[n]);
				
				if (money == moneyArr[n]) {
					idx = n;
				}
			}
		}
		
		int count = 0;
		for (int i = idx; i >= 0; i--) {			
			while (K >= moneyArr[i]) {
				K -= moneyArr[i];
				count++;
			}
			
			if (K == 0) {
				break;
			}
		}
		
		System.out.println(count);
	}
}
