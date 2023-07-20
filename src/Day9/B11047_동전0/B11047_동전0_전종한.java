package Day9.B11047_동전0;

import java.util.Scanner;
import java.util.Stack;

public class B11047_동전0_전종한 {
	static int N, K;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();

		Stack<Integer> stack = new Stack<>();
		for(int i=0; i<N; i++) stack.push(sc.nextInt());

		int total = 0;
		int cnt = 0;

		while(true) {
			if(total == K) break;
			int coin = stack.peek();
			if((total + coin) <= K) {
				total += coin;
				cnt ++;
			}else stack.pop();
		}

		System.out.println(cnt);
	}
}
