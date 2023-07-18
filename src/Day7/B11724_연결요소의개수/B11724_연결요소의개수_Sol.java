package Day7.B11724_연결요소의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B11724_연결요소의개수_Sol {

	static ArrayList <Integer> [] graph;
	static int num_groups = 0;
	static int N;
	static int M;
	
	static boolean [] isVisited;
	
	public static void searchDFS(int nowNode) {

	
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader io = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer token = new StringTokenizer(io.readLine() , " ");
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());

		graph = new ArrayList [N+1];
		for(int i=0; i<N+1; i++) graph[i] = new ArrayList<>();

		isVisited = new boolean [N+1];

		for(int i=0; i<M; i++) {
			token = new StringTokenizer(io.readLine() , " ");
			int u = Integer.parseInt(token.nextToken());
			int v = Integer.parseInt(token.nextToken());
			graph[u].add(v);
			graph[v].add(u);
		}


	}

}
