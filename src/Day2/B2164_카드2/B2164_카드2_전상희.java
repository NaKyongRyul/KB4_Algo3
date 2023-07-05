package Day2.B2164_카드2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class B2164_카드2_전상희 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		Queue que = new ArrayDeque<>();
		
		for(int i=1; i<=N; i++) {
			que.add(i);
		}
		
		while(que.size()!=1) {
			que.poll();
			que.add(que.poll());
		}
		
		System.out.println(que.poll());
	}
}
