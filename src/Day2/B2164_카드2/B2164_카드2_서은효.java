package Day2.B2164_카드2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class B2164_카드2_서은효 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		Queue <Integer> que = new ArrayDeque<>();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		
		for(int i =1; i<= N ; i++) {
			que.add(i);
		}
		
		int answer = 0;
		for(int i=0;i<N;i++) {
			if(que.size() == 1) {
				answer = que.remove();
				
				break;
			}
			//제일 위에 있는걸 버린다
			que.remove();
			
			//제일 위에 있는 걸 아래로 옮긴다 
			que.add(que.poll());
		}
		System.out.println(answer);
		
	}

}
