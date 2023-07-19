package Day8.B1697_숨바꼭질;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1697_숨바꼭질_나웅기 {
	static int n;
	static int k;
	static int [] visited;
	static Queue<Integer> que;
	
	public static void bfs(int x) {
		que.add(x);
		
		
		while (!que.isEmpty()) {
			int num = que.poll();
			
			if (num == k) return;
			
			if (num + 1 <= 100000 && visited[num + 1] == 0 ) {
				visited[num + 1] = visited[num] + 1;
				que.add(num + 1);
			}
			
			if (num - 1 >= 0 && visited[num - 1] == 0) {
				visited[num - 1] = visited[num] + 1;
				que.add(num - 1);
			}
			
			if (num * 2 <= 100000 && visited[num * 2] == 0) {
				visited[num * 2] = visited[num] + 1;
				que.add(num * 2);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		que = new ArrayDeque<>();
		visited = new int [100001];
		bfs(n);
		System.out.println(visited[k]);
	}
}
