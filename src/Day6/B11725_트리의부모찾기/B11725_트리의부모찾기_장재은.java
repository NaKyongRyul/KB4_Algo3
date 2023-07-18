package Day6.B11725_트리의부모찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11725_트리의부모찾기_장재은 {
	
	static int N;
	static ArrayList <Integer> [] tree;
	static boolean [] isVisited;
	static int [] whoParents;
	
	public static void searchParent(int i) {
		isVisited[i] = true;
		for(int t:tree[i]) {
			if(!isVisited[t]) {
				whoParents[t] = i;
				searchParent(t);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		tree = new ArrayList[N+1];
		whoParents = new int [N+1];
		isVisited = new boolean [N+1];
		for(int i=0; i<tree.length; i++)
			tree[i] = new ArrayList<>();
		
		for(int i=0; i<N-1; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			tree[a].add(b);
			tree[b].add(a);
		}
		
		//RootNode부터 탐색(재귀)
		searchParent(1);
		
		//결과출력(whoParents배열)
		for(int i=2; i<N+1; i++)
			System.out.println(whoParents[i]);
	}
}