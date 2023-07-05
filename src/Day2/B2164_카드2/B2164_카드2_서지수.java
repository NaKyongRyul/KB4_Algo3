package Day2.B2164_카드2;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class B2164_카드2_서지수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		Queue<Integer> que = new ArrayDeque<>();

		for (int i = 1; i <= N; i++) {
			que.add(i);
		}

		while (!que.isEmpty()) {
			if (que.size() == 1)
				break;

			que.poll();
			que.add(que.poll());
		}
		System.out.println(que.peek());
	}

}
