package Day2.B1158_요세푸스문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class B1158_요세푸스문제_전상희 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(token.nextToken());
		int K = Integer.parseInt(token.nextToken());	
		ArrayDeque que = new ArrayDeque<>();
		ArrayDeque ansQue = new ArrayDeque<>();
		for(int i=0; i<N;i++) {
			que.add(i+1);
		}
		
		while(!que.isEmpty()) {
			for(int i=0; i<K-1; i++) {
				que.add(que.poll());
			}
			ansQue.add(que.poll());
		}
		
		System.out.print("<");
		for(int i=0; i<N-1; i++) {
			System.out.print(ansQue.poll() + ", ");
		}
		System.out.print(ansQue.poll() + ">");
	}

}
