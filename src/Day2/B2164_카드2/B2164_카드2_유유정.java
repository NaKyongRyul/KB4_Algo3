package Day2.B2164_카드2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B2164_카드2_유유정 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Queue <Integer> queue1 = new LinkedList<>();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int answer=0;
		for(int i=1;i<N+1;i++) {
			queue1.add(i);
		}
		while(queue1.size()!=1) {
			queue1.remove();
			int ele = queue1.remove();
			queue1.add(ele);
			
		}
		System.out.println(queue1.peek());
	}

}
