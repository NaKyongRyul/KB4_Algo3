package Day2.B2164_카드2;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class B2164_카드2_장재은 {
	public static void main(String[] args) {
		Queue <Integer> que = new ArrayDeque<>();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i=1; i<n+1; i++) que.add(i);
		while(que.size() > 1) {
			que.poll();
			que.add(que.poll());	
		}
		System.out.println(que.peek());
		sc.close();
	}
}

