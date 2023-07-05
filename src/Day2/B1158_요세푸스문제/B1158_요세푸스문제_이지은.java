package Day2.B1158_요세푸스문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1158_요세푸스문제_이지은 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("<");
		
		Queue <Integer> queue = new ArrayDeque<>();
	
		for(int i=0; i<N; i++) {
			queue.offer((i+1));
		}
		
		while(!queue.isEmpty()) {				
			for(int i=0; i<K-1; i++) {
				queue.offer(queue.poll());
			}
			
			if(queue.size() == 1) 
				builder.append(queue.poll());
			else
				builder.append(queue.poll()+", ");
		}
	
		
		builder.append(">");
		System.out.println(builder);
	}
}
