package Day2.B1158_요세푸스문제;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;


public class B1158_요세푸스문제_김태환 {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		Queue<Integer> que = new ArrayDeque<>();
		int N=sc.nextInt();
		int K=sc.nextInt();

		for(int i=1;i<=N;i++) {
			que.add(i);}
		int [] arr= new int[N];
		int j=0;
		while(que.size()>0) {
			for(int i=0;i<K-1;i++) {
				que.add(que.poll());
			}
			arr[j]=que.poll();
			j++;
			
			
		}
		System.out.print("<");
		System.out.print(arr[0]);
		for(int i=1;i<N;i++) {
			
		System.out.print(", "+arr[i]);
		}
		System.out.print(">");

	}

}
