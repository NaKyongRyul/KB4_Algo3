package Day6.B11725_트리의부모찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class B11725_트리의부모찾기_오원식 {
	
	static int N;
	static ArrayList <Integer> [] tree;
	static boolean [] isVisited;
	static int [] whoParents;
	
	public static void addEdge(int u, int v) {
		tree[u].add(v);
	}
	
	public static void search(int i) {
		isVisited[i] = true;
		for(int j : tree[i]) {
			if(isVisited[j] == false) {
				whoParents[j] = i;
				search(j);
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		tree = new ArrayList [N+1];
		
		for(int i = 0; i<tree.length; i++) {
			tree[i] = new ArrayList<>();
		}
		
		isVisited = new boolean [N+1];
		whoParents = new int [N+1];
		
		for(int i = 0; i<N-1; i++) {
			String [] s = br.readLine().split(" ");
			int u = Integer.parseInt(s[0]);
			int v = Integer.parseInt(s[1]);
			
			addEdge(u, v);
			addEdge(v, u);
		}
		//System.out.println(Arrays.toString(tree));
		search(1);
		//System.out.println(Arrays.toString(whoParents));
		for(int i = 2; i<N+1; i++) System.out.println(whoParents[i]);
		
	}

}
