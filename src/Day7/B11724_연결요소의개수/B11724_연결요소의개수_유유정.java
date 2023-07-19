package Day7.B11724_연결요소의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class B11724_연결요소의개수_유유정 {
	static int N;
	static int M;
	static int V;
	static int count =0;
	static StringBuilder sb= new StringBuilder();
	static boolean [] isVisited;
	static ArrayList <Integer> [] graph;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = bf.readLine();
		String [] strs = str.split(" ");
		N = Integer.parseInt(strs[0]);
		M = Integer.parseInt(strs[1]);
		isVisited = new boolean [N+1];
		graph = new ArrayList [N+1];
		for(int i=0;i<N+1;i++)
			graph[i]=new ArrayList <>();
		
		for(int i =0;i<M;i++) {
			str = bf.readLine();
			String [] strs1 = str.split(" ");
			int a = Integer.parseInt(strs1[0]);
			int b = Integer.parseInt(strs1[1]);
			graph[a].add(b);
			graph[b].add(a);
		}
		search();
	}
	public static void search() {
		Queue<Integer> queue = new LinkedList<>();
		Stack<Integer> stack = new Stack<>();
		for(int i=1;i<N+1;i++)
			stack.add(i);
		while(!stack.isEmpty()) {
			count++;
			queue.add(stack.get(0));
			isVisited[stack.get(0)] = true;
			while(!queue.isEmpty()) {
				int nowNode = queue.poll();

				stack.remove(stack.indexOf(nowNode));
				for(int nextNode : graph[nowNode]) {
					if(isVisited[nextNode]) continue;
					isVisited[nextNode]= true;
					queue.add(nextNode);
				}

			}
		}

		
		System.out.println(count);
	}
}
