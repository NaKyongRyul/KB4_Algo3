package Day2.B2164_카드2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class B2164_카드2_이우엽 {
	static Queue<Integer> queue = new ArrayDeque<>();
	
	public static void workOrder() {
		queue.remove();
		
		int top = queue.remove();
		queue.offer(top);
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine()); // 6
		
		// 전체 카드 초기화, 123456
		for(int i = 1; i <= N; i++) {
			queue.offer(i);
		}
		
		while(queue.size() != 1) {
			workOrder();
		}
		
		System.out.println(queue.peek());
	}

}
