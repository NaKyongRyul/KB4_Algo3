package Day6.B11725_트리의부모찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class B11725_트리의부모찾기_김현지 {
	static int N;
	// 2차원 ArrayList 생성
	static ArrayList <Integer>[] tree;
	static boolean [] visited;
	static int [] parents;
	
	public static void treeSearch(int nowNode) {
		// 종료조건
		// 트리탐색은 말단 노드에 도달하게 되므로 연결되어있는것이 없음
		
		// 확장
		for (int nextNode : tree[nowNode]) {
			// 중복 확인
			if (visited[nextNode]) continue;
			
			// 다음 재귀
			visited[nextNode] = true;
			parents[nextNode] = nowNode;
			treeSearch(nextNode);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		tree = new ArrayList [N+1];
		visited = new boolean [N+1];
		parents = new int [N+1];
		
		int node1;
		int node2;


		// 배열 원소를 인스턴스로 지정
		for (int i=0; i<tree.length; i++) {
			tree[i] = new ArrayList<Integer>();
		}
		
		// 인접리스트 생성
		for (int i=0; i<N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			node1 = Integer.parseInt(st.nextToken());
			node2 = Integer.parseInt(st.nextToken());
			tree[node1].add(node2);
			tree[node2].add(node1);
		}
		
		// 부모 노드 찾기
		treeSearch(1);
	
		for (int i=2; i<N+1; i++) {
			System.out.println(parents[i]);
		}

	}

}
