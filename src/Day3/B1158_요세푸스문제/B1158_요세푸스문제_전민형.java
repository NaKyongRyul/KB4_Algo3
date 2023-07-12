package Day3.B1158_요세푸스문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B1158_요세푸스문제_전민형 {

	public static void main(String[] args) throws IOException {

		StringBuilder string = new StringBuilder();
		string.append("<");
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = reader.readLine();
		String [] god = str.split(" ");
		
		int num, king;
		
		Queue <Integer> que = new LinkedList<>();
		
		num = Integer.parseInt(god[0]);
		king = Integer.parseInt(god[1]);
		
		for(int i = 1; i<= num; i++) {
			que.add(i);
		}
		
		while(!que.isEmpty()) {
			
			for(int i = 1; i<king; i++) {
			
			que.add(que.poll());
			
			}
			
			string.append(que.poll());
			if(que.isEmpty())break;
			string.append(", ");
			
			
		}
		
		string.append(">");
		
		System.out.println(string);
		
		
	}

}
