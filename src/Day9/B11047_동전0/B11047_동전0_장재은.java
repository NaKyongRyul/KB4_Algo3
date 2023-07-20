package Day9.B11047_동전0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11047_동전0_장재은 {
	
	static int N;
	static int K;
	static int cnt = 0;
	static int [] coin;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] strs = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		K = Integer.parseInt(strs[1]);
		coin = new int [N];
		
		for(int i=0; i<N; i++)
			coin[i] = Integer.parseInt(br.readLine());
		
		for(int i=N-1; i>=0; i--) {
			if(K >= coin[i]) {
				cnt  = cnt + K / coin[i];
				K %= coin[i];
			}
		}
		System.out.println(cnt);
	}
}