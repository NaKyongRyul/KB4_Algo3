package day05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class B11725_트리의부모찾기2 {
	static int N;
	static ArrayList<Integer> tree[]; // 인접 리스트 표현해 주는 리스트 배열
	static boolean[] isVisited; // 해당 노드에 방문했는지 여부 확인하기 위한 배열
	static int[] parent;
	
	static void search(int node) { // node(부모) -> nextNode(자식) 이동
		for(int nextNode : tree[node]) {
			if(isVisited[nextNode]) continue;
			isVisited[nextNode] = true;
			search(nextNode); // 양방향이기 때문에 stackoverflow 에러가 터짐
			// -> isVisited 사용
			parent[nextNode] = node;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		N = sc.nextInt();
		tree = new ArrayList[N+1];
		isVisited = new boolean[N+1];
		// 왜 N+1? : 패딩
		parent = new int[N+1];
		
		for(int i=0; i<tree.length; i++) {
			tree[i] = new ArrayList<>();
		}
		
		for(int i=0; i<N-1; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			tree[u].add(v);
			tree[v].add(u); // 트리는 기본적으로 단방향 구조이지만 u->v인지 v->u인지 여기서는 모르기 때문에 
			// 일단 u와 v 양쪽에 넣어둔다
		}
		
		// 루트 노드부터 탐색
		// 한번 방문한 노드는 다시 방문할 수 없도록 boolean[] isVisited를 만들어서 
		// true인 경우 다시 못 가게 해야 된다
		
		isVisited[1] = true; // 미리 마킹
		search(1); // root node-1부터 탐색한다
		
		for(int i=2; i<N+1; i++) {
			System.out.println(parent[i]);
		}
	}
}
