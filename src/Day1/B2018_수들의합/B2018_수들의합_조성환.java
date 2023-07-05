package Day1.B2018_수들의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2018_수들의합_조성환 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int ans = 0;
		
		for(int i = 1; i <= N ; i++) {
			int hap = 0;
			for (int j = i ; j <= N ; j++) {
				hap += j;
				if (hap > N) {
					break;
				}else if(hap==N){
					ans += 1;
					break;
				}
			}
		}
		System.out.println(ans);
	}
}
