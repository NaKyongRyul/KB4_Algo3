package Day8.B1697_숨바꼭질;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1697_숨바꼭질_김태선 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		if(N == K) {
			System.out.println(0);
			return;
		}
		
		boolean[] visited = new boolean[100001];
		visited[N] = true;
		
		Queue <Integer> que = new ArrayDeque<>();
		que.add(N);
		
		int size = que.size();
		int cnt = 0;
		
		while(!que.isEmpty()) {
			cnt++;
			size = que.size();
			
			for (int i = 0; i < size; i++) {
				int x = que.remove();
				visited[x] = true;
				
				if (x - 1 == K || x + 1 == K || x * 2 == K) {
					System.out.println(cnt);
					return;
				}
				
				if(x - 1 >= 0 && !visited[x - 1]) {
					visited[x - 1] = true;
					que.add(x - 1);
				}	
				if(x + 1 <= 100000 && !visited[x + 1]) {
					visited[x + 1] = true;
					que.add(x + 1);
				}
				if(x * 2 <= 100000 && !visited[x * 2]) {
					visited[x * 2] = true;
					que.add(x * 2);
				}	
			}
		}
		
	}

}
