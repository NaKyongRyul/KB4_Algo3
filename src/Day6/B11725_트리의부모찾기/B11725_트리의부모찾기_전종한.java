package Day6.B11725_트리의부모찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B11725_트리의부모찾기_전종한 {
	static int N;
	static ArrayList <Integer> [] arrList;
	static boolean [] visited;
	static int [] parent;

	public static void DFS(int idx) {
		// 현재 노드를 방문한 것으로 표시
		visited[idx] = true;

		// 방문한 노드와 인접한 모든 노드 가져옴
		for(int i : arrList[idx]) {
			// 방문하지 않은 노드면
			if(!visited[i]) {
				// 부모 노드로 현재 노드를 기록하고
				parent[i] = idx;
				// 순환호출
				DFS(i);
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		arrList = new ArrayList[N+1];
		visited = new boolean[N+1];
		parent = new int[N+1];

		// 인접 리스트 생성
		for(int i=0; i<N+1; i++) arrList[i] = new ArrayList<>();

		// 노드를 연결
		for(int i=0; i<N-1; i++) {
			String [] strs = bf.readLine().split(" ");
			int a = Integer.parseInt(strs[0]);
			int b = Integer.parseInt(strs[1]);
			arrList[a].add(b);
			arrList[b].add(a);
		}
		//		for(int i=0; i<N+1; i++) System.out.println(arrList[i]);

		// 재귀
		DFS(1);

		//		System.out.println(Arrays.toString(parent));
		for(int i=2; i<N+1; i++) System.out.println(parent[i]);

	}
}
