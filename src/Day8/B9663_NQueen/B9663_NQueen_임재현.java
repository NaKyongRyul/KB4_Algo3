package Day8.B9663_NQueen;

import java.util.Scanner;

public class B9663_NQueen_임재현 {
	static int[] arr = new int[15];
	static int N;
	static boolean[] visited = new boolean [15];
	static int ans;
	
	static void dfs(int index) { // index행에 배치
		if (index == N) {
			ans++;
			return;
		}
		for (int i = 0; i < N; i++) {
			if (visited[i]) continue;
			boolean flag = false;
			for (int j = 0; j < index; j++) {
				if (arr[j] - i == j - index || arr[j] - i == index - j) {
					flag = true;
					break;
				}
			}
			if (flag) continue;
			visited[i] = true;
			arr[index] = i;
			dfs(index + 1);
			visited[i] = false;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		sc.close();
		dfs(0);
		System.out.println(ans);
	}
}
