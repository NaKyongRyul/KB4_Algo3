package Day6.B1068_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B1068_트리_강윤서 {
	static ArrayList<Integer>[] tree;
	static int n; // 노드 개수
	static int root; // 루트 노드 번호
	static int whoParents[]; // 부모 정보 저장
	static int deleteNode; // 삭제할 노드 번호
	static int leafNodeCount; // 리프 노드 개수

	public static void dfs(int nowNode) { // 깊이 우선 탐색-재귀
		if (nowNode == deleteNode) // 삭제할 노드인 경우-더이상 자식 노드 탐색 안함
			return;
		
		if (tree[nowNode].size()==0) // 리프 노드 개수
			leafNodeCount++;
		
		for (int nextNode : tree[nowNode]) // 자식 노드 탐색
			dfs(nextNode);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine()); // 노드 개수
		
		// 트리 구조
		tree = new ArrayList[n];
		for (int i=0; i<n; i++) {
			tree[i] = new ArrayList<>();
		}
		
		// 부모-자식 관계 확인
		whoParents = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			whoParents[i] = Integer.parseInt(st.nextToken());
			if (whoParents[i]==-1) { // 루트 노드인 경우
				root = i;
			} else { // 루트 노드가 아닌 경우(부모가 있는 경우)
				tree[whoParents[i]].add(i); // 부모에 자식으로 추가
			}
		}
		
		// 삭제할 노드
		deleteNode = Integer.parseInt(br.readLine());
		if (deleteNode != root) { // 삭제할 노드가 루트 노드가 아닌 경우(부모가 있는 경우)
			tree[whoParents[deleteNode]].remove(Integer.valueOf(deleteNode)); // 삭제할 노드의 부모에서 자식(삭제할 노드) 삭제
		}

		leafNodeCount=0; // 리프 노드 개수	
		dfs(root);
		
		// 결과 출력
		System.out.println(leafNodeCount);
	}
}
