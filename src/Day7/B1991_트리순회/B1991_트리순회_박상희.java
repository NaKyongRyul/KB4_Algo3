package Day7.B1991_트리순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B1991_트리순회_박상희 {
	static int N; // 이진 트리의 노드의 개수
	static ArrayList<Character> tree[];
	
	static void preorder(int node) { // 전위 순회
		if (node == 0) { // 루트 노드일 경우
			System.out.print((char) (node + 65));
		}
		
		for (int nd = 0; nd < 2; nd++) { // 자식 노드 탐색
			if (tree[node].get(nd) != '.') { // 자식 노드가 있을 경우
				System.out.print(tree[node].get(nd));
				preorder(tree[node].get(nd) - 65);
			}
		}
	}
	
	static void inorder(int node) { // 중위 순회
		if (tree[node].get(0) != '.') { // 왼쪽 자식 노드 탐색
			inorder(tree[node].get(0) - 65);
		}
		
		System.out.print((char) (node + 65)); // 방문한 노드 출력
		
		if (tree[node].get(1) != '.') { // 오른쪽 자식 노드 탐색
			inorder(tree[node].get(1) - 65);
		}
	}
	
	static void postorder(int node) { // 후위 순회
		if (tree[node].get(0) != '.') { // 왼쪽 자식 노드 탐색
			postorder(tree[node].get(0) - 65);
		}
		
		if (tree[node].get(1) != '.') { // 오른쪽 자식 노드 탐색
			postorder(tree[node].get(1) - 65);
		}
		
		System.out.print((char) (node + 65)); // 방문한 노드 출력
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		
		tree = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			tree[i] = new ArrayList<>();
		}
		
		for (int n = 0; n < N; n++) {
			StringTokenizer token = new StringTokenizer(bf.readLine(), " ");
			
			int parentNode = token.nextToken().charAt(0);
			char leftNode = token.nextToken().charAt(0);
			char rightNode = token.nextToken().charAt(0);
			
			tree[parentNode - 65].add(leftNode);
			tree[parentNode - 65].add(rightNode);
		}
		
		preorder(0);
		System.out.println();
		inorder(0);
		System.out.println();
		postorder(0);
	}
}
