package Day2.B2164_카드2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class B2164_카드2_오원식 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue <Integer> que = new ArrayDeque<>();
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 1; i < N+1; i++)
			que.offer(i);
		
		while(que.size() != 1) {
			que.poll();
			que.offer(que.poll());
		}
		System.out.println(que.peek());
	}

}
