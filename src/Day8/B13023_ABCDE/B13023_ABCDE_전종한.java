package Day8.B13023_ABCDE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B13023_ABCDE_전종한 {
	static int N;
	static int M;
	static ArrayList<Integer> [] arrList;
	static boolean [] visited;
	static boolean result;

	public static void DFS(int now, int depth) {
		if(depth == 4) {
			result = true;
			return;
		}
		visited[now] = true;

		for(int next : arrList[now]) {
			if(!visited[next]) {
				visited[next] = true;
				DFS(next, depth+1);
			}
		}
		visited[now] = false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = io.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		M = Integer.parseInt(strs[1]);

		arrList = new ArrayList[N];

		for(int i=0; i<N; i++) {
			arrList[i] = new ArrayList<>();
		}

		for(int i=0; i<M; i++) {
			strs = io.readLine().split(" ");
			arrList[Integer.parseInt(strs[0])].add(Integer.parseInt(strs[1]));
			arrList[Integer.parseInt(strs[1])].add(Integer.parseInt(strs[0]));
		}

		result = false;

		for(int i=0; i<N; i++) {
			visited = new boolean[N];
			DFS(i, 0);
			if(result) {
				System.out.println(1);
				System.exit(0);
			}
		}
		System.out.println(0);
	}
}
