package Day8.B13023_ABCDE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B13023_ABCDE_김현지 {
	static int N;
	static int M;
	static int cnt;
	static int answer;
	
	static ArrayList <Integer>[] graph;
	static boolean [] visited;

	
	public static void dfs(int nowNode) {
		if (cnt == 4) {
			answer = 1;
			// 여기서 return했을 때 dfs를 빠져낭지 않는 이유: dfs(nextNode)위치로 빠져나오기 때문인 것 같아서 위치 옮김
			return;
		}
//		System.out.println("nowNode: " + nowNode + ", cnt: " + cnt);
		visited[nowNode] = true;
		for (int nextNode: graph[nowNode]) {
			if (visited[nextNode]) {
				continue;
			}
			cnt++;
			visited[nextNode] = true;
			dfs(nextNode); 
			if (cnt == 4) {
			answer = 1;
			// 여기로 옮김
			return;
		}
			// 백트래킹
//			System.out.println("count-- 수행, backNode: " + nextNode);
			visited[nextNode] = false;
			cnt--;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    
	    // 트리 초기화
	    graph = new ArrayList [N];
//	    visited = new boolean [N];


	    for (int i=0; i<N; i++) {
	    	graph[i] = new ArrayList<Integer>();
	    }

	    // 간선 연결
	    int fromNode;
	    int toNode;
	    for (int i=0; i<M; i++) {
	    	st = new StringTokenizer(br.readLine());
	    	fromNode = Integer.parseInt(st.nextToken());
	    	toNode = Integer.parseInt(st.nextToken());
	    	graph[fromNode].add(toNode);
	    	graph[toNode].add(fromNode);
	    }
	    
//		// graph에 입력이 제대로 되어있는지 확인
//		for(int i=0; i<N; i++) {
//			System.out.println(graph[i]);
//		}
	    
		answer = 0;
	    for (int i=0; i<N; i++) {
	    	cnt = 0;
	    	// 방문 초기화 : 이 부분 때문에 3시간 걸림... 
	    	// 초기화 생각없이 하지말자!
	    	visited = new boolean [N];
	    	dfs(i);
//	    	System.out.println("================");
	    	if (answer == 1) {
	    		break;
	    	}
	    }


	    System.out.println(answer);


	}

}
