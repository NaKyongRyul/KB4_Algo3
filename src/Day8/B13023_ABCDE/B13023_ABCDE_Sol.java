package Day8.B13023_ABCDE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class B13023_ABCDE_Sol {

	static int N;
	static int M;
	static ArrayList <Integer> [] graph;
	static boolean [] isVisited;
	static int flag = 0;
	
	public static void searchDFS(int nowNode , int cnt) {
		
		if(isVisited[nowNode]) return;
		
		// 종료 = 연속된 5개의 노드 발견 //
		if(cnt >= 5 || flag == 1) {
			flag = 1;
			return;
		}
		
		// 방문된 노드 체크 //
		isVisited[nowNode] = true;
		
		for(int nextNode : graph[nowNode]) {
			searchDFS(nextNode , cnt + 1);
		}
		
		// 탐색 실패 후 체크 해제 // 	
		isVisited[nowNode] = false;
	}


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer token = new StringTokenizer(io.readLine() , " ");
		
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		
		graph = new ArrayList [N];
		for(int i=0; i<N; i++) graph[i] = new ArrayList<>();
		
		for(int i=0; i<M; i++) {
			token = new StringTokenizer(io.readLine() , " ");
			int u = Integer.parseInt(token.nextToken());
			int v = Integer.parseInt(token.nextToken());
			graph[u].add(v);
			graph[v].add(u);
		}
		
		for(int i=0; i < N; i++) {
			isVisited = new boolean[N];
			searchDFS(i,1);
		}

		System.out.println(flag);
	}
}

