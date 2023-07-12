package Day3.B1159_요세푸스문제;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class B1159_요세푸스문제_김현지 {

	public static void main(String[] args) {
		Queue <Integer> que = new ArrayDeque<>();
		
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String [] strArr = str.split(" ");
		int N = Integer.parseInt(strArr[0]);
		int K = Integer.parseInt(strArr[1]);
		
		// que에 원소 저장
		for (int i=0; i<N; i++) {
			que.add(i+1);
		}

		// stringBuilder
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		int nextPerson = 0;
		int savedPerson = 0;
		int cnt = 1;
		
		if (K == 1) {
			while (que.size() != 1) {
				sb.append(que.poll() + ", ");
			}
			sb.append(que.poll() + ">");
			System.out.println(sb);
			return;
		}
		
		while (!que.isEmpty()) {
			if (que.size() == 1) {
//				System.out.println("마지막: " + que);
				nextPerson = que.poll();
				sb.append(nextPerson);
				sb.append(">");
				break;
			}
			if (cnt % K == 0) {
				nextPerson = que.poll();
//				System.out.println("nextPerson: "+ nextPerson);
//				System.out.println(que);
				sb.append(nextPerson + ", ");
				cnt++;
			}
			savedPerson = que.poll();
			que.add(savedPerson);
			cnt++;
//			System.out.println("savedPerson: "+ savedPerson);
//			System.out.println(que);
		}
		System.out.println(sb);

	}

}
