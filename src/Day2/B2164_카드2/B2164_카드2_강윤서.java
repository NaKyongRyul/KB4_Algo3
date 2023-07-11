package Day2.B2164_카드2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class B2164_카드2_강윤서 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Queue <Integer> queue = new ArrayDeque<>();
		
		int n = Integer.parseInt(br.readLine());
		
		// 큐에 카드 담기
		for (int i=0; i<n; i++) {
			queue.offer(i+1);
		}
		
		// 모든 카드 반복
		int popValue = 0;
		int count = 0;
		while(!queue.isEmpty()) {
			if ((count % 2) == 0) { // 버리기
				popValue = queue.poll();
			} else {
				queue.offer(queue.poll());  // 카드 밑으로 옮기기
			}
			count++;
		}
		System.out.println(popValue);
	}
}
