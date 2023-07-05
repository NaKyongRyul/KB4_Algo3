package Day2.B2164_카드2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class B2164_카드2_윤소민 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());

		Queue<Integer> q = new ArrayDeque<Integer>();
		for(int i=1;i<n+1;i++) {
			q.add(i);
		}

		while(q.size()!=1) {
			q.poll();
			q.add(q.poll());
		}
		System.out.println(q.peek());
	}

}
