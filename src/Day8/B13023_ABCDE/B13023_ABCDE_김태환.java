package Day8.B13023_ABCDE;

import java.util.ArrayList;
import java.util.Scanner;


public class B13023_ABCDE_김태환 {
	static boolean isVisited [];
	static int cnt;
	static ArrayList<Integer> graph [];
	static int N;
	static void search(int node) {
		 isVisited= new boolean[N+1];
	for (int i : graph[node]) {
		if (isVisited[i]) continue;
		isVisited[i]=true;
		cnt++;
//		System.out.println(cnt);
	if(cnt==4) {
		System.out.println(1);
	}
		search(i);
	
	}
}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N=sc.nextInt();
		int M=sc.nextInt();
		graph=new ArrayList[N];
		 for (int i = 0; i < N; i++) {
		      graph[i]=new ArrayList<>(); }
		 for (int i = 0; i< M;i++) {
			int L=sc.nextInt();
			int U=sc.nextInt();
			graph[L].add(U);
			 graph[U].add(L);
		 }
		
//	
//		for (int t=0;t<N;t++) {
//			search(t);
//		}
//		System.out.println(cnt);
		for(int i=0;i<graph.length;i++) {
			
		System.out.println(graph[i]);
		}

	}

}
