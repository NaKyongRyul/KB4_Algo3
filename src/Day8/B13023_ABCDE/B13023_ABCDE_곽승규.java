package Day8.B13023_ABCDE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B13023_ABCDE_곽승규 {
	static int N, M;
	static ArrayList<Integer> [] ary;
	static boolean [] visited;
	static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		ary = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			ary[i] = new ArrayList<>();
		}

		visited = new boolean [N];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			ary[s].add(e);
			ary[e].add(s);
		}
		
		for(int i = 0; i < N; i++) {
			if (answer == 0) {
				DFS(i, 1);
			}
		}
		
		System.out.println(answer);
	}

	static void DFS(int num, int depth) {
		if ( depth == 5 ) {
			answer = 1;
			return;
		}
		
		visited[num] = true;
		for(int i : ary[num]) {
			if (!visited[i]) {
				DFS(i, depth + 1);
			}
		}
		visited[num] = false;
	}
}
