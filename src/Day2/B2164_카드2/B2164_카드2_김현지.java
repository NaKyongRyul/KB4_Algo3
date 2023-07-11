package Day2.B2164_카드2;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class B2164_카드2_김현지 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		Queue <Integer> que = new ArrayDeque<>();
		for (int i=0; i<N; i++) {
			que.add(i+1);
		}
		
		int num = 0;
		while (!que.isEmpty()) {
			num = que.poll();
			if (que.isEmpty()){
				break;
			}
			num = que.poll();
			que.add(num);
			
		}
		System.out.println(num);


	}

}
