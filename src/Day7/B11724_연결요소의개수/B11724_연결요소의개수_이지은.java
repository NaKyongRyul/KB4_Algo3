package Day7.B11724_연결요소의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B11724_연결요소의개수_이지은 {
	static int N,M;
	static ArrayList <Integer> graph[];
	static int cnt = 0; //연결요소의 개수 
	static boolean [] isCheck;  //방문체크할 배열 
	
	static int check(int idx) {		
		if(isCheck[idx]) return 0; //이미 방문했으면 
		
		isCheck[idx] = true;
		for(int now : graph[idx]) {
			//방문하지 않고, 간선이 존재할 때 
			if(!isCheck[now]) check(now);
		}
		return 1; //연결 요소 하나 
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());  //정점의 개수 
		M = Integer.parseInt(st.nextToken());  //간선의 개수 
		graph = new ArrayList[N+1];
		
		for(int i=0; i<N+1; i++) graph[i] = new ArrayList<>();
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			graph[u].add(v);
			graph[v].add(u);
		}
		
		isCheck = new boolean[N+1];
	
		for(int i=1; i<N+1; i++) {
			cnt += check(i);
		}
		
//		System.out.println(Arrays.toString(isCheck));
		
		System.out.println(cnt); //연결 요소 출력 
	}
}
