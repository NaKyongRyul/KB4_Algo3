
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class B2164_카드2_황지현{
	public static void main(String[] args) {
		Queue <Integer> que1=new ArrayDeque<>();
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		for(int i=0;i<n;i++) {
			que1.offer(i+1);
		}
		while(que1.size()>1) {
			if(que1.size()==1) {
				int answer=que1.peek();
				break;
			}
			que1.poll();
			int v=que1.poll();
			que1.add(v);
			
		}
		System.out.println(que1.peek());
		sc.close();
	}
}
