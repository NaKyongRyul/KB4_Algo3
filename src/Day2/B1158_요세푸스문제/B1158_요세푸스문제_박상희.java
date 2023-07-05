package Day2.B1158_요세푸스문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1158_요세푸스문제_박상희 {
	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(bf.readLine(), " ");
		
		int N = Integer.parseInt(token.nextToken());
		int K = Integer.parseInt(token.nextToken());
		
		Queue<Integer> que = new ArrayDeque<>();
		
		for(int i = 1; i <= N; i++) {
			que.add(i);
		}
		
		System.out.print("<");
		
		int nPeople = 0;
		while(!que.isEmpty()) {
			for (int i = 0; i < K - 1; i++) {
				que.add(que.poll());
			}
			
			nPeople = que.poll();
			if (que.isEmpty()) {
				System.out.print(nPeople);
			}
			else {
				System.out.print(nPeople + ", ");
			}
		}
		
		System.out.println(">");
	}
}
