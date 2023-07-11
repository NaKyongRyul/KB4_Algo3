package Day2.B2164_카드2;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class B2164_카드2_황혜령 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Queue<Integer> q = new ArrayDeque<Integer>();
		for(int i = 1; i <= n; i++)
			q.add(i);
		while(q.size() != 1) {
			q.poll();
			int tmp = q.poll();
			q.add(tmp);
		}
		System.out.println(q.peek());
	}
}
