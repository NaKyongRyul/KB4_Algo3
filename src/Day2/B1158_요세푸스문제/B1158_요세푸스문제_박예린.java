package Day2.B1158_요세푸스문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B1158_요세푸스문제_박예린 {
	public static void main(String[] args) throws IOException {
		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int K = Integer.parseInt(s[1]);
		
		// 초기값
		int front = 0;
		int idx = K-1;
		
		// ArrayList 초기화
		ArrayList <Integer> arrList = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			arrList.add(i+1);
		}
		
		// 초기화
		int size = 0;
		
		StringBuilder builder = new StringBuilder();
		builder.append("<");

		
		// 계산
		for(int i = 0; i < N; i++) {
			int res = arrList.remove(idx);
			builder.append(res);
			
			if(arrList.size() >= 1) {
				builder.append(",");
				builder.append(" ");

			} else {
				builder.append(">");
				System.out.println(builder.toString());
				return;
			}

			size = arrList.size();
			
			front = idx;
			idx = (idx+2)%size;
		}
	}
}
