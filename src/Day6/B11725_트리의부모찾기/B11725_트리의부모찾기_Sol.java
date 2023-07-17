package Day6.B11725_트리의부모찾기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class B11725_트리의부모찾기_Sol {

	static int N;
	static ArrayList <Integer> [] tree;
	static boolean [] isVisited;
	static int [] whoParents;
	
	public static void treeSearch(int nowNode) {

		// 확장
		for(int nextNode : tree[nowNode]) {
			
			// 중복 확인
			if(isVisited[nextNode]) continue;
			
			// 다음 재귀
			isVisited[nextNode] = true;
			whoParents[nextNode] = nowNode;
			treeSearch(nextNode);
		}
	}

	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		// 인접 리스트 초기화 //
		tree = new ArrayList [N + 1];
		
		for(int i = 0; i< tree.length; i++) {
			tree[i] = new ArrayList <>();
		}
		
		// 마킹배열 초기화
		isVisited = new boolean [N+1];
		whoParents = new int [N+1];
		
//		for(int i=0; i<tree.length; i++) System.out.println(tree[i]);

		for(int i=0; i<N-1; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			tree[u].add(v);
			tree[v].add(u);
		}

//		System.out.println();
//		for(int i=0; i<tree.length; i++) System.out.println(tree[i]);
		
		// RootNode 부터 탐색 (재귀)
		treeSearch(1);
		
		// 결과출력 (whoParents 배열)
		for(int i=2; i<N+1; i++) System.out.println(whoParents[i]);
		
	}
}
