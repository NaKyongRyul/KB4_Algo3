package Day7.B11724_연결요소의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.Stack;

public class B11724_연결요소의개수_나웅기 {
	static int n;
	static int m;
	static int v;
	static ArrayList<Integer> [] arr;
	static boolean [] visited1;
	static Stack<Integer> stack;
	static Queue<Integer> que;
	static StringBuilder ans;
	
	public static void dfs(int x) {
		if (visited1[x] == false) {
			stack.add(x);			
			visited1[x] = true;
		}
		
		int num = stack.pop();
		ans.append(num+" ");
		for (int i = 0; i<arr[num].size(); i++) {
			dfs(arr[num].get(i));
			}		
		}
	
	
	public static void bfs(int x) {
			que.add(x);			
			visited1[x] = true;
		
		while (!que.isEmpty()) {
			int num = que.poll();
			ans.append(num+" ");
			for (int i = 0; i<arr[num].size(); i++) {
				if (visited1[arr[num].get(i)] == true) {
					continue;
				}
				que.add(arr[num].get(i));
				visited1[arr[num].get(i)] = true;
				}	
		}
		
		
			
		}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String [] str = reader.readLine().split(" ");
		
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		v = Integer.parseInt(str[2]);
		
		arr = new ArrayList[n+1];
		
		for (int i = 1; i<=n ; i++) {
			arr[i] = new ArrayList<>();
		}
		
		for (int i = 0; i<m; i++) {
			str = reader.readLine().split(" ");
			int x = Integer.parseInt(str[0]);
			int y = Integer.parseInt(str[1]);
			arr[x].add(y);
			arr[y].add(x);
		}
		for (int i = 1; i<=n ; i++) {
			Collections.sort(arr[i]);
		}
		
				
		visited1 = new boolean [n+1];
		stack = new Stack<>();
		que = new ArrayDeque<>();
		ans = new StringBuilder();
		dfs(v);
		System.out.println(ans);
		visited1 = new boolean [n+1];
		ans = new StringBuilder();
		bfs(v);
		System.out.println(ans);
		
	}
}
