package Day7.B1991_트리순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1991_트리순회_강윤서 {
	static int tree[][];
	static int n; // 노드 개수

	public static void preOrder(int nowNode) { // 전위 순회
		if (nowNode < 0 || nowNode>=n) {
			return;
		}
		System.out.print((char)(nowNode+65)); // cur: 숫자+65를 문자로 표현
		preOrder(tree[nowNode][0]); // left
		preOrder(tree[nowNode][1]); // right
	}

	public static void inOrder(int nowNode) { // 중위 순회
		if (nowNode < 0 || nowNode>=n) {
			return;
		}
		inOrder(tree[nowNode][0]); // left
		System.out.print((char)(nowNode+65)); // cur: 숫자+65를 문자로 표현
		inOrder(tree[nowNode][1]); // right
	}

	public static void postOrder(int nowNode) { // 후위 순회
		if (nowNode < 0 || nowNode>=n) {
			return;
		}
		postOrder(tree[nowNode][0]); // left
		postOrder(tree[nowNode][1]); // right
		System.out.print((char)(nowNode+65)); // cur: 숫자+65를 문자로 표현
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine()); // 노드 개수

		// 트리 구조
		tree = new int[n][2];
		int node, left, right;
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			node = (int) st.nextToken().charAt(0)-65; // 문자-65를 숫자로 표현
			left = (int) st.nextToken().charAt(0)-65; // 문자-65를 숫자로 표현
			right = (int) st.nextToken().charAt(0)-65; // 문자-65를 숫자로 표현
			tree[node][0] = left;
			tree[node][1] = right;
		}

		// 순회
		preOrder(0); // 전위 순회
		System.out.println();
		inOrder(0); // 중위 순회
		System.out.println();
		postOrder(0); // 후위 순회
	}
}
