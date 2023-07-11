package Day2;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {

	public static void main(String[] args) {
		
		// Queue = 인터페이스 객체 , ArrayDeque , LinkedList 로 구현
		Queue <Integer> que1 = new ArrayDeque<>();
		Queue <Integer> que2 = new LinkedList<>();
		
		// add/offer 메소드 = 값 추가
		que1.add(1);
		que1.add(2);
		que1.offer(3);
		que1.add(4);
		System.out.println(que1);
		
		// poll/remove 메소드 = 값 삭제
		int value = que1.poll();
		que1.remove();
		System.out.println(value);
		System.out.println(que1);
		
		// peek 메소드 = que 가장 앞에 값 확인
		System.out.println(que1.peek());
		
		// isEmpty 메소드
		System.out.println(que1.isEmpty());
		
		// clear 메소드
		que1.clear();
		System.out.println(que1.isEmpty());
		
	}
	
}
