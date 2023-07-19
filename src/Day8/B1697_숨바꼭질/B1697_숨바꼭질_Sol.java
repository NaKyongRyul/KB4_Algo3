package Day8.B1697_숨바꼭질;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class B1697_숨바꼭질_Sol {

	static int N;
	static int K;
	static int maxValue = 100001;
	static int ans = 0;
	static int [] time;
	
	
	public static void searchBFS() {
		
		Queue<Integer> que = new ArrayDeque<>();
		time = new int [maxValue];
		
		que.add(N);
		time[N] = 0;
		
		while(!que.isEmpty()) {
			
			int now = que.poll();
			if(now == K) return;
			
			// 1). X + 1 
			if( (now + 1) >= 0 && (now + 1) < maxValue && time[now + 1] == 0 ) {
				que.add(now + 1);
				time[now + 1] = time[now] + 1;
			}
			
			// 2). X - 1
			if( (now - 1) >= 0 && (now - 1) < maxValue && time[now - 1] == 0) {
				que.add(now - 1);
				time[now - 1] = time[now] + 1;
			}
			
			// 3). X*2 연산
			if( (now*2) >= 0 && (now*2) < maxValue && time[now * 2] == 0) {
				que.add(now*2);
				time[now*2] = time[now] + 1;
			}
			
		}
	}

	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		
		searchBFS();
		System.out.println(time[K]);

	}

}
