package Day2.B17608_막대기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B17608_막대기_박찬욱 {

	public static void main(String[] args) throws NumberFormatException, IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine()); // 막대기의 개수
		
		Stack <Integer> stack = new Stack<>(); // 막대기의 높이를 스택으로 정렬
		for(int i =0; i < N; i++) {
			stack.push(Integer.parseInt(bf.readLine()));
		}
		
		int ans = 0; // 오른쪽에서 보이는 막대기의 개수
		int lastNum = stack.pop(); // 마지막 순서 숫자
		
		while(!stack.isEmpty()) { // 값비교
			int nowNum = stack.pop();
			if(nowNum > lastNum) { // 값이 더 크면 오른쪽에서 보인다.
				ans++;
				lastNum = nowNum;
			}
		}
		System.out.println(ans + 1); // 맨 오른쪽에 있던 것은 무조건 보인다.
	}
}
