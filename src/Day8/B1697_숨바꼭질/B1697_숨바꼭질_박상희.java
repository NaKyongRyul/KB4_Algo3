package Day8.B1697_숨바꼭질;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1697_숨바꼭질_박상희 {
	static int N;
	static int K;
	static int time[];
	
	public static void search() {
		Queue<Integer> que = new LinkedList<>();
		boolean isVisited[] = new boolean[100001];
		time = new int[100001];
		int move[] = {-1, 1, 2};
		int nextMove = 0;
		
		que.offer(N);
		
		if (N == K) {
			return;
		}
		
		isVisited[N] = true;
		
		while (!que.isEmpty()) {
			int now = que.poll();
			
			for (int m = 0, moveLen = move.length; m < moveLen; m++) {
				if (m != 2) {
					nextMove = now + move[m];
				}
				else {
					nextMove = now * move[m];
				}
				
				if (nextMove >= 0 && nextMove <= 100000 && !isVisited[nextMove]) {
					que.offer(nextMove);
					isVisited[nextMove] = true;
					time[nextMove] = time[now] + 1;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(bf.readLine(), " ");

		N = Integer.parseInt(token.nextToken()); // 수빈이가 있는 위치(0 <= N <= 100000)
		K = Integer.parseInt(token.nextToken()); // 동생이 있는 위치(0 <= K <= 100000)
		
		search();
		System.out.println(time[K]);
	}
}
