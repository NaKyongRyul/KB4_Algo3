package Day3.B1158_요세푸스문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class B1158_요세푸스문제_정지원 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n, k;
		
		String[] strs = br.readLine().split(" ");
		n = Integer.parseInt(strs[0]);
		k = Integer.parseInt(strs[1]);
		
		Queue<Integer> que = new ArrayDeque<>();
		Queue<Integer> ansQue = new ArrayDeque<>();
		
		for(int i=1;i<=n;i++) {
			que.add(i);
		}
		
		int index = 0;
		while(!que.isEmpty()) {
			
			for(int i = 0;i<k-1;i++) {
				que.add(que.poll());
			}
			
			ansQue.add(que.poll());
		}
		
		StringBuilder answer = new StringBuilder();
		
		answer.append("<");
		for(int i=0;i<n-1;i++) {
			answer.append(ansQue.poll());
			answer.append(", ");
		}
		answer.append(ansQue.poll());
		answer.append(">");
		
		System.out.println(answer.toString());
		
	}

}
