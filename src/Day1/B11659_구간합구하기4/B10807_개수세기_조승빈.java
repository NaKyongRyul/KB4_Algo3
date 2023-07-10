package Day1.B11659_구간합구하기4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10807_개수세기_조승빈 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;

		StringTokenizer st = new StringTokenizer(br.readLine());

		int target = Integer.parseInt(br.readLine());

		while(st.hasMoreTokens()) {
			if (target == Integer.parseInt(st.nextToken())) {
				cnt++;
			}
		}

		System.out.println(cnt);
	}
}
