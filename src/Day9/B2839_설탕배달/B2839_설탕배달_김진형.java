package Day9.B2839_설탕배달;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2839_설탕배달_김진형 {
	private static final int KG_5 = 5;
	private static final int KG_3 = 3;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int kg_5_cnt = N / KG_5;
		int kg_3_cnt = 0;

		while (kg_5_cnt >= 0) {
			kg_3_cnt = (N - KG_5 * kg_5_cnt) / KG_3;
			if ((kg_5_cnt * KG_5) + (kg_3_cnt * KG_3) == N) {
				System.out.println(kg_3_cnt + kg_5_cnt);
				return;
			}
			--kg_5_cnt;
		}
		System.out.println(-1);
	}
}
