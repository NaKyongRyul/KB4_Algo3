package Day5.B11725_트리의부모찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B11725_트리의부모찾기_길민지 {
	static int N;
	static ArrayList<Integer> tree[];
	static boolean [] isVisited;
	static int[] parent;
	
	static void findParent(int node) {
		for (int i : tree[node]) { // 자식 노드 탐색
			if (isVisited[i]==false) { 
				isVisited[i] = true;
				parent[i] = node;
				findParent(i);
			}
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		tree = new ArrayList[N+1]; // 루트 노드가 1이라 +1
		isVisited = new boolean [N+1];
		
		parent = new int[N+1];
		
		for(int i=0; i<tree.length; i++) {
			tree[i] = new ArrayList<>(); // 각각 초기화
		}
		
		for(int i=0; i<N-1;i++) {
			// 연결 관계 입력
			st = new StringTokenizer(bf.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			tree[u].add(v);
			tree[v].add(u);
		}
		
		// 전체 노드 출력
		// for (int i=0; i<tree.length;i++) System.out.println(i+"노드 : " + tree[i]);
		
		// RootNode부터 탐색
		for(int i=0;i<tree.length;i++) {
		System.out.println(tree[i]);
		}
		findParent(1);
		
		// 부모 노드 출력
		for (int i=2;i<N+1;i++) System.out.println(parent[i]);
	}

}

