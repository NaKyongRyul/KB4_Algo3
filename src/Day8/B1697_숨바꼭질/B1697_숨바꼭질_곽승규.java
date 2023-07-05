package Day8.B1697_숨바꼭질;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1697_숨바꼭질_곽승규 {

	static int N;
	static int K;
	static boolean[] visited = new boolean[100001];
	static int [] arr = new int[100001];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		BFS(N);
		System.out.println(arr[K]);
	}

	static void BFS(int num) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(num);
		visited[num] = true;
		arr[num] = 0; // 시작점은 0으로
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			if (now == K) return; 
			
			int [] cases = new int[] {now - 1, now + 1, now * 2};
			for (int c : cases) {
				if ( 0 <= c && c <= 100000 && !visited[c]) {
					visited[c] = true;
					arr[c] = arr[now] + 1;
					queue.add(c);
				}
			}
		}
	}
}
