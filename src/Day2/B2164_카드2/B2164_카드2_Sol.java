package Day2.B2164_카드2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class B2164_카드2_Sol {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());

		Queue <Integer> que = new ArrayDeque<>();
		for(int i=1; i<N + 1; i++) que.offer(i);

		for(int i=0; i<N-1; i++) {
			que.poll();
			que.offer(que.poll());
		}

		System.out.println(que.poll());
	}
}

