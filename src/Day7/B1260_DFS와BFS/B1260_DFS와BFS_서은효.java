package Day7.B1260_DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class B1260_DFS와BFS_서은효 {
	static int N; //노드의 개수
	static int M; //간선의 개수
	static int V; //탐색 시작할 정점의 번호 
	static ArrayList<ArrayList<Integer>> list; //인접 리스트 
	static boolean[] isVisited;
	static boolean[] bfs_isVisited;
	static Stack<Integer> stack = new Stack<>();
	static Queue<Integer> que = new ArrayDeque<>();
	static ArrayList<Integer> arr;
	static ArrayList<Integer> dfs_arr;
	
	
	public static void BFS(int node) {
		
		if( bfs_isVisited[node] == true )return;
		bfs_isVisited[node] = true;
		System.out.print(node+" ");
		
		arr = new ArrayList<>();
		
		if (list.get(node).size() != 1) {
			for(int i = 0 ; i<list.get(node).size() ;i++) {
				arr.add(list.get(node).get(i));
			}arr.sort(null);
			for(int x : arr) que.add(x);
		}
		else {
			que.add(list.get(node).get(0));
		}
		

		while(!que.isEmpty()) {
			BFS(que.poll());
		}	
	}
	
	public static void DFS(int node) {
		
		if( isVisited[node] == true )return;
		isVisited[node] = true;
		System.out.print(node+" ");
		
		dfs_arr = new ArrayList<>();
		
		if (list.get(node).size() != 1) {
			for(int i = 0 ; i<list.get(node).size() ;i++) {
				dfs_arr.add(list.get(node).get(i));
			}dfs_arr.sort(null);
			
			for(int i = dfs_arr.size()-1 ; i>=0 ;i--)
				stack.push(dfs_arr.get(i));
		}
		else {		
				stack.push(list.get(node).get(0));
		}
		
		while(!stack.isEmpty()) {
			DFS(stack.pop());
		}

	}
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(bf.readLine()," ");
		
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		V = Integer.parseInt(token.nextToken());
		list = new ArrayList<ArrayList<Integer>>();
		isVisited = new boolean[N+1];
		bfs_isVisited = new boolean[N+1];
		
		for(int i =0; i<N+1; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		for(int i =1; i<M+1; i++) {
			String[] temp = bf.readLine().split(" ");
			int node =Integer.parseInt(temp[0]);
			int near =Integer.parseInt(temp[1]);
			list.get(node).add(near);
			list.get(near).add(node);
		}
		DFS(V);
		System.out.println();
		BFS(V);
	}

}
