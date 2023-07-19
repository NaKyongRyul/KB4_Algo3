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


	static int N;							// 노드수
	static int M;							// 간선수
	static ArrayList <Integer> [] graph;	// 인접리스트
	static boolean [] isVisited;			// 방문배열
	static int flag = 0;					// 정답변수 (1 or 0)
	

	public static void searchDFS(int now , int count) {
		
		// 종료 조건
		if(count >= 5 || flag == 1 ) {
			flag = 1;
			return;
		}
		
		// 다음 재귀로
		for(int nextNode : graph[now]) {
			
			// 중복되는 경우 skip
			if(isVisited[nextNode]) continue;
			
			// 다음 노드 선택 및 탐색
			isVisited[nextNode] = true;
			searchDFS(nextNode, count + 1);
			
			// 선택 해제
			isVisited[nextNode] = false;
		}
	}
	

	
	
	public static void main(String[] args) throws IOException {


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
		


		// DFS 재귀 탐색 //
		for(int i=0; i<N; i++) {
			isVisited = new boolean [N];
			isVisited[i] = true;
			searchDFS(i , 1);
			
		}
		
		System.out.println(flag);
	}
}