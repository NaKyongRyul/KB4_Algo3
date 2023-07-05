package Day5.B1068_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B1068_트리_박상희 {
	static ArrayList<Integer> tree[]; // 트리
	static int root; // 루트 노드
	static int deleteNode; // 지울 노드
	static int count = 0; // 리프 노드의 개수
	
	static void exploration(int node) {
		if (node == deleteNode) { // 해당 노드가 지울 노드일 경우
			return;
		}
		
		if (tree[node].size() == 0) { // 해당 노드의 자식 노드가 없을 경우, 리프 노드의 개수 카운트
			count++;
		}
		
		for (int nextNode : tree[node]) { // 해당 노드의 자식 노드
			exploration(nextNode);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		
		StringTokenizer token = new StringTokenizer(bf.readLine(), " ");

		tree = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			tree[i] = new ArrayList<>();
		}
		
		for (int n = 0; n < N; n++) {
			int parentNode = Integer.parseInt(token.nextToken());

			if (parentNode == -1) {
				root = n;
			}
			else {
				tree[parentNode].add(n);
			}
		}
		
		deleteNode = Integer.parseInt(bf.readLine());
		
		// 지울 노드를 자식으로 갖고 있는 노드에서 지울 노드 삭제
		for (int m = 0; m < N; m++) {
			tree[m].remove(Integer.valueOf(deleteNode));
		}
		
		exploration(root); // 루트 노드부터 탐색하면서 지울 노드와 연관된 자식 노드 배제
		
		System.out.println(count);
	}
}
