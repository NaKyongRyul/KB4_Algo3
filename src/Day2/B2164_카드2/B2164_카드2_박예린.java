package Day2.B2164_카드2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class B2164_카드2_박예린 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Queue <Integer> que = new ArrayDeque<>();
		

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		
		for(int i = 0; i < N; i++) {
			que.add(i+1); // 카드 초기 위치
			
		}
		System.out.println(que);

		
		int top = 0;
		
		while(que.size() > 1) {
			que.remove();
			top = que.peek();
			que.add(top);
			
			if(que.size()>1) que.remove();
			System.out.println(que);

		}
		System.out.println(que.peek());
	}
}
