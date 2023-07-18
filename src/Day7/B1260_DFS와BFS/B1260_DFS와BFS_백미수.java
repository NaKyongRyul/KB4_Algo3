package Day7.B1260_DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.Stack;

public class B1260_DFS와BFS_백미수 {

	static int N;
	static int M;
	static int V;
	static ArrayList<Integer>[] graph;
	static boolean[] isVisited;
	static Stack<Integer> stack = new Stack<Integer>();
	static Queue<Integer> que = new ArrayDeque<Integer>();
	
	public static void DFS1(int now) {
		
		stack.add(now);
	
		while(!stack.isEmpty()) {
			now = stack.pop();
			
			for(int i =0; i<graph[now].size(); i++) {
				if(isVisited[graph[now].get(i)]==true) {
					continue;
				}
				stack.add(graph[now].get(i));
				isVisited[graph[now].get(i)] = true;
			}
			System.out.print(now+" ");
		}
		
		System.out.println();
	}
	
	public static void DFS2(int now) {
		
		// 확장
		//nextNode는 tree의 nowNode 리스트에 들어있는 값들이다.
		System.out.print(now+" ");
		for(int nextNode : graph[now]) {
			// 중복 확인
			if(isVisited[nextNode]) continue;
			
			// 다음 재귀
			isVisited[nextNode] = true;	//확인했으면 true로 변경
			DFS2(nextNode);
		}
	}
	
	public static void BFS(int now) {
		
		que.add(now);
	
		while(!que.isEmpty()) {
			now = que.poll();
			
			for(int i =0; i<graph[now].size(); i++) {
				if(isVisited[graph[now].get(i)]==true) {
					continue;
				}
				que.add(graph[now].get(i));
				isVisited[graph[now].get(i)] = true;
			}
			System.out.print(now+" ");
		}
		
		System.out.println();
	}
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = reader.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		V = Integer.parseInt(str[2]);
		
		//인접배열 생성
		graph = new ArrayList[N+1];
		for(int i=1; i<N+1; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<M; i++) {
			String[] str2 = reader.readLine().split(" ");
			int num1 = Integer.parseInt(str2[0]);
			int num2 = Integer.parseInt(str2[1]);
			
			graph[num1].add(num2);
			graph[num2].add(num1);
			
		}
		
		for(int i=1; i<N+1; i++) {
			Collections.sort(graph[i]);
		}
		
		
		//마킹배열
		isVisited = new boolean[N+1];
		isVisited[V] = true;
		
		//DFS 스택이용
		DFS1(V);
		
		//DFS 재귀사용
		isVisited = new boolean[N+1];
		isVisited[V] = true;
		
		DFS2(V);
		
		System.out.println();
		
		//BFS
		isVisited = new boolean[N+1];
		isVisited[V] = true;
		BFS(V);
		
	}

}