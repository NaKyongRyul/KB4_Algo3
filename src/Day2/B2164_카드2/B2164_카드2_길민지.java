package Day2.B2164_카드2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class B2164_카드2_길민지 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		// 정수 N 입력
		int N = Integer.parseInt(bf.readLine());
		
		// 큐 생성
		Queue <Integer> que = new ArrayDeque<>();
		
		for (int i = 1; i<N+1; i++) {
			que.add(i);
		}
		
		while(que.size()>1) {
			que.poll();
			que.add(que.poll());
		}
		// 결과 출력
		System.out.println(que.peek());
	}

}
