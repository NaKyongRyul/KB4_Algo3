package Day2.B2164_카드2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class B2162_카드2_이채림 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> queue = new ArrayDeque<>();

		int N = Integer.parseInt(bf.readLine());
		int val = 0, end = 0;
		
		for(int i = 1; i <= N; i++) {
			queue.add(i);
		}
		//System.out.println(queue.size());
		
		while(queue.size() > 1) {
			queue.remove();
			val = queue.peek();
			queue.add(val);
			queue.remove();
		}System.out.println(queue.peek());
	}

}
