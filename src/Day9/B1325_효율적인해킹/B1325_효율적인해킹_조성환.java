package Day9.B1325_효율적인해킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1325_효율적인해킹_조성환 {
	static int N, M;
	static ArrayList<Integer>[] graph;
	static int [] cnt_arr;
	static boolean[] isVisited;
	
	public static void DFS(int start) {
		isVisited[start] = true;
		for (int nextNode : graph[start]) {
			if (isVisited[nextNode])
				continue;
			cnt_arr[nextNode]++;
			DFS(nextNode);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int max = 0;
		
		cnt_arr = new int [N+1];

		graph = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[u].add(v);
		}
		
		for (int i = 0 ; i < N + 1 ; i++) {
			isVisited = new boolean[N + 1];
			DFS(i);		
			System.out.println(Arrays.toString(cnt_arr));
		}
		
		
		for (int i = 0 ; i < N + 1 ; i++) {
			if(cnt_arr[i] > max) {
				max = cnt_arr[i];
			}
		}
		
		for (int i = 0 ; i < N + 1 ; i++) {
			if(cnt_arr[i] == max) {
				System.out.print(i + " ");
			}
		}
	}

}
