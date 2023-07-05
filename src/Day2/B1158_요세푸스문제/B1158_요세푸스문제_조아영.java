package Day2.B1158_요세푸스문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class B1158_요세푸스문제_조아영 {

	public static void main(String[] args) throws IOException {

		Queue<Integer> queue = new ArrayDeque<>();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int b = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			queue.add(i+1);
		}
		
		System.out.print("<");
		while(queue.size()!=0) {
			for(int i=0; i<b-1;i++) {
				queue.add(queue.poll());				
			}
			System.out.print(queue.poll());
			
			if(queue.size()>0) {
				System.out.print(", ");
			}
		}
		System.out.print(">");

	}

}
