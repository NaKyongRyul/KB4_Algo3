package Day8.B13023_ABCDE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B13023_ABCDE_김태선 {
	
	static int N;
	static int M;
	static ArrayList<Integer>[] graph;
	static boolean[] visit;
	static int result = 0;
	
	
	static void dfs(int x, int cnt) {
		
		//dfs 깊이가 4이상이면 return
		if(cnt >= 4) {
			result = 1;
			return;
			
		}
		
		for(int i : graph[x]) {
			if(!visit[i]) {
				visit[i] = true;
				dfs(i, cnt + 1);
				visit[i] = false;
			}
		}
	}
	

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N + 1];
		for(int i = 0; i < N; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		visit = new boolean[N + 1];
		
		// 인접 리스트 만들기(변환)
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a].add(b);
			graph[b].add(a);
		}
		
		// dfs
		for(int i = 0; i < N; i++) {
			visit[i] = true;
			dfs(i, 0);
			visit[i] = false;
			
			// 1이면 종료
			if(result == 1) {
				
				// break;
				System.out.println(1);
				return;
			}
		}
		
		System.out.println(result);

	}

}
