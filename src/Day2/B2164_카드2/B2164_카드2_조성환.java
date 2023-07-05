package Day2.B2164_카드2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class B2164_카드2_조성환 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		Queue<Integer> que = new ArrayDeque<Integer>();
		
		for (int i = 1 ; i <= N ; i++) {
			que.add(i);
		}
		
		while (que.size() != 1) {
			// 맨 위 한장 제거
			que.remove();
			// 다음 맨 위 한장 집어
			int up = que.poll();
			que.add(up);
		}
		System.out.println(que.poll());
		
	}

}
