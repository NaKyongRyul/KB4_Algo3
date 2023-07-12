package Day3.B1158_요세푸스문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class B1158_요세푸스문제_백미수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String [] strs = reader.readLine().split(" ");
		int N = Integer.parseInt(strs[0]);
		int K= Integer.parseInt(strs[1]);
		
		Queue<Integer> circle = new ArrayDeque<Integer>();
		
		for(int i =1; i<=N; i++ ) {
			circle.add(i);
		}
		
		Queue<Integer> result = new ArrayDeque<Integer>();
		
		while(N-result.size() >= K) {
			for(int i=1; i<=K-1;i++) {
				int peek_num = circle.peek();
				circle.poll();
				circle.add(peek_num);
			}
			int poll_num = circle.peek();
			circle.poll();
			result.add(poll_num);
		}
		
		while(result.size() != N) {
			
			for(int i = 0; i<K-1; i++) {
				int peek_num = circle.peek();
				circle.add(peek_num);
				circle.poll();
			}
			
			int poll_num = circle.peek();
			circle.poll();
			result.add(poll_num);
		}
		StringBuffer sb = new StringBuffer();
		sb.append("<");
		for (int i =0; i<N-1; i++) {
			sb.append(result.peek()+", ");
			result.poll();
		}
		sb.append(result.peek()+">");
		String par = sb.toString();
		System.out.println(par);
	}
}
