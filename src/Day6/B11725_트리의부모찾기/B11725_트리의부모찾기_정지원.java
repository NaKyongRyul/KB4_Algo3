package Day6.B11725_트리의부모찾기;

import java.util.ArrayList;
import java.util.Scanner;

public class B11725_트리의부모찾기_정지원 {
	static int [] parents;
	static boolean[] isVisited;
	static ArrayList<Integer>[] tree;
	
	
	public static void findParent(int num) {
		if(isVisited[num]) return;
		
		isVisited[num] = true;
		
		for(int i=0;i<tree[num].size();i++) {
			if(isVisited[tree[num].get(i)])continue;
			parents[tree[num].get(i)] = num;
			
			findParent(tree[num].get(i));
		}
		
	}
	
	
    public static void main(String[] args) {
    	
    	Scanner sc = new Scanner(System.in);
    	
    	int n = sc.nextInt();
    	
    	tree = new ArrayList[n+1];
    	isVisited = new boolean[n+1];
    	parents = new int[n+1];
    	
    	for(int i=0;i<tree.length;i++) {
    		tree[i] = new ArrayList<>();
    	}
    	
    	int u, v;
    	for(int i=0;i<n-1;i++) {
    		u = sc.nextInt();
    		v = sc.nextInt();
    		
    		tree[u].add(v);
    		tree[v].add(u);
    		
    	}

    	
    	findParent(1);
    	
    	for(int i=2;i<=n;i++) {
    		System.out.println(parents[i]);
    	}
    	
	}
}
