package Day2.B2164_카드2;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class B2164_카드2_김혜인{
	public static void main(String[] args) throws NumberFormatException, IOException {
	Queue<Integer> q = new LinkedList<>();
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int N  = Integer.parseInt(br.readLine());
	

	for(int i = 1; i <= N; i++) {
	q.offer(i);
	}

	while(q.size() > 1) {
	q.poll();	// 맨 앞의 원소 버림 
	q.offer(q.poll());	
	}

		System.out.println(q.poll());	
	}
}

