package Day2.B2164_카드2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B2164_카드2_김태선 {

	public static void main(String[] args) throws Exception, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Queue <Integer> card = new LinkedList<>();
		for(int i = 1; i <= N; i++) {
			card.add(i);
		}
		while (card.size() > 1) {
			card.poll();
			card.add(card.poll());
		}
		System.out.println(card.peek());
	}

}
