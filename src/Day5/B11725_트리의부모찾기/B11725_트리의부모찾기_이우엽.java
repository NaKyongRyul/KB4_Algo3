package Day5.B11725_트리의부모찾기;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B11725_트리의부모찾기_이우엽 {
	static int N;
	static List<Integer>[] tree;
	static boolean[] isVisited;
	static int[] parent;
	public static void permutation(int node) {
		//종료조건, 리프노드일때
		
		// 재귀적확장
		for(int child : tree[node]) {
			if(isVisited[child]) {
				continue;
			}
			isVisited[child] = true;
			parent[child] = node;
			permutation(child);
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		tree = new ArrayList[N+1];
		isVisited = new boolean[N+1];
		parent = new int[N+1];
		for(int i = 0; i < tree.length; i++) {
			tree[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < N-1; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			tree[u].add(v);
			tree[v].add(u);
		}
		
		// 루트노드부터 탐색
		permutation(1);
		
		for(int i = 2; i < N+1; i++) {
			System.out.println(parent[i]);
		}

	}

}
