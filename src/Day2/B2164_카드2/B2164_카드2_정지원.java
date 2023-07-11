package Day2.B2164_카드2;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class B2164_카드2_정지원 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Queue<Integer> que = new ArrayDeque<>();
			
		int n = sc.nextInt();
		int temp;
		
		for(int i=0;i<n;i++) {
			que.add(i+1);
		}
		
		while(que.size()!=1) {
			que.remove();
			que.add(que.poll());
		}
		
		System.out.println(que.peek());
	}
}
