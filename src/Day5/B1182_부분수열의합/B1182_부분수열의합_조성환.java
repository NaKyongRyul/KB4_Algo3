package Day5.B1182_부분수열의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1182_부분수열의합_조성환 {

	static int N;
	static int S;
	static int[] arr;
	static boolean isSelected[];
	static int cnt = 0;
	static int total;
	static int check;

	static void subset(int num) {
		if (num == N) {
			total = 0;
			check = 0;
			for (int i = 0; i < N; i++) {
				if (isSelected[i]) {
					check++;
					total += arr[i];
				}
			}
			if(total == S && check != 0) {
				cnt++;
			}
			return;
		}

		isSelected[num] = true;
		subset(num + 1);

		isSelected[num] = false;
		subset(num + 1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		arr = new int[N];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		isSelected = new boolean[N];
		subset(0);

		System.out.println(cnt);
	}

}
