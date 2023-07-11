package Day2.B2164_카드2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class B2164_카드2_백미수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine()); //N장의 카드
		
		Queue <Integer> que = new ArrayDeque<Integer>();
		
		for(int i = 1; i<=N; i++) {
			que.add(i);
		}	//N장의 카드 세팅
		
		for(int i=0; i<N-1; i++) {
			que.remove();	//맨 위 버리기
			int peek = que.peek();	//맨 위에 있는 숫자
			
			que.remove();
			que.add(peek);
		}
		System.out.println(que.peek());
	}

}
