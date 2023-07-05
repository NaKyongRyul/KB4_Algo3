package Day2.B1158_요세푸스문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1158_요세푸스문제_이우엽 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(bf.readLine(), " ");
		int N = Integer.parseInt(token.nextToken()); // 7
		int K = Integer.parseInt(token.nextToken()); // 3번째
		
		// queue, 1 2 3 4 5 6 7
		Queue<Integer> queue = new ArrayDeque<>();
		for(int i = 1; i <= N; i++) {
			queue.add(i);
		}
		StringBuilder builder = new StringBuilder();
		
		builder.append("<");
		int startIdx = 0;
		int removeIdx = K-1;
		//7번을 제거하는 과정을 반복
		for(int i = 0; i < N; i++) { // 7번
			// k번째 수 제거하는 과정
			
			// K-1번째까지 앞에서 빼고 뒤로 넣기
			for(int j = startIdx; j < removeIdx; j++) { // 0, 1
				int current = queue.remove();
				queue.offer(current);
			}
			// K번째 수 제거
			int result = queue.remove();
			if(i == N-1) {
				builder.append(result + ">");
				break;
			}
			builder.append(result+", ");
		}
		
		System.out.println(builder.toString());
		
	}

}
