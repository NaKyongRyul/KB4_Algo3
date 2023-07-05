package Day2.B1158_요세푸스문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1158_요세푸스문제_길민지 {
	public static void main(String [] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// 큐 생성
		Queue<Integer> que = new ArrayDeque<>();
		for (int i=1; i<=N; i++) que.add(i);
		
		// 결과 출력용 StringBuilder
		StringBuilder result = new StringBuilder();
		result.append("<");
		
		while(!que.isEmpty()) {
			for (int i = 0; i<K-1; i++) {
				que.add(que.poll());
			}
			result.append(que.poll());
			if (que.size()!=0) result.append(", "); // 마지막 값이 아닐 경우에만 추가
		}
		
		result.append(">");
		System.out.println(result);
	}
}
