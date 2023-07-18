package Day7.B1991_트리순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B1991_트리순회_전종한 {
	static int N;
	static ArrayList <Integer> [] tree;
	static int [] parent;

	public static void preDFS(int nowNode) {
		System.out.print((char)(nowNode+65));
		for(int nextNode : tree[nowNode]) {
			if(nextNode != -1) preDFS(nextNode);
		}
	}

	public static void inDFS(int nowNode) {
		int size = tree[nowNode].size();
		if(tree[nowNode].get(0) == -1 && tree[nowNode].get(1) == -1) { // 리프노드일떄
			System.out.print((char)(nowNode+65));
		}else if(tree[nowNode].get(0) != -1 && tree[nowNode].get(1) == -1) { // Left만 있을떄
			inDFS(tree[nowNode].get(0));
			System.out.print((char)(nowNode+65));
		}else if(tree[nowNode].get(0) == -1 && tree[nowNode].get(1) != -1) { // Right만 있을떄
			System.out.print((char)(nowNode+65));
			inDFS(tree[nowNode].get(1));
		}else { // 둘 다 있을떄
			inDFS(tree[nowNode].get(0));
			System.out.print((char)(nowNode+65));
			inDFS(tree[nowNode].get(1));
		}
	}

	public static void postDFS(int nowNode) {
		if(tree[nowNode].get(0) == -1 && tree[nowNode].get(1) == -1) { // 리프노드일떄
			System.out.print((char)(nowNode+65));
		}else if(tree[nowNode].get(0) != -1 && tree[nowNode].get(1) == -1) { // Left만 있을떄
			postDFS(tree[nowNode].get(0));
			System.out.print((char)(nowNode+65));
		}else if(tree[nowNode].get(0) == -1 && tree[nowNode].get(1) != -1) { // Right만 있을떄
			postDFS(tree[nowNode].get(1));
			System.out.print((char)(nowNode+65));
		}else { // 둘 다 있을떄
			postDFS(tree[nowNode].get(0));
			postDFS(tree[nowNode].get(1));
			System.out.print((char)(nowNode+65));
		}
	}


	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		tree = new ArrayList [N];
		String [] strs;
		for(int i=0; i<N; i++) {
			strs = bf.readLine().split(" ");
			char c1 = strs[0].charAt(0);
			char c2 = strs[1].charAt(0);
			char c3 = strs[2].charAt(0);
			tree[c1-65] = new ArrayList<>();
			if(c2 != '.') tree[c1-65].add(c2-65);
			else tree[c1-65].add(-1);
			if(c3 != '.') tree[c1-65].add(c3-65);
			else tree[c1-65].add(-1);


		}

		preDFS(0);
		System.out.println();
		inDFS(0);
		System.out.println();
		postDFS(0);
	}
}
