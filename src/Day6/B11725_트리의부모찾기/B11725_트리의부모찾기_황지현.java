import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class B11725_트리의부모찾기_황지현 {
	//이중 리스트를 만들기 위한 ArrayList선언
	static boolean [] isVisited;
	static int N;
	static int [] whoParents;
	static ArrayList <Integer> [] tree;
	
	public static void treeSearch(int node) {
		
		for(int child: tree[node]) {
			
			if(isVisited[child]) continue;
			
			//재귀
			isVisited[child]=true;
			whoParents[child]=node;
			treeSearch(child);
			
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		Scanner sc= new Scanner(System.in);
		
		N=sc.nextInt();
		
		//인접리스트 초기화
		tree=new ArrayList[N+1];
		
		
		for(int i=0; i<tree.length;i++) {
			tree[i]=new ArrayList<>();
		}
		
		 // 마킹배열 초기화
        isVisited = new boolean [N+1];
        whoParents=new int[N+1];
		
		
		for(int i=0;i<N-1;i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			tree[a].add(b);
			tree[b].add(a);
			
		}
		
	//RootNode부터 탐색(재귀)
		treeSearch(1);		
	
		for(int i=2;i<N+1;i++)System.out.println(whoParents[i]);
		
	}
}