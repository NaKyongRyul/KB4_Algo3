package Day2.B2164_카드2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B2164_카드2_전민형 {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(reader.readLine());
		
		Queue <Integer> que = new LinkedList<>();
		
		for(int i = 1; i<=num; i++) {
			
			que.add(i);
			
		}
		
		while(!(que.size()==1)) {
			
			que.poll();
			que.add(que.poll());
			
		}
		
		System.out.println(que.poll());
		
	}

}
