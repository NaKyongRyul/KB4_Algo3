package Day7.B11724_연결요소의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;



public class B11724_연결요소의개수_김현지 {
	static int N;
	static int M;
	static int cnt = 0;
	
	static ArrayList <Integer>[] tree;
	static boolean [] visited;
	
	
	public static void BFS(int nowNode) {
		// 큐 초기화
		Queue <Integer> que = new ArrayDeque<>();
		que.add(nowNode);
		visited[nowNode] = true;
		
		StringBuilder sb = new StringBuilder();
		int node;
		while (!que.isEmpty()) {
//			System.out.println("que:" + que);
			node = que.poll();
			for (int nextNode:  tree[node]) {
				if (visited[nextNode]) {
					continue;
				}
				visited[nextNode] = true;
				que.add(nextNode);
			}
		}
//		System.out.println(Arrays.toString(visited));
	}
	
	public static boolean repeat( ) {
//		System.out.println("repeated");
		for(int i=1;i<N+1;i++) {
			if (visited[i] == false) {
				cnt += 1;
				BFS(i);
				return true;
			}
		}
		return false;
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    
	    // 트리 초기화
	    tree = new ArrayList [N+1];
	    visited = new boolean [N+1];

	    for (int i=0; i<N+1; i++) {
	    	tree[i] = new ArrayList<Integer>();
	    }

	    // 간선 연결
	    int fromNode;
	    int toNode;
	    for (int i=0; i<M; i++) {
	    	st = new StringTokenizer(br.readLine());
	    	fromNode = Integer.parseInt(st.nextToken());
	    	toNode = Integer.parseInt(st.nextToken());
	    	tree[fromNode].add(toNode);
	    	tree[toNode].add(fromNode);
	    }
	    
//		// tree에 입력이 제대로 되어있는지 확인
//		for(int i=0; i<N+1; i++) {
//			System.out.println(tree[i]);
//		}
		
		while (repeat()) {
			continue;
		}
		System.out.println(cnt);


	}

}
