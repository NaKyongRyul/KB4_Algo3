package Day5.B11725_트리의부모찾기;

import java.util.ArrayList;
import java.util.Scanner;

public class B11725_트리의부모찾기_김혜인{

	static int N;
	static ArrayList<Integer> tree [];
	static boolean [] isVisited;
	static int[] parent;
	
	static void Parentnode(int node) {
		if(node==0) {  //0일때 빠져나감
			return;
		}for(int i : tree[node]) {
		     if(!isVisited[i]) {       // 방문안했을 경우 방문
		    	 isVisited[i] = true;            
			     parent[i]= node;     //  
			     Parentnode(i);
		}
		}	
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		tree = new ArrayList[N + 1];
		isVisited = new boolean [N+1];
		parent = new int[N+1];
		
		
	    for (int i = 0; i < tree.length; i++) {
	        tree[i] = new ArrayList<>();
	      }
		
	    
		for(int i=0; i<N-1; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			tree[u].add(v);
			tree[v].add(u);
		}
		
		/*
		for(int i=0; i<tree.length; i++) {
			System.out.println(i + " 노드 : " + tree[i]);
		}
		*/
		
		Parentnode(1);
																
		//부모 노드 출력
		for (int i=2;i<N+1;i++) {   //첫번쨰는 부몬 노드 없음.
			System.out.println(parent[i]);
		}
		
}			
}
