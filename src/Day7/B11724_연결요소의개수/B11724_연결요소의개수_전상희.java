package day07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B11724_연결요소의개수 {
	static ArrayList<Integer>[] graph;
	static boolean[] isVisited;
	
	static void DFS(int startV) {
		isVisited[startV] = true;
		//System.out.print(startV + " ");
		
		for(int nextNode : graph[startV]) {
			if(isVisited[nextNode]) continue;
			DFS(nextNode);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(token.nextToken()); // 정점의 개수 N개
		int M = Integer.parseInt(token.nextToken()); // 간선의 개수 M개
		
		graph = new ArrayList[N+1];
		isVisited = new boolean[N+1];
		
		for(int i=0; i<N+1; i++) {		
			graph[i] = new ArrayList<>();
		}
		for(int i=0; i<M; i++) {
			token = new StringTokenizer(bf.readLine());
			int u = Integer.parseInt(token.nextToken());
			int v = Integer.parseInt(token.nextToken());
			
			graph[u].add(v);
			graph[v].add(u);
		}
		
		int count = 0;
		for(int i=1; i<N+1; i++) {
			if(isVisited[i]!=true) {
				DFS(i);
				count++;
			}
		}
		System.out.println(count);
		
	}
}
