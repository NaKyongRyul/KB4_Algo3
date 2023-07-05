package Day8.B1697_숨바꼭질;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1697_숨바꼭질_길민지 {
	static int N, K;
	static int time[];
	static int move [] = new int []{1, -1, 2};
	
	static void find() {
		Queue<Integer> que = new ArrayDeque<>();
		
		que.add(N);
		time[N]=0;
		if (N==K) return; // 수빈이와 동생의 위치가 같다면 종료
		
		while(!que.isEmpty()) {
			int now = que.poll();
			
			for (int i=0; i<3; i++) {
				int next;
				if (i==2) next = now * move[i]; // 순간이동
				else next = now + move[i]; // 걷기
				
				if (next<0 || next>100_000 || time[next]!=0) continue;
				time[next] = time[now]+1; 
				que.add(next);
				if (next == K) return;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		time = new int[100_001];
		
		find();
		System.out.println(time[K]);
	}

}

