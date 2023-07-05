package Day8.B1697_숨바꼭질;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1697_숨박꼭질_김혜인{

	static int n, k;  //수빈이, 동생위치
	static int[] arr = new int[100001];  //범위설정

	public static void searchBFS(int num) {
		Queue<Integer> que = new ArrayDeque<>();
		que.add(num);
		arr[num] = 1; // 수빈이 위치 초기화

		// BFS
		while (!que.isEmpty()) {
			int now = que.poll();
			for (int i = 0; i < 3; i++) {
				// 다음좌표 계산
				int next;
				// 앞뒤로 움직이는거 순간이동 할 수 있는 거
				if (i == 0)
					next = now + 1;
				else if (i == 1)
					next = now - 1;
				else {
					next = now * 2;
				}
				
				
				if (next == m) {  //수빈이와 동생의 위치가 같으면 이동할 필요가 없음
					System.out.println(arr[now]);
					return;
				}
				if (next >= 0 && next < arr.length && arr[next] == 0) {
					que.add(next);
					arr[next] = arr[now] + 1;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		if(n==m) { //위치같을 떄 
			System.out.println(0);
		}else searchBFS(n); 

	}
}
