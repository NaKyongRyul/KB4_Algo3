package Day7.B11724_연결요소의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11724_연결요소의개수_곽승규 {
	static int N; // 정점의 개수
	static int M; // 간선의 개수
	static ArrayList <Integer> [] graph;
	static boolean [] visited;
	static int count;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 인접리스트 생성
		graph = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		
		// 인접리스트에 값 넣기
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			graph[s].add(e);
			graph[e].add(s);
		}
		
		visited = new boolean[N+1];
		
		for (int i = 1; i <= N; i++) {
			if(!visited[i]) {
				DFS(i);
				count++;
			}
		}
		
		System.out.println(count);
		
//		System.out.println(Arrays.deepToString(graph));
	}
	
	static void DFS(int start) {
		
		visited[start] = true;
		
		//System.out.print(start + " ");
		
		for (int i : graph[start]) {
			if (!visited[i]) {
				DFS(i);
			}
		}
	}

}
