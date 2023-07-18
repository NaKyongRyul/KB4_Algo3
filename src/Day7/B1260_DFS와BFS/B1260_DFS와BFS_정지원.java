package Day7.B1260_DFS와BFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B1260_DFS와BFS_정지원 {
	static ArrayList<Integer>[] graph;
	static boolean[] isVisited;
	static ArrayDeque<Integer> queue = new ArrayDeque<>();
	
	static void dfs(int now) {
		
		isVisited[now] = true;
		System.out.print(now + " ");
		
		ArrayList<Integer> arr = new ArrayList<>();
		
		for(int i=0;i<graph[now].size();i++) {
			arr.add(graph[now].get(i));
		}
		Collections.sort(arr);
		for(int i=0;i<arr.size();i++) {
			if(isVisited[arr.get(i)]) continue;
			dfs(arr.get(i));
		}
	}
	
	static void bfs(int now) {
		System.out.print(now + " ");
		isVisited[now] = true;
		
		ArrayList<Integer> arr = new ArrayList<>();
		
		for(int i=0;i<graph[now].size();i++) {
			arr.add(graph[now].get(i));
		}
		Collections.sort(arr);
		
		for(int i=0;i<arr.size();i++) {
			queue.add(arr.get(i));
		}
		
		while(queue.size()!=0) {
			if(!isVisited[queue.peek()]) bfs(queue.poll());
			else queue.poll();
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int v = sc.nextInt();
		
		graph = new ArrayList[n+1];
		isVisited = new boolean[n+1];
		
		for(int i=0;i<n+1;i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0;i<m;i++) {
			int a, b;
			a = sc.nextInt();
			b = sc.nextInt();
			graph[a].add(b);
			graph[b].add(a);
		}

		
		dfs(v);
		
		for(int i=0;i<isVisited.length;i++) {
			isVisited[i] = false;
		}
		System.out.println();
		bfs(v);
	}
}
