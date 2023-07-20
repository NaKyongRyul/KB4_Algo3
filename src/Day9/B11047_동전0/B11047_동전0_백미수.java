package Day9.B11047_동전0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11047_동전0_백미수 {

	static int N;
	static int K;
	static int[] arr;
	static int ans = 0;
	static int money;
	static int N_now;
	
	public static void Coin(int money, int N_now) {
		
		while(money !=0) {
		
			if(money/arr[N_now] == 0) {
				--N_now;
			}else {
				int count = money/arr[N_now];
				ans = ans+count;
				money = money - (count*arr[N_now]);
				--N_now;
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = reader.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		K = Integer.parseInt(str[1]);
		
		arr = new int[N];
		for(int i =0; i<N; i++) {
			int num = Integer.parseInt(reader.readLine());
			arr[i] = num;
		}
		
		money = K;
		N_now = N-1;
		Coin(money, N_now);
		System.out.println(ans);
	}
}
