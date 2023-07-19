package Day7.B11724_연결요소의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B11724_연결요소의개수_전종한 {
	static int N;
	static int M;
	static ArrayList<Integer> [] graph;
	static boolean [] visited;
	static int cnt;

	public static void DFS(int now) {
		visited[now] = true;
		for(int next : graph[now]) {
			if(!visited[next]) {
				visited[next] = true;
				DFS(next);
			}
		}
	}

	public static int findIdx() {
		for(int i=1; i<N+1; i++) {
			if(!visited[i]) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
		String [] strs = io.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		M = Integer.parseInt(strs[1]);

		graph = new ArrayList [N+1];
		for(int i=1; i<N+1; i++) {
			graph[i] = new ArrayList<>();
		}

		for(int i=0; i<M; i++) {
			strs = io.readLine().split(" ");
			graph[Integer.parseInt(strs[0])].add(Integer.parseInt(strs[1]));
			graph[Integer.parseInt(strs[1])].add(Integer.parseInt(strs[0]));
		}

		visited = new boolean [N+1];

		cnt = 0;

		while(findIdx() != -1) {
			int idx = findIdx();
			DFS(idx);
			cnt ++;
		}

		System.out.println(cnt);

	}
}
