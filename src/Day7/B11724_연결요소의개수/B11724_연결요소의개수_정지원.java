package Day7.B11724_연결요소의개수;

import java.util.ArrayList;
import java.util.Scanner;

public class B11724_연결요소의개수_정지원 {
	static ArrayList<Integer>[] graph;
	static boolean[] isVisited;
	
	static void dfs(int now) {
		
		isVisited[now] = true;
		
		ArrayList<Integer> arr = new ArrayList<>();
		
		for(int i=0;i<graph[now].size();i++) {
			arr.add(graph[now].get(i));
		}
		for(int i=0;i<arr.size();i++) {
			if(isVisited[arr.get(i)]) continue;
			dfs(arr.get(i));
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = 0;
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		graph = new ArrayList[n+1];
		isVisited = new boolean[n+1];
		
		for(int i=0;i<n+1;i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0;i<m;i++) {
			int a, b;
			a = sc.nextInt();
			b = sc.nextInt();
			graph[a].add(b);
			graph[b].add(a);
		}

		
		dfs(1);
		count++;
		for(int i=1;i<isVisited.length;i++) {
			if(!isVisited[i]) {
				count++;
				dfs(i);
			}
		}
		System.out.println(count);
	}
}
