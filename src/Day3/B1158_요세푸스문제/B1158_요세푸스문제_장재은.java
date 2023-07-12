package Day3.B1158_요세푸스문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1158_요세푸스문제_장재은 {

	public static void main(String[] args) throws IOException {
		Queue <Integer> que = new ArrayDeque<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(stk.nextToken());
		int k = Integer.parseInt(stk.nextToken());
		for(int i=1; i<=n; i++) que.add(i);
		
		System.out.print("<");
		while(!que.isEmpty()) {
			for(int j=1; j<k; j++)
				que.add(que.poll());
			if(que.size() == 1)	System.out.print(que.poll());
			else System.out.print(que.poll()+", ");
		}
		System.out.print(">");
	}
}