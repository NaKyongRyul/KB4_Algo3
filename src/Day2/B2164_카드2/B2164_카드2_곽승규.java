package Day2.B2164_카드2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class B2164_카드2_곽승규 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Queue <Integer> queue = new ArrayDeque<>();
		
		// 큐에 값 넣기
		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}
		
		while (queue.size() != 1) {
			// 맨 앞에 있는 값 버리기
			queue.remove();
			int value = queue.remove();
			queue.add(value);
		}
		
		System.out.println(queue.peek());

	}

}
