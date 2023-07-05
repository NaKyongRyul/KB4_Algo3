package Day2.B2164_카드2;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class B2164_카드2_조아영 {

	public static void main(String[] args) {
		
		Queue<Integer> queue = new ArrayDeque<>();
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			queue.add(i+1);
		}
		System.out.println();
		
		while(queue.size() > 1) {
			queue.remove();
			int second = queue.remove();
			queue.add(second);	
		}
		
		System.out.println(queue);

	}

}
