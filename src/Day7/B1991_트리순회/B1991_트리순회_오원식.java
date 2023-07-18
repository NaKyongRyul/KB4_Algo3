package Day7.B1991_트리순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class B1991_트리순회_오원식 {
	
	static int N;
	static HashMap<String, String[]> tree = new HashMap<String, String[]>();
	static String root;
	static String left;
	static String right;
	
	public static void preorder(String v) {
		if(!v.equals(".")) {
			System.out.print(v);
			preorder(tree.get(v)[0]);
			preorder(tree.get(v)[1]);
		}
		
		return;
	}
	
	public static void inorder(String v) {
		if(!v.equals(".")) {
			inorder(tree.get(v)[0]);
			System.out.print(v);
			inorder(tree.get(v)[1]);
		}
		
		return;
	}
	
	public static void postorder(String v) {
		if(!v.equals(".")) {
			postorder(tree.get(v)[0]);
			postorder(tree.get(v)[1]);
			System.out.print(v);
		}
		
		return;
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		tree = new HashMap<>();
		
		for(int i = 0; i<N; i++) {
			String [] s = br.readLine().split(" ");
			root = s[0];
			left = s[1];
			right = s[2];  

			String [] input = {left, right};
			tree.put(root, input);
		}
		
		preorder("A");
		System.out.println();
		inorder("A");
		System.out.println();
		postorder("A");

	}

}
