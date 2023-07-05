package Day7.B1991_트리순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class B1991_트리순회_Sol {
	
	static int N;
	static int leafNode = -19; 
	static int [][] tree;

	// 전위 순회 > 노드에 들어오자마자 방문
	static void preorder(int nowNode) {
		if(nowNode == -19) return;
		System.out.print((char) (nowNode + 65));
		preorder(tree[nowNode][0]);
		preorder(tree[nowNode][1]);
		
	}
	
	// 중위 순회 > 노드에 들어가고 왼쪽 노드를 방문하고 돌아와서 방문
	static void inorder(int nowNode) {
		if(nowNode == -19) return;
		inorder(tree[nowNode][0]);
		System.out.print((char) (nowNode + 65));
		inorder(tree[nowNode][1]);
		
	}
	
	// 후위 순회 > 노드에 들어가고 오른쪽 노드를 방문하고 돌아와서 방문
	static void postorder(int nowNode) {
		if(nowNode == -19) return;
		postorder(tree[nowNode][0]);
		postorder(tree[nowNode][1]);
		System.out.print((char) (nowNode + 65));
	}
	
	// BFS 구현
	static void BFS(int root) {
		
		Queue <Integer> que = new ArrayDeque<>();
		que.add(root);
		
		// 큐가 비어있을떄까지 반복
		while(!que.isEmpty()) {
			int nowNode = que.poll();
			if(nowNode == -19) continue;				// 말단 노드인 경우
			System.out.print((char) (nowNode + 65)); // 현재노드 출력
			for(int nextNode : tree[nowNode]) {
				que.add(nextNode);
			}
		}
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(io.readLine());
		tree = new int [N][2];
		
		for(int i=0; i <N; i++) {
			String [] temp = io.readLine().split(" ");
			int node = temp[0].charAt(0) - 'A';
			int left = temp[1].charAt(0) - 'A';
			int right = temp[2].charAt(0) - 'A';
			tree[node][0] = left;
			tree[node][1] = right;
		}
		
		for(int i=0; i<N; i++) System.out.println(Arrays.toString(tree[i]));
		
		System.out.print("전위 순회 - ");
		preorder(0);
		System.out.print("\n중위 순회 - ");
		inorder(0);
		System.out.print("\n후위 순회 - ");
		postorder(0);
		System.out.print("\nBFS - ");
		BFS(0);
		
		
	}
}
