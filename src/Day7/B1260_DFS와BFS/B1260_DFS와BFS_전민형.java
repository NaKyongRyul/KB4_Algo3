package Day7.B1260_DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class B1260_DFS와BFS_전민형 {
	
	static ArrayList <Integer> [] grap;
	static int start;
	static boolean [] isVisited;

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = reader.readLine();
		String [] com = str.split(" ");
		
		int num = Integer.parseInt(com[0]);
		int line = Integer.parseInt(com[1]);
		start = Integer.parseInt(com[2]);
		isVisited = new boolean[num+1];
		
		grap = new ArrayList[num+1];
		for(int i = 0; i<num+1; i++) {
			grap[i] = new ArrayList<>();
		}
		
		for(int i = 0; i<line; i++) {

			str = reader.readLine();
			com = str.split(" ");
			grap[Integer.parseInt(com[0])].add(Integer.parseInt(com[1]));
			grap[Integer.parseInt(com[1])].add(Integer.parseInt(com[0]));
		}

		for(int i = 0; i<num+1; i++) Collections.sort(grap[i]);		//오름차순 정렬
		
		Stack <Integer> st = new Stack<>();
		st.push(start);
		
		while(!st.isEmpty()) {										//DFS(깊이 우선 탐색)구현
			int now = st.pop();
			if(isVisited[now] == true)continue;
			isVisited[now]=true;
			
			for(int i = grap[now].size(); i>0; i--) {
				
				if(isVisited[grap[now].get(i-1)]==true)continue;
				st.push(grap[now].get(i-1));
				
			}

			System.out.print(now + " ");
		}
		
		for(int i = 0; i<num+1; i++) isVisited[i]=false;
		
		System.out.println();
		
		Queue <Integer> que = new LinkedList<>();
		
		que.add(start);
		isVisited[start]=true;
		
		while(!que.isEmpty()) {										//BFS(넓이 우선 탐색) 구현
			int now = que.poll();
			
			for(int next : grap[now]) {
				
				if(isVisited[next]==true)continue;
				que.add(next);
				isVisited[next]=true;
			}
			
			System.out.print(now + " ");
		}
		
		
		
		
	}

}
