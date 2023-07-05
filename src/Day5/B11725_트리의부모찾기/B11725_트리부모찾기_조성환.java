package Day5.B11725_트리의부모찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B11725_트리부모찾기_조성환 {
	static int N;
	static ArrayList<Integer> tree [];
	
	static boolean [] isVisited;
	static int [] parent;
	
	static void findnode(int start) {
		if(start == 0) {
			return;
		}
		for (int i : tree[start]) {
			if(isVisited[i] == false) {
				isVisited[i] = true;
				parent[i] = start;
				findnode(i);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		
		N = Integer.parseInt(bf.readLine());
		
		tree = new ArrayList [N + 1];
		isVisited = new boolean [N + 1];
		parent = new int [N + 1];
		
		for(int i = 0 ; i < tree.length ; i++) {
			tree[i] = new ArrayList<>();
		}
		
		for(int i = 0 ; i < N-1 ; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			tree[u].add(v);
			tree[v].add(u);
		}
		
		findnode(1);
		
        for (int i = 2; i <= N; i++) {
            System.out.println(parent[i]);
        }
		
	}

}
