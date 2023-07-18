package Day7.B1991_트리순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1991_트리순회_Sol {
	
	
	static int N;
	static int leafNode = -19; 
	static int [][] tree;
	
	public static void preorder(int nowNode) {
		
		// 종료
		if(nowNode == leafNode) return;
		
		System.out.print( (char) (nowNode + 'A') );
		
		// 재귀 확장
		preorder(tree[nowNode][0]);	// 왼쪽
		preorder(tree[nowNode][1]);	// 오른쪽
		
	}
	
	public static void inorder(int nowNode) {
		
		// 종료
		if(nowNode == leafNode) return;
		
		
		// 재귀 확장
		inorder(tree[nowNode][0]);	// 왼쪽
		
		System.out.print( (char) (nowNode + 'A') );
		
		inorder(tree[nowNode][1]);	// 오른쪽
		
	}
	
	public static void postorder(int nowNode) {
		
		// 종료
		if(nowNode == leafNode) return;
		
		
		// 재귀 확장
		postorder(tree[nowNode][0]);	// 왼쪽
		postorder(tree[nowNode][1]);	// 오른쪽
		System.out.print( (char) (nowNode + 'A') );
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(io.readLine());
		
		tree = new int [N][2];
		
		for(int i=0; i<N; i++) {
			
			String [] temp = io.readLine().split(" ");
			
			int node = temp[0].charAt(0) - 'A';
			int left = temp[1].charAt(0) - 'A';
			int right = temp[2].charAt(0) - 'A';
			
			tree[node][0] = left;
			tree[node][1] = right;
			
		}
		
		for(int i=0; i<tree.length; i++)
			System.out.println(Arrays.toString(tree[i]));

		preorder(0);
		System.out.println();
		inorder(0);
		System.out.println();
		postorder(0);
	}
}



