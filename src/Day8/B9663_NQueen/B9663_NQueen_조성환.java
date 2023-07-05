package Day8.B9663_NQueen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B9663_NQueen_조성환 {
	static int N, cnt;
	static int[] arr;

	static boolean check_po(int line) {
		for (int i = 0; i < line; i++) {
			if (arr[line] == arr[i]) {
				return false;
			}

			else if (Math.abs(line - i) == Math.abs(arr[line] - arr[i])) {
				return false;
			}
		}
		return true;
	}

	static void dfs(int now) {
		if (now == N) {
			cnt += 1;
			return;
		}

		for (int i = 0; i < N; i++) {
			arr[now] = i;
			if (check_po(now)) {
				dfs(now + 1);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		arr = new int[N];

		dfs(0);

		System.out.println(cnt);
	}

}
