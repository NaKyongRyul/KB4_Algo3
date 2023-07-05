package Day8.B1697_숨바꼭질;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1697_숨바꼭질_조성환 {

	static int N,M;
	static int [] arr;
	static boolean[] isVisited;
	static int[] moving = new int []{-1,1,2};
	
	static void move() {
		Queue<Integer> que = new ArrayDeque<>();
		que.add(N);
		isVisited[N] = true;
		
		while(!que.isEmpty()) {
			int now = que.poll();
			if(now == M) {
				return;
			}
			for (int i = 0 ; i < 3 ; i++) {
				int end = now;
				if(i == 2) {
					end *= moving[i];
				}else {
					end += moving[i];
				}
				if(end > -1 && end < 100001) {
					if(isVisited[end] != true) {
						isVisited[end] = true;
						arr[end] = arr[now] + 1;
						que.add(end);
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int [100001];
		isVisited = new boolean [100001];
		
		move();
		System.out.println(arr[M]);
	}

}
