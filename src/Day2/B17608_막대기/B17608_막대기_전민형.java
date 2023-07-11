package Day2.B17608_막대기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B17608_막대기_전민형 {

	public static void main(String[] args) throws IOException {

		
		BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
		
		int N;
		String str;
		Stack <Integer> stc = new Stack<>();
		
		str = buff.readLine();
		N = Integer.parseInt(str);
		
		for(int i = 0; i<N; i++) {
			str = buff.readLine();
			stc.push(Integer.parseInt(str));
			
		}
		
		int pop=stc.peek();
		int big;
		int cnt = 1;
		
		while(!stc.isEmpty()) {
			
			big = stc.pop();
			
			if(pop<big) {
				pop=big;
				cnt++;
			}
			
		}
		
		System.out.println(cnt);
	}

}
