package Day5.B11725_트리의부모찾기;

import java.util.ArrayList;
import java.util.Scanner;

public class B11725_트리의부모찾기_곽승규 {

	static int N;
	static ArrayList<Integer> tree[]; // 인접리스트
	static boolean [] isVisited;
	static int [] answer; // 부모 담을 리스트 

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		tree = new ArrayList[N + 1];
		isVisited = new boolean [N+1];
		answer = new int[N+1];
		
		for (int i = 0; i < tree.length; i++) {
			tree[i] = new ArrayList<>();
		}

		for(int i=0; i<N-1; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			tree[u].add(v);
			tree[v].add(u);
		}
		
		DFS(1); // 루트노드 1
		for (int i = 2; i <= N; i++) {
			System.out.println(answer[i]);
		}

	}
	
	static void DFS(int number) {
		isVisited[number] = true;
		for (int i : tree[number]) {
			if (!isVisited[i]) { // 방문하지 않았다면
				answer[i] = number;
				DFS(i);
			}
		}
	}

}
