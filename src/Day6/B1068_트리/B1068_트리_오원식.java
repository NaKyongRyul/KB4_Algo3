package Day6.B1068_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class B1068_트리_오원식 {
	
	static int N;
	static ArrayList <Integer> [] tree;
	static int delNum;
	static int root;
	static int res;
	
	public static void addEdge(int u, int v) {
		tree[u].add(v);
	}
	
	public static void search(int i) {
		if(i == delNum) return;
		
		if(tree[i].size() == 0) res++;
		
		for(int j : tree[i]) search(j);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String [] s = br.readLine().split(" ");
		delNum = Integer.parseInt(br.readLine());
		
		tree = new ArrayList [N];
		res = 0;
		
		for(int i = 0; i<tree.length; i++) {
			tree[i] = new ArrayList<>();
		}
		
		for(int i=0; i<tree.length; i++) {
			if(Integer.parseInt(s[i]) != -1) 
				addEdge(Integer.parseInt(s[i]), i);
			else root = i;
		}
		
		for(int i=0; i<N; i++) {
			tree[i].remove(Integer.valueOf(delNum));
		}
	
		search(root);
		
		//System.out.println(Arrays.toString(tree));
		System.out.println(res);
		
	}

}
