package Day2.B2164_카드2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class B2164_카드2_박상희 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		
		Queue<Integer> que = new ArrayDeque<>();
		for (int n = 1; n <= N; n++) {
			que.offer(n);
		}
		
		while (que.size() != 1) {
			que.poll();
			que.add(que.poll());
		}
		
		System.out.println(que.poll());
	}
}
