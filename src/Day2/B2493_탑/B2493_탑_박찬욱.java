package Day2.B2493_탑;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B2493_탑_박찬욱 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine()); // 탑의 수
		
		StringTokenizer token = new StringTokenizer(bf.readLine());
		
		Stack <Integer> stLocation = new Stack<>(); 
		Stack <Integer> stLength = new Stack<>(); 
		
		for(int i = 1; i <= N; i++) {
			int nowLength = Integer.parseInt(token.nextToken()); // 신호를 보내는 탑의 높이
			while(!stLocation.isEmpty()) {
				if(stLength.peek() < nowLength ) { // 신호를 보낼 탑의 길이가 더 높다면 다음 탑을 확인한다.
					stLocation.pop(); // 다음 탑 확인을 위한 제거
					stLength.pop(); // 다음 탑 확인을 위한 제거 
				}
				else {// 왼편의 탑의 길이가 더 높다면 신호를 보내준다!
					System.out.print(stLocation.peek() + " "); // 신호를 보내줄 탑을 결과로 내보낸다.
					break;
				}
			}
			if(stLength.isEmpty()) System.out.print("0 "); // 더이상 비교할 답이 없을 경우, 0으로 기록
			stLength.push(nowLength); // 신호를 보내는 탑의 높이 기록
			stLocation.push(i);	// 신호를 보내는 탑의 위치 기록
		}
	}
}