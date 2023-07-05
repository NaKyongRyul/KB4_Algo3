package day07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1991_트리순회 {
	static int N;
	static int [][] tree;

	// 전위 순회 : 노드에 들어오자마자 방문(print)
	static void preorder(int nowNode) {
		if(nowNode == -19) return; // 말단 노드일 경우 순회를 종료한다!
		
		System.out.println((char) nowNode + 65);
		preorder(tree[nowNode][0]); // 왼쪽
		preorder(tree[nowNode][1]);
	}
	
	// 중위 순회 : 노드에 들어가고 왼쪽 노드를 방문하고 돌아와서 방문
	static void inorder(int nowNode) {
		if(nowNode == -19) return; // 말단 노드일 경우 순회를 종료한다!

		inorder(tree[nowNode][0]); // 왼쪽
		System.out.print((char) nowNode + 65);

		inorder(tree[nowNode][1]); // 오른쪽
	}
	
	// 후위 순회 : 노드에 들어가고 오른쪽 노드를 방문하고 돌아와서 방문
	static void postorder(int nowNode) {
		if(nowNode == -19) return; // 말단 노드일 경우 순회를 종료한다!

		postorder(tree[nowNode][0]); 
		postorder(tree[nowNode][1]);
		System.out.print((char) nowNode + 65);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(io.readLine());
		tree = new int[N][2];
		//이진 트리니까 가능한 방식
		for(int i=0; i<N; i++) {
			String[] temp = io.readLine().split(" ");
			int node = temp[0].charAt(0) - 'A';
			int left = temp[1].charAt(0) - 'A';
			int right = temp[2].charAt(0) - 'A';
			tree[node][0] = left;
			tree[node][1] = right;
		}
		for(int i=0; i<N; i++) System.out.println(Arrays.toString(tree[i]));

		preorder(0);

	}
}
