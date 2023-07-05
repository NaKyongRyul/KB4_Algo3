package Day2.B1158_요세푸스문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1158_요세푸스문제_곽승규 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// 큐 생성
		Queue<Integer> queue = new ArrayDeque<>();
		
		// 큐에 값 넣기
		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}
		
		StringBuilder ans = new StringBuilder();
		ans.append("<");
	
		while(!queue.isEmpty()) {
			int idx = K-1; //idx 값 만큼 앞의 값을 뒤로 보낼 것임.
			
			// queue의 사이즈가 1이면 굳이 for문 안돌고 바로 값넣고 나옴
			if (queue.size() == 1) {
				ans.append(queue.remove());
			}
			else {
				for (int j = 0; j < idx; j++) {
					int value = queue.remove();
					queue.add(value);
				}
				//idx값 만큼 돌고 맨 앞의 값 가지고 ans에 붙이기
				ans.append(queue.remove());
			}
			
			if (queue.size() != 0) ans.append(", ");
		}
		
		ans.append(">");
		System.out.println(ans);
	}

}
