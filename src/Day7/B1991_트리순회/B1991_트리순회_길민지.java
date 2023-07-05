package Day7.B1991_트리순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1991_트리순회_길민지 {
	static int N;
	static char tree[][];
	
	// 전위 순회
	static void preorder_traverse(int node) {
		// 뿌리 노드 출력
		System.out.print(tree[node][0]);
		
		// 왼쪽 자식 노드 방문
		if(tree[node][1]!='.') {
			for (int i=0; i<N; i++) {
				if (tree[node][1]==tree[i][0]) preorder_traverse(i);
			}
		}
		
		// 오른쪽 자식 노드 방문
		if(tree[node][2]!='.') {
			for (int i=0; i<N; i++) {
				if (tree[node][2]==tree[i][0]) preorder_traverse(i);
			}
		}
	}
	
	// 중위 순회
	static void inorder_traverse(int node) {
		// 왼쪽 자식 노드 방문
		if(tree[node][1]!='.') {
			for (int i=0; i<N; i++) {
				if (tree[node][1]==tree[i][0]) inorder_traverse(i);
			}
		}
		// 뿌리 노드 출력
		System.out.print(tree[node][0]);
		
		// 오른쪽 자식 노드 방문
		if(tree[node][2]!='.') {
			for (int i=0; i<N; i++) {
				if (tree[node][2]==tree[i][0]) inorder_traverse(i);
			}
		}
	}
	
	// 후위 순회
	static void postorder_traverse(int node) {
		// 왼쪽 자식 노드 방문
		if(tree[node][1]!='.') {
			for (int i=0; i<N; i++) {
				if (tree[node][1]==tree[i][0]) postorder_traverse(i);
			}
		}
		// 오른쪽 자식 노드 방문
		if(tree[node][2]!='.') {
			for (int i=0; i<N; i++) {
				if (tree[node][2]==tree[i][0]) postorder_traverse(i);
			}
		}
		// 뿌리 노드 출력
		System.out.print(tree[node][0]);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		// 노드 개수 입력
		N = Integer.parseInt(st.nextToken());
		tree = new char [N][3];
		
		// 노드 입력
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(bf.readLine());
			tree[i][0] = st.nextToken().charAt(0);
			tree[i][1] = st.nextToken().charAt(0);
			tree[i][2] = st.nextToken().charAt(0);
		}
		
		preorder_traverse(0); // 전위순회
		System.out.println();
		inorder_traverse(0); // 중위순회
		System.out.println();
		postorder_traverse(0); // 후위순회
	}
}
