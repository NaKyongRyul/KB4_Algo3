package Day8.B1697_숨바꼭질;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1697_숨바꼭질_김현지 {
	static int N;
	static int K;
	static int cnt = 0;
	static int [] time;
	static int MAX = 100_001;

	
	// 메모리 초과가 이전에 방문한 것에 대한 처리가 제대로 안된듯
	public static void bfs(int now) {
		Queue<Integer> que = new ArrayDeque<>();	
		que.add(now);
//		System.out.println("now: " + now);
		

		while (!que.isEmpty()) {
//			System.out.println("que: " + que);
			int next = que.poll();

			if (next == K) {
				return;
			}

			// 계속 100_001을 10_001로 잡고 있어서 2시간 틀린 이유 못잡음
			// => 숫자는 변수로 쓰자
			if (0 <= next-1 && next-1 < MAX && time[next-1] == 0) {
				que.add(next-1);
				time[next-1] = time[next] + 1;
			}

			if (0 <= next+1 && next+1 < MAX && time[next+1] == 0) {
				que.add(next+1);
				time[next+1] = time[next] + 1;
			}
			
			if (0 <= next*2 && next*2 < MAX && time[next*2] == 0) {
				que.add(next*2);
				// visited[next*2] = visited[next]; 로 계속틀림
				// => 순간이동한다고 시간이 흐르지 않는 것은 아님
				// => 문제 자세히 읽기
				// => 내가 생각했던 풀이: 시간이 변하지 않으므로  visited 배열을 따로 생성해서 체크했었음
				time[next*2] = time[next] + 1;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// N: 수빈, K: 동생
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		time = new int [MAX];
		
		bfs(N);
		System.out.println(time[K]);
//		System.out.println(Arrays.toString(visited));


	}

}
