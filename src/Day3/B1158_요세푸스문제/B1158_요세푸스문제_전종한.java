package Day3.B1158_요세푸스문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class B1158_요세푸스문제_전종한 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		// N, K 받기
		String [] strs = bf.readLine().split(" ");
		int N = Integer.parseInt(strs[0]);
		int K = Integer.parseInt(strs[1]);
		// Queue, StringBuilder 선언
		Queue <Integer> que = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		// 출력 첫문자
		sb.append("<");
		// 큐 초기화
		for(int i=1; i<N+1; i++) que.offer(i);

		for(int i=0; i<N; i++) {
			// K-1 번 만큼 poll(remove)한 값을 offer(add)
			for(int j=1; j<K; j++) {
				int value = que.poll();
				que.offer(value);
			}
			// K번째 값을 poll해서 StringBuilder에 추가
			int num = que.poll();
			sb.append(num);
			if(i != N-1) sb.append(", ");
		}
		// 마지막 문자 추가
		sb.append(">");
		//출력
		System.out.println(sb);
	}
}
