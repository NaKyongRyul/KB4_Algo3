package Day6.B11725_트리의부모찾기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B11725_트리의부모찾기_김철 {
	static ArrayList<Integer>[] arrList;
	static boolean[] visited;
	static int[] parents;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token;
		
		int N = Integer.parseInt(br.readLine());
		arrList = new ArrayList[N+1];
		visited = new boolean[N+1];
		parents = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			arrList[i] = new ArrayList<>();
		}
		
		for(int i=0; i<N-1; i++) {
			token = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(token.nextToken());
			int end = Integer.parseInt(token.nextToken());
			arrList[start].add(end);
			arrList[end].add(start);
		}
		
		// 루트 노드 1
		DFS(1);
		
		for(int i=2; i<=N; i++) bw.write(parents[i] + "\n"); 
		bw.close();
	}
	
	static void DFS(int nowIndex) {
		visited[nowIndex] = true;
		
		for(int i : arrList[nowIndex]) {
			if(visited[i]) continue;
			
//			if(parents[i] != 0) continue;	// 있어도 없어도 됨
			parents[i] = nowIndex;
			DFS(i);
		}
	}
}
