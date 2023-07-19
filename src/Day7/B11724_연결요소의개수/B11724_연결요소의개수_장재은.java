package Day7.B11724_연결요소의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B11724_연결요소의개수_장재은 {
	
	static int N;
	static int M;
	static int cnt = 0;
	static ArrayList <Integer> [] arr;
	static boolean [] isVisited;
	
	public static void dfs(int i) {
		isVisited[i] = true;
		for(int a : arr[i]) {
			if(isVisited[a] == true) continue;
			dfs(a);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String strs[] = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		M = Integer.parseInt(strs[1]);
		
		isVisited = new boolean[N + 1];
		arr = new ArrayList[N + 1];
		for(int i=0; i<N+1; i++)
			arr[i] = new ArrayList<>();
		
		for(int i=0; i<M; i++) {
			String points[] = br.readLine().split(" ");
			int u = Integer.parseInt(points[0]);
			int v = Integer.parseInt(points[1]);
			
			arr[u].add(v);
			arr[v].add(u);
		}
		
		for(int i=1; i<N+1; i++) {
			if(!isVisited[i]) {
				dfs(i);	
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}