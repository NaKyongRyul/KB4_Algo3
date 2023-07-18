package Day7.B1260_DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1260_DFS와BFS_장재은 {

	static int N;
	static int M;
	static int V;
	static int node;
	static ArrayList<Integer>[] arr;
	static boolean [] isVisted;
	
	//DFS 재귀
	public static void dfs(int start) {
		System.out.print(start+" ");
		isVisted[start] = true;
		for(int next:arr[start]) {
			if(isVisted[next] == true) continue;
			dfs(next);
		}
	}
	
	//BFS 큐
	public static void bfs(int start) {
		Queue <Integer> que = new ArrayDeque <> ();
		isVisted[start] = true;
		que.add(start);
		while(!que.isEmpty()) {
			node = que.poll();
			System.out.print(node + " ");
			
			for(int next:arr[node]) {
				if(isVisted[next] == true) continue;
				que.add(next);
				isVisted[next] = true;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String strs [] = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		M = Integer.parseInt(strs[1]);
		V = Integer.parseInt(strs[2]);
		
		isVisted = new boolean [N+1];
		arr = new ArrayList[N+1];
		for(int i=0; i<N+1; i++)
			arr[i] = new ArrayList<>();
		
		for(int i=0; i<M; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			arr[a].add(b);
			arr[b].add(a);
		}
		
		for (int i = 0; i < N + 1; i++) {
            Collections.sort(arr[i]);
        }
		dfs(V);
		System.out.println();
		isVisted = new boolean [N+1];
		bfs(V);
	}
}