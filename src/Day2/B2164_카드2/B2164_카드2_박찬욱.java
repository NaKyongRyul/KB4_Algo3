package Day2.B2164_카드2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class B2164_카드2_박찬욱 {

	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine()); // 카드의 갯수 ex) N=4, ({1,2,3,4} 
		
		Queue <Integer> cards = new ArrayDeque<>();
		for(int i = 1; i <= N; i++) cards.add(i); // 1~N까지 나열된 카드를 queue로 정렬
		
		while(cards.size() != 1) { // 버리고 제일 아래로 옮기는 작업
			cards.remove();
			cards.add(cards.remove());
		}	
		
		System.out.println(cards.peek());
	}
}
