package Day8.B1697_숨바꼭질;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B1697_숨바꼭질_전종한 {
	static int N;
	static int K;
	static Queue<Integer> que = new LinkedList<>();
	static int[] sec;

	public static void findBro() {
		que.offer(N);
		sec[N] = 0;
		while(!que.isEmpty()) {
			int now = que.poll();
			if(now == K) {
				System.out.println(sec[now]);
				break;
			}
			int [] nextList = {now-1, now+1, now*2};
			for(int next : nextList) {
				if(next <= 100_000 && next >= 0 && sec[next]==0) {
					que.offer(next);
					sec[next] = sec[now]+1;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String [] strs = br.readLine().split(" ");

		N = Integer.parseInt(strs[0]);
		K = Integer.parseInt(strs[1]);

		que = new LinkedList<>();
		sec = new int [100_001];

		findBro();
	}
}
