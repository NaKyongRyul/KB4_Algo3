package Day7.B1260_DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1260_DFS와BFS_이채림 {
	static int N;//정점의 개수
	static int M;//간선의 개수
	static int V;//탐색을 시작할 정점의 번호
	static ArrayList<Integer> tree[];
	static boolean isSelected [];
	
	static void dfs(int nowNode) {
		if(isSelected[nowNode]) return;
		isSelected[nowNode] = true;
		System.out.print(nowNode+" ");
		
		Collections.sort(tree[nowNode]);
		for(int nextNode : tree[nowNode]) {
			dfs(nextNode);
		}
	}
	static void bfs(int nowNode) {
		Queue<Integer> que = new ArrayDeque<>();
		que.add(nowNode);
		isSelected[nowNode] = true;
		
		while(!que.isEmpty()) {
			nowNode = que.poll();
			
			System.out.print(nowNode+" ");
			Collections.sort(tree[nowNode]);
			
			for(int nextNode : tree[nowNode]) {
				if(isSelected[nextNode]) continue;
				isSelected[nextNode] = true;
				que.add(nextNode);
			}
			
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		isSelected = new boolean [N+1];
		tree = new ArrayList[N+1];
		for(int i = 0; i<N+1; i++) {
			tree[i] = new ArrayList<>();
		}
		 
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(bf.readLine());
			int u = Integer.parseInt(st.nextToken());///999
			int v = Integer.parseInt(st.nextToken());//1000
			tree[u].add(v);
			tree[v].add(u);
	
		}
		
		//System.out.println(Arrays.toString(tree));
		dfs(V);
		System.out.println();
		isSelected = new boolean [N+1]; // dfs()돌면서 값이 바뀌었기 때문에 다시 초기화해줘야 함!
		bfs(V);
		
	}

}
